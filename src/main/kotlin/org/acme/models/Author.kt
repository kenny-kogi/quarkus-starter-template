package org.acme.models

import java.time.LocalDateTime
import javax.enterprise.context.ApplicationScoped
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@ApplicationScoped
@Entity
data class Author(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var Id:Long?= 0,
        var firstName: String?=null,
        var lastName: String?=null,
        var city: String?=null,

        var createdAt: LocalDateTime?= LocalDateTime.now(),
        var updatedAt: LocalDateTime?= LocalDateTime.now()
) {
        @OneToMany(targetEntity = Book::class, cascade = [CascadeType.ALL])
        @JoinColumn(referencedColumnName = "Id", name = "author_id")
        var book: List<Book>?=null
}

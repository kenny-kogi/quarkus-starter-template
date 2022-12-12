package org.acme.models

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.enterprise.context.ApplicationScoped
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.NotBlank

@ApplicationScoped
@Entity
data class Book(
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   var Id: Long=0,
   @NotBlank(message = "Please provide a book name")
   var name: String?=null,
   var Isbn: String?=null,
   var publisher: String?=null,
   var yearOfPublish: LocalDateTime?=null,

   var createdAt: LocalDateTime?= LocalDateTime.now(),
   var updatedAt: LocalDateTime?= LocalDateTime.now()
) {
   @ManyToOne
   @JsonIgnore
   var author: Author?=null
}

package org.acme.repositories

import io.quarkus.hibernate.orm.panache.PanacheRepository
import org.acme.models.Book
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class BookRepository: PanacheRepository<Book> {
}
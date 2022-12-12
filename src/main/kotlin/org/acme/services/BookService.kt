package org.acme.services

import org.acme.models.Book
import org.acme.repositories.BookRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
@Transactional
class BookService {
    @Inject
    lateinit var bookRepository: BookRepository

    // get all books in db
    fun getAllBooks() = bookRepository.findAll().list<Book>()

    fun getBookById(Id: Long) = bookRepository.findById(Id)

    fun createBook(book: Book) = bookRepository.persist(book)

    fun updateBook(book: Book) {
        val currentBook = bookRepository.findById(book.Id)
        currentBook.name = book.name
        currentBook.Isbn = book.Isbn
        currentBook.publisher = book.publisher
        currentBook.yearOfPublish = book.yearOfPublish
        bookRepository.persist(currentBook)
    }

    fun deleteBook(Id: Long) = bookRepository.deleteById(Id)
}
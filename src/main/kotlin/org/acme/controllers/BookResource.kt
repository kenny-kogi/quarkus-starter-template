package org.acme.controllers

import io.quarkus.hibernate.orm.panache.PanacheQuery
import org.acme.models.Book
import org.acme.services.BookService
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path("book/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class BookResource {
    @Inject
    lateinit var bookService: BookService

    @Path("all")
    @GET
    fun findAllBooks(): MutableList<Book>? = bookService.getAllBooks()

    @Path("create")
    @POST
    fun createBook(@Valid book: Book): Response {
        bookService.createBook(book)
        return Response.ok().entity("Created Successfully").build()
    }

    @Path("edit")
    @PUT
    fun updateBook(@Valid book: Book): Response {
        bookService.updateBook(book)
        return Response.ok().entity("Updated Successfully").build()
    }

    @Path("delete")
    @DELETE
    fun deleteBook(book: Book): Response{
        bookService.deleteBook(book.Id)
        return Response.ok().entity("Deleted Successfully").build()
    }

}
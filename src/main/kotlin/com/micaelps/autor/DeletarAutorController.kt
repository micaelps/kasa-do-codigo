package com.micaelps.autor


import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable


@Controller("/autores/{id}")
class DeletarAutorController(val autores:AutorRepository) {

    @Delete
    fun deleta(@PathVariable id:Long) =
        autores.findById(id)
            .map { a -> autores.delete(a) }
            .map {HttpResponse.ok<Autor>() }
            .orElseGet { HttpResponse.notFound() }

}
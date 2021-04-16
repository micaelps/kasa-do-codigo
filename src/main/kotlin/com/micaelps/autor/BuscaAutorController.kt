package com.micaelps.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import javax.transaction.Transactional

@Controller("/autores")
class BuscaAutorController(val autores: AutorRepository) {

    @Get
    @Transactional
    fun lista(@QueryValue(defaultValue = "") email: String) = when (email) {
        "" -> todos()
        else -> porEmail(email)
    }

    fun todos() = autores.findAll()
        .map { autores -> DetalhesAutorResponse(autores) }
        .let { ds -> HttpResponse.ok(ds) }

    fun porEmail(email: String) = autores.findByEmail(email)
            .map(::DetalhesAutorResponse)
            .map { d: DetalhesAutorResponse -> HttpResponse.ok(d) }
            .orElseGet { HttpResponse.notFound() }


}
package com.micaelps.autor

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import io.netty.handler.codec.http.HttpResponseStatus
import javax.persistence.EntityManager
import javax.swing.text.html.parser.Entity
import javax.validation.Valid

@Validated
@Controller("/autores")
class NovoAutorController(val rep:AutorRepository) {


    @Post
    fun cadastra(@Body @Valid request:NovoAutorRequest) =
        request.toModel()
            .let(rep::save)
}
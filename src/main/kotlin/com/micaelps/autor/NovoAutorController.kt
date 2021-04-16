package com.micaelps.autor

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/autores")
class NovoAutorController(val autores:AutorRepository) {


    @Post
    fun cadastra(@Body @Valid request:NovoAutorRequest) =
        request.toModel()
            .let(autores::save)
}
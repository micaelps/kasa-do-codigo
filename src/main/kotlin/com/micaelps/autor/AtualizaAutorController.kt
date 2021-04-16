package com.micaelps.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put

@Controller("/autores/{id}")
class AtualizaAutorController(val autores:AutorRepository) {

    @Put
    fun atualiza(@PathVariable id: Long, descricao:String) =
        autores.findById(id)
            .map { a -> a.atualizaDescricao(descricao)}
            .map { a->autores.update(a) }
            .map(::DetalhesAutorResponse)
            .map { d -> HttpResponse.ok(d) }
            .orElseGet{ HttpResponse.notFound() }
}
package com.micaelps.autor

class DetalhesAutorResponse(autor: Autor) {

    val nome = autor.nome
    val email = autor.email
    val descricao = autor.descricao
}
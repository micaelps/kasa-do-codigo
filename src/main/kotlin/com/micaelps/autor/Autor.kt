package com.micaelps.autor

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Autor(
    val nome: String?,
    val email: String?,
    var descricao: String?
) {
    fun atualizaDescricao(descricao: String): Autor {
        this.descricao = descricao
        return this
    }

    @Id
    @GeneratedValue
    var id: Long? = null

}

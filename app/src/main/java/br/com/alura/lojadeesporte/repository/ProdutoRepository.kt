package br.com.alura.lojadeesporte.repository

import androidx.lifecycle.LiveData
import br.com.alura.lojadeesporte.database.dao.ProdutoDAO
import br.com.alura.lojadeesporte.model.Produto

class ProdutoRepository(private val dao: ProdutoDAO) {

    fun buscaTodos(): LiveData<List<Produto>> = dao.buscaTodos()

    fun buscaPorId(id: Long): LiveData<Produto> = dao.buscaPorId(id)

}

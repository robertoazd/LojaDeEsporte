package br.com.alura.lojadeesporte.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.lojadeesporte.repository.ProdutoRepository

class DetalhesProdutoViewModel(
    produtoId: Long,
    repository: ProdutoRepository
) : ViewModel() {

    val produtoEncontrado = repository.buscaPorId(produtoId)

}
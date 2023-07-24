package br.com.alura.lojadeesporte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.alura.lojadeesporte.model.Produto
import br.com.alura.lojadeesporte.repository.ProdutoRepository

class ProdutosViewModel(private val repository: ProdutoRepository) : ViewModel() {

    fun buscaTodos(): LiveData<List<Produto>> = repository.buscaTodos()

}

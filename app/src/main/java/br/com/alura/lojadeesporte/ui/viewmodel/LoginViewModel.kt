package br.com.alura.lojadeesporte.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.lojadeesporte.repository.LoginRepository

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    fun loga() {
        repository.loga()
    }

    fun deslogar() {
        repository.desloga()
    }

    fun estaLogado(): Boolean = repository.estaLogado()

    fun naoEstaLogado(): Boolean = !estaLogado()
}

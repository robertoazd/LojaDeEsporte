package br.com.alura.lojadeesporte.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.alura.lojadeesporte.R
import br.com.alura.lojadeesporte.extensions.formatParaMoedaBrasileira
import br.com.alura.lojadeesporte.ui.viewmodel.ComponentesVisuais
import br.com.alura.lojadeesporte.ui.viewmodel.DetalhesProdutoViewModel
import br.com.alura.lojadeesporte.ui.viewmodel.EstadoAppViewModel
import kotlinx.android.synthetic.main.detalhes_produto.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetalhesProdutoFragment : BaseFragment() {

    private val arguments by navArgs<DetalhesProdutoFragmentArgs>()
    private val produtoId by lazy {
        arguments.produtoId
    }
    private val viewModel: DetalhesProdutoViewModel by viewModel { parametersOf(produtoId) }
    private val estadoAppViewModel: EstadoAppViewModel by sharedViewModel()
    private val controlador by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.detalhes_produto,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        estadoAppViewModel.temComponentes = ComponentesVisuais(appBar = true)
        buscaProduto()
        configuraBotaoComprar()
    }

    private fun configuraBotaoComprar() {
        detalhes_produto_botao_comprar.setOnClickListener {
            viewModel.produtoEncontrado.value?.let { produto ->
                vaiParaPagamento()
            }
        }
    }

    private fun vaiParaPagamento() {
        val directions = DetalhesProdutoFragmentDirections
            .actionDetalhesProdutoFragmentToPagamentoFragment(produtoId)
        controlador.navigate(directions)
    }

    private fun buscaProduto() {
        viewModel.produtoEncontrado.observe(viewLifecycleOwner, Observer {
            it?.let { produto ->
                detalhes_produto_nome.text = produto.nome
                detalhes_produto_preco.text = produto.preco.formatParaMoedaBrasileira()
            }
        })
    }

}
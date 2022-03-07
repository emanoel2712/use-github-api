package br.com.evjdev.githubapi.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.evjdev.githubapi.databinding.FragmentMainBinding
import br.com.evjdev.githubapi.extension.*
import br.com.evjdev.githubapi.presentation.model.GistsViewObject
import br.com.evjdev.githubapi.presentation.model.ViewState
import br.com.evjdev.githubapi.presentation.view.activity.MainActivity
import br.com.evjdev.githubapi.presentation.view.adapter.AdapterGists
import br.com.evjdev.githubapi.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private val viewModel by viewModels<MainViewModel>()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onResume() {
        super.onResume()
        viewModel.getGists()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupObservers()
        this.hideToolbar()
    }

    private fun setupObservers() {
        viewModel.viewState.observe(viewLifecycleOwner, {
            this.setViewState(it)
        })

        viewModel.gists.observe(viewLifecycleOwner, {
            this.setupRV(it)
            binding.rvGists.animationPushUpIn()
        })
    }

    private fun setupRV(gists: List<GistsViewObject>) {
        val gistsAdapter = AdapterGists(gists) {
            val directions = MainFragmentDirections.actionMainFragmentToDetailGists(it)
            this.findNavController().navigate(directions)
        }

        binding.rvGists.adapter = gistsAdapter
    }

    private fun setViewState(viewState: ViewState) {
        when (viewState) {
            is ViewState.Loading -> setLoadingState()
            is ViewState.Success -> setSuccessState()
            is ViewState.Error -> setErrorState(viewState.id)
        }
    }

    private fun setLoadingState() {
        binding.progress.visible()
        binding.rvGists.gone()
    }

    private fun setSuccessState() {
        binding.progress.gone()
        binding.rvGists.visible()
    }

    private fun setErrorState(msg: Int) {
        binding.progress.gone()
        this.showSnackBar(getString(msg))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
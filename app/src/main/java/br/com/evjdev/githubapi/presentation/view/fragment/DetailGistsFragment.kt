package br.com.evjdev.githubapi.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import br.com.evjdev.githubapi.R
import br.com.evjdev.githubapi.databinding.FragmentDetailGistsBinding
import br.com.evjdev.githubapi.extension.showToolbar
import br.com.evjdev.githubapi.extension.toDateStr
import com.squareup.picasso.Picasso

class DetailGistsFragment : Fragment() {

    private val args: DetailGistsFragmentArgs by navArgs()
    private var _binding: FragmentDetailGistsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailGistsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupUI()
        this.showToolbar(getString(R.string.detail))
    }

    private fun setupUI() {
        val gistsViewObject = args.gistsViewObject
        Picasso.get().load(gistsViewObject.owner?.avatarUrl).into(binding.ivUser)
        binding.tvDate.text = gistsViewObject.createdAt?.toDateStr()
        binding.tvName.text = gistsViewObject.owner?.login
        binding.tvDesc.text = gistsViewObject.description
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
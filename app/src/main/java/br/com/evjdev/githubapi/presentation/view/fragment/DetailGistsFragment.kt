package br.com.evjdev.githubapi.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.evjdev.githubapi.R
import br.com.evjdev.githubapi.databinding.FragmentDetailGistsBinding
import br.com.evjdev.githubapi.domain.model.Gists
import br.com.evjdev.githubapi.extension.toDateStr
import br.com.evjdev.githubapi.presentation.model.GistsViewObject
import br.com.evjdev.githubapi.utils.Constants
import com.squareup.picasso.Picasso

class DetailGistsFragment : Fragment() {

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
    }

    private fun setupUI() {
        arguments?.let {
            val gists = it.getParcelable<GistsViewObject>(Constants.DETAIL_GISTS)
            Picasso.get().load(gists?.owner?.avatarUrl).into(binding.ivUser)
            binding.tvDate.text = gists?.createdAt?.toDateStr()
            binding.tvName.text = gists?.owner?.login
            binding.tvDesc.text = gists?.description
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
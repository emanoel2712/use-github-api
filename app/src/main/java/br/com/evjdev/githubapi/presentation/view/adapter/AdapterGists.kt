package br.com.evjdev.githubapi.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.evjdev.githubapi.databinding.ItemGistsBinding
import br.com.evjdev.githubapi.presentation.model.GistsViewObject

class AdapterGists(private val gists: List<GistsViewObject>) :
    RecyclerView.Adapter<AdapterGists.GistsViewHolder>() {

    override fun onBindViewHolder(holder: GistsViewHolder, position: Int) {

        val gists = gists[position]

        with(holder) {
//            binding.ivUser
            binding.tvName.text = ""


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistsViewHolder {
        val itemView = ItemGistsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GistsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return gists.size
    }


    inner class GistsViewHolder(val binding: ItemGistsBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}
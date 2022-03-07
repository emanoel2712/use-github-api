package br.com.evjdev.githubapi.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.evjdev.githubapi.R
import br.com.evjdev.githubapi.databinding.ItemGistsBinding
import br.com.evjdev.githubapi.extension.animationPushRightToLeft
import br.com.evjdev.githubapi.extension.animationPushLeftToRight
import br.com.evjdev.githubapi.extension.toDateStr
import br.com.evjdev.githubapi.presentation.model.GistsViewObject
import com.squareup.picasso.Picasso

class AdapterGists(private val gists: List<GistsViewObject>) :
    RecyclerView.Adapter<AdapterGists.GistsViewHolder>() {

    var clickIn: (gists: GistsViewObject) -> Unit = {}

    override fun onBindViewHolder(holder: GistsViewHolder, position: Int) {

        if (position % 2 == 0) holder.itemView.animationPushLeftToRight() else holder.itemView.animationPushRightToLeft()

        val gists = gists[position]

        with(holder) {
            binding.tvName.text = gists.owner?.login
            binding.tvCreatedDate.text = gists.createdAt?.toDateStr()
            Picasso.get().load(gists.owner?.avatarUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background).into(binding.ivUser)
        }

        holder.itemView.setOnClickListener {
            this.clickIn(gists)
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
package br.com.evjdev.githubapi.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.evjdev.githubapi.R
import br.com.evjdev.githubapi.databinding.ItemGistsBinding
import br.com.evjdev.githubapi.extension.animationPushLeftToRight
import br.com.evjdev.githubapi.extension.animationPushRightToLeft
import br.com.evjdev.githubapi.extension.toDateStr
import br.com.evjdev.githubapi.presentation.model.GistsViewObject
import com.squareup.picasso.Picasso

class AdapterGists(
    private val gists: List<GistsViewObject>,
    private val onItemClickListener: ((gistsViewObject: GistsViewObject) -> Unit),
) :
    RecyclerView.Adapter<AdapterGists.GistsViewHolder>() {

    override fun onBindViewHolder(holder: GistsViewHolder, position: Int) {
        if (position % 2 == 0) holder.itemView.animationPushLeftToRight() else holder.itemView.animationPushRightToLeft()
        val item = gists[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistsViewHolder {
        val itemView = ItemGistsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GistsViewHolder(itemView)
    }

    inner class GistsViewHolder(private val binding: ItemGistsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: GistsViewObject) {
            with(binding) {
                tvName.text = data.owner?.login
                tvCreatedDate.text = data.createdAt?.toDateStr()
                Picasso.get().load(data.owner?.avatarUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background).into(ivUser)

                itemView.setOnClickListener {
                    onItemClickListener.invoke(data)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return gists.size
    }
}
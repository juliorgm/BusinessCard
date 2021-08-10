package br.com.cuiadigital.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.cuiadigital.businesscard.R
import br.com.cuiadigital.businesscard.data.BusinessCard
import br.com.cuiadigital.businesscard.databinding.ItemCardBinding

class BusinessCardAdapter: ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {
    inner class ViewHolder (private val binding: ItemCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: BusinessCard){
            binding.itemName.text = item.name
            binding.itemEmail.text = item.email
            binding.itemPhoneNumber.text = item.phoneNumber
            binding.itemCompanyName.text = item.company
            binding.card.setCardBackgroundColor(item.cardColor)
            binding.card.setOnClickListener {
                listnerShare(it)
            }
        }
    }

    var listnerShare: (View) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemBusinessCard = getItem(position)
        holder.bind(itemBusinessCard)
    }
}

class DiffCallback: DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean {
        return oldItem.equals(newItem)
    }


    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean {
        return oldItem.id == newItem.id
    }

}

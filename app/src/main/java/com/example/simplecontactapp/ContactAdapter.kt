package com.example.simplecontactapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplecontactapp.databinding.ItemContactBinding


class ContactAdapter(
    private val list: List<Contact>,
    private val onEdit:(Contact)->Unit,
    private val onDelete:(Contact)->Unit
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

class ViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = list[position]

        holder.binding.name.text = contact.name
        holder.binding.mobile.text = contact.mobile

        holder.binding.edit.setOnClickListener {
            onEdit(contact)
        }
        holder.binding.delete.setOnClickListener {
            onDelete(contact)
        }



    }

    override fun getItemCount(): Int = list.size


}
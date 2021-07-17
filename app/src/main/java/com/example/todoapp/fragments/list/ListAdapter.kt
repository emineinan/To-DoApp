package com.example.todoapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.models.Priority
import com.example.todoapp.data.models.ToDoData
import com.example.todoapp.databinding.RowItemBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    var dataList = emptyList<ToDoData>()

    class MyViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.binding.textViewTitle.text = currentItem.title
        holder.binding.textViewDescription.text = currentItem.description

        val priority = currentItem.priority
        when (priority) {
            Priority.HIGH -> holder.binding.cardViewPriorityIndicator.setBackgroundColor(
                ContextCompat.getColor(holder.itemView.context, R.color.red)
            )
            Priority.MEDIUM -> holder.binding.cardViewPriorityIndicator.setBackgroundColor(
                ContextCompat.getColor(holder.itemView.context, R.color.yellow)
            )
            Priority.LOW -> holder.binding.cardViewPriorityIndicator.setBackgroundColor(
                ContextCompat.getColor(holder.itemView.context, R.color.green)
            )
        }
    }

    fun setData(toDoData: List<ToDoData>) {
        this.dataList = toDoData
        notifyDataSetChanged()
    }
}
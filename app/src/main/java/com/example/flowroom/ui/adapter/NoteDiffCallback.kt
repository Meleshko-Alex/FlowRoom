package com.example.flowroom.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.flowroom.repository.room.Note

class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem

}
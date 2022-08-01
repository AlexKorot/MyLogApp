package com.onix.internship.notes


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.R
import com.onix.internship.databinding.NoteListItemBinding
import com.onix.internship.domain.entity.NoteItem

class NoteAdapter : ListAdapter<NoteItem, NoteAdapter.NoteViewHolder>(WordsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.setData(getItem(position))
    }

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding= NoteListItemBinding.bind(view)
        fun setData(note:NoteItem, )=with(binding){


            tvTitle.text=note.name
            tvDesripription.text=note.content

            //imButtonDelete.setOnClickListener {
              //  listener.deleteItem(note.id!!)
          //  }
           // itemView.setOnClickListener {
             //   listener.onClickItem(note)
            //}


        }

        companion object {
            fun create(parent: ViewGroup): NoteViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.note_list_fragment, parent, false)
                return NoteViewHolder(view)
            }
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<NoteItem>() {
        override fun areItemsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean {
            return oldItem.id == newItem.id
        }
    }
}




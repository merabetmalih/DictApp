package com.malih.dictapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(val words:List<Word>, val context: Context, val onClick:(word:Word)->Unit):RecyclerView.Adapter<WordsAdapter.WordViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.word_view_holder, parent,false)
        val wordHolder = WordViewHolder(view)
        return wordHolder
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.update(words[position])
        holder.itemView.setOnClickListener {
            onClick(words[position])
        }
    }

    override fun getItemCount() = words.size

    class WordViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        private val wordName: TextView = itemView.findViewById(R.id.word_name)

        fun update(word: Word){
            wordName.text = word.name
        }
    }
}
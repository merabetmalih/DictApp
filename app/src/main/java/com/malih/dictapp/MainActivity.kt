package com.malih.dictapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val words = listOf(
        Word("Elephant", "L&#39;éléphant  adulte pèse 2 à 3 tonnes. ... L&#39;éléphant a une longue trompe pour boire et pour se\n" +
                "doucher et lui servant aussi de défense, il peut aussi porter des troncs d&#39;arbre avec sa trompe.\n" +
                "L&#39;éléphant a des défenses en ivoire qui lui servent à attaquer, à déterrer des racines.","elephant_vide",R.raw.elephant,R.drawable.download),
        Word("L'épée","(du latin spatha, « chose plate ») est une arme blanche à double tranchant (se distinguant ainsi\n" +
                "du sabre) composée d&#39;une lame droite en métal pourvue le cas échéant d&#39;une gouttière\n" +
                "(dépression longitudinale), d&#39;une poignée et, à certaines époques, d&#39;une garde protégeant la\n" +
                "main et d&#39;un pommeau." ,"knife_vide",R.raw.knife,R.drawable.knife),
        Word("Test","Test")

    )
    private lateinit var adapter: WordsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("DEBUG",words.toString())
        adapter = WordsAdapter(words,this){
            val intent = Intent(this@MainActivity,DetailActivity::class.java)
            intent.putExtra(PARCELABLE_DETAIL_WORD,it)
            startActivity(intent)
        }

        dict_recycler_view.let {
            it.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            it.adapter = adapter
        }


    }
    companion object{
        const val PARCELABLE_DETAIL_WORD = "PARCELABLE_DETAIL_WORD"
    }
}
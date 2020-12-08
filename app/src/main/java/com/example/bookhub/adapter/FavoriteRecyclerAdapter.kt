package com.example.bookhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhub.R
import com.example.bookhub.database.BookEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_favorite_single_row.view.*
import org.w3c.dom.Text

class FavoriteRecyclerAdapter(val context: Context,val bookList: List<BookEntity>): RecyclerView.Adapter<FavoriteRecyclerAdapter.FavoriteViewHolder>() {

    class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvBookName: TextView = view.findViewById(R.id.tvFavBookTitle)
        val tvBookAuthor: TextView = view.findViewById(R.id.tvFavBookAuthor)
        val tvBookPrice: TextView = view.findViewById(R.id.tvFavBookPrice)
        val tvBookRating: TextView = view.findViewById(R.id.tvFavBookRating)
        val imgBookImage: ImageView = view.findViewById(R.id.imgFavBookImage)
        val llContent: LinearLayout = view.findViewById(R.id.llFavContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_favorite_single_row,parent,false)
        return FavoriteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val book = bookList[position]

        holder.tvBookName.text = book.bookName
        holder.tvBookAuthor.text = book.bookAuthor
        holder.tvBookPrice.text = book.bookPrice
        holder.tvBookRating.text = book.bookRating
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage)
    }

}
package com.example.bookhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhub.R
import com.example.bookhub.activity.DescriptionActivity
import com.example.bookhub.model.Book
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.recycler_dashboard_single_row.view.*
import org.w3c.dom.Text

class DashboardRecyclerAdapter(val context: Context,val itemList: ArrayList<Book>) : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

        class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view){
            val textViewBookName: TextView = view.findViewById(R.id.tvBookName)
            val textViewBookAuthor: TextView = view.findViewById(R.id.tvBookAuthor)
            val textViewBookPrice: TextView = view.findViewById(R.id.tvBookPrice)
            val textViewBookRating: TextView = view.findViewById(R.id.tvBookRating)
            val imgBook: ImageView = view.findViewById(R.id.imgBookImage)
            val llContent: LinearLayout = view.findViewById(R.id.llContent)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book = itemList[position]
        holder.textViewBookName.text = book.bookName
        holder.textViewBookAuthor.text = book.bookAuthor
        holder.textViewBookPrice.text = book.bookPrice
        holder.textViewBookRating.text = book.bookRating
        //holder.imgBook.setImageResource(book.bookImage)
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBook)

        holder.llContent.setOnClickListener {
            val intent = Intent(context,DescriptionActivity::class.java)
            intent.putExtra("book_id",book.bookId)
            context.startActivity(intent)
        }

    }
}
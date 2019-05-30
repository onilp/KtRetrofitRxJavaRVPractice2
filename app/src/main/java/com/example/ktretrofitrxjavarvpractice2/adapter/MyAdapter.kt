package com.example.ktretrofitrxjavarvpractice2.adapter

import android.content.Context
import android.graphics.ColorSpace
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ktretrofitrxjavarvpractice2.R
import com.example.ktretrofitrxjavarvpractice2.model.Model
import kotlinx.android.synthetic.main.list_item.view.*

class MyAdapter(val context : Context, val commentList : List<Model.Comment>) : RecyclerView.Adapter<MyAdapter.MyViewHolder> (){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.list_item,p0,false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    override fun onBindViewHolder(p0: MyAdapter.MyViewHolder, p1: Int) {
        p0.bindValues(commentList.get(p1))
    }

    class MyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindValues(comment : Model.Comment){
            itemView.tv_postId.text = comment.postId.toString()
            itemView.tv_id.text = comment.id.toString()
            itemView.tv_name.text = comment.name
            itemView.tv_email.text =comment.email
            itemView.tv_body.text = comment.body

        }

    }

}
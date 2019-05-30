package com.example.ktretrofitrxjavarvpractice2

import android.graphics.ColorSpace
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.ktretrofitrxjavarvpractice2.adapter.MyAdapter
import com.example.ktretrofitrxjavarvpractice2.model.Model
import com.example.ktretrofitrxjavarvpractice2.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiInterface = ApiInterface.getRetrofitInstance().getComments()
        apiInterface.enqueue(object : Callback<List<Model.Comment>>{
            override fun onFailure(call: Call<List<Model.Comment>>, t: Throwable) {
                //Log.e("Error --" + t.message)
            }

            override fun onResponse(call: Call<List<Model.Comment>>, response: Response<List<Model.Comment>>) {
                myAdapter = MyAdapter(this@MainActivity,response.body()!!)
                recyclerView.adapter = myAdapter
                myAdapter.notifyDataSetChanged()


            }

        })

    }
}

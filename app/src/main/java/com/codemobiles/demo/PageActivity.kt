package com.codemobiles.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_page.*
import kotlinx.android.synthetic.main.model.view.*
import org.tensorflow.lite.Interpreter


class PageActivity : AppCompatActivity() {

    lateinit var  myrecyclerView: RecyclerView
    lateinit var mDatabase: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        mDatabase = FirebaseDatabase.getInstance().getReference("CollectionShoes")
        myrecyclerView = findViewById(R.id.myrecyclerView)
        myrecyclerView.setHasFixedSize(true)
        myrecyclerView.setLayoutManager(LinearLayoutManager(this))

        logRecyclerView()
        camera.setOnClickListener {
            val intent = Intent(this,UploadImage::class.java)
            startActivity(intent)

        }



    }

    private fun logRecyclerView(){
        var FirebaseRecyclerAdapter = object : FirebaseRecyclerAdapter<CollectionShoes,UsersViewHolder>(

                CollectionShoes::class.java,
                R.layout.model,
                UsersViewHolder::class.java,
                mDatabase


        ){
            override fun populateViewHolder(viewHolder: UsersViewHolder, model: CollectionShoes, position: Int) {

                viewHolder.sView.post_title.setText(model.title)
                viewHolder.sView.post_price.setText(model.PRICE)
                Picasso.with(this@PageActivity).load(model.ImageUrl).into(viewHolder.sView.post_image)




            }

        }
        myrecyclerView.adapter=FirebaseRecyclerAdapter
    }

    class  UsersViewHolder(var sView : android.view.View) : RecyclerView.ViewHolder(sView){

    }



}
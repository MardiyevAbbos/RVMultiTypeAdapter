package com.example.rvmultitypeadapter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rvmultitypeadapter.R
import com.example.rvmultitypeadapter.adapter.MemberAdapter
import com.example.rvmultitypeadapter.model.Member

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        val members = prepareMemberList()
        refreshAdapter(members)

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
    }


    private fun refreshAdapter(members: List<Member>) {
        val adapter = MemberAdapter(members)
        recyclerView.adapter = adapter
    }


    private fun prepareMemberList(): List<Member> {
        val members: ArrayList<Member> = ArrayList()

        for (i in 1..30) {
            if (i == 2 || i == 5 || i == 9 || i == 11 || i == 15 || i == 20 || i == 21 || i == 27) {
                members.add(Member("$i)Lionel", "$i)Messi", false))
            } else {
                members.add(Member("$i)Lionel", "$i)Messi", true))
            }
        }
        return members
    }

}
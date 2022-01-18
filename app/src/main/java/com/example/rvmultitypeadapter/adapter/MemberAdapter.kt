package com.example.rvmultitypeadapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rvmultitypeadapter.R
import com.example.rvmultitypeadapter.model.Member

class MemberAdapter(val members: List<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_AVAILABLE_YES: Int = 0
    private val TYPE_AVAILABLE_NO: Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_AVAILABLE_YES) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_member_layout_yes, parent, false)
            return MemberViewYesHolder(view)
        }

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_member_layout_not, parent, false)
        return MemberViewNotHelper(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members.get(position)
        if (holder is MemberViewYesHolder) {
            holder.apply {
                firstNameYes.setText(member.firstName)
                lastNameYes.setText(member.lastName)
            }
        }

        if (holder is MemberViewNotHelper) {
            holder.apply {
                firstNameNot.setText(member.firstName)
                lastNameNot.setText(member.lastName)
            }
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun getItemViewType(position: Int): Int {
        val member = members.get(position)

        if (member.available) {
            return TYPE_AVAILABLE_YES
        } else {
            return TYPE_AVAILABLE_NO
        }
    }


    class MemberViewYesHolder(view: View) : RecyclerView.ViewHolder(view) {
        val firstNameYes = view.findViewById<TextView>(R.id.first_name_yes)
        val lastNameYes = view.findViewById<TextView>(R.id.last_name_yes)
    }


    class MemberViewNotHelper(view: View) : RecyclerView.ViewHolder(view) {
        val firstNameNot = view.findViewById<TextView>(R.id.first_name_no)
        val lastNameNot = view.findViewById<TextView>(R.id.last_name_no)
    }


}
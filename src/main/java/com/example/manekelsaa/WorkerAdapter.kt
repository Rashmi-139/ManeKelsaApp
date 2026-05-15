package com.example.manekelsaa

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkerAdapter(private val list: List<Worker>) :
    RecyclerView.Adapter<WorkerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView =
            itemView.findViewById(R.id.tvName)

        val skill: TextView =
            itemView.findViewById(R.id.tvSkill)

        val tvAvailability: TextView =
            itemView.findViewById(R.id.tvAvailability)

        val callBtn: Button =
            itemView.findViewById(R.id.btnCall)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_worker, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val worker = list[position]

        holder.name.text = worker.name

        holder.skill.text = worker.skill

        holder.tvAvailability.text = "Available"

        holder.callBtn.setOnClickListener {

            val context = holder.itemView.context

            val intent = Intent(Intent.ACTION_DIAL)

            intent.data = Uri.parse("tel:" + worker.phone)

            context.startActivity(intent)
        }

        holder.itemView.setOnClickListener {

            val context = holder.itemView.context

            val intent = Intent(
                context,
                WorkerDetailActivity::class.java
            )

            intent.putExtra("name", worker.name)
            intent.putExtra("skill", worker.skill)
            intent.putExtra("phone", worker.phone)
            intent.putExtra("address", worker.address)
            intent.putExtra("experience", worker.experience)
            intent.putExtra("dob", worker.dob)
            intent.putExtra("dailyRate", worker.dailyRate)

            context.startActivity(intent)
        }
    }
}
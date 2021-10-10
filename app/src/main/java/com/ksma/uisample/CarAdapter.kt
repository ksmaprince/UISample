package com.ksma.uisample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    var cars: List<Car> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_car,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = cars.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        Picasso.get().load(cars[position].picurl).fit()
            .into(holder.itemView.findViewById<ImageView>(R.id.ivCarImage))
        holder.itemView.findViewById<TextView>(R.id.tvTitle).text = cars[position].title
        holder.itemView.findViewById<TextView>(R.id.tvModel).text = cars[position].model
    }

    interface OnItemClickListener {
        fun onItemClick()
    }

    private var listener: OnItemClickListener? = null


    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.findViewById<ConstraintLayout>(R.id.ctrCarItem).setOnClickListener {
                val position = adapterPosition
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener!!.onItemClick()
                }
            }
        }
    }
}
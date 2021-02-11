package com.example.maskinfo

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maskinfo.model.Store

class StoreViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var nameTextureView:TextView = itemView.findViewById(R.id.name_text_view)
    var addressTextView:TextView = itemView.findViewById(R.id.addr_text_view)
    var distanceTextView:TextView = itemView.findViewById(R.id.distance_text_view)
    var remainTextView:TextView = itemView.findViewById(R.id.reamain_text_view)
    var countTextView:TextView = itemView.findViewById(R.id.count_text_view)

}

class StoreAdapter : RecyclerView.Adapter<StoreViewHolder?>() {
    private var mItems: List<Store> = ArrayList<Store>()

    fun updateItems(items:List<Store>){
        mItems = items
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_store,parent,false)
        return StoreViewHolder(view)
    }

    override fun getItemCount() = mItems.size


    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val store : Store = mItems[position]
        holder.nameTextureView.text = store.name
        holder.addressTextView.text = store.addr
        holder.distanceTextView.text = "1km"
    }

}
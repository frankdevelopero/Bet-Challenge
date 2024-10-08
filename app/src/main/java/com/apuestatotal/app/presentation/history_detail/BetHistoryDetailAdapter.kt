package com.apuestatotal.app.presentation.history_detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apuestatotal.app.R
import com.apuestatotal.app.domain.entity.BetHistoryDetailEntity

class BetHistoryDetailAdapter(private var betHistoryList: List<BetHistoryDetailEntity>, private val listenerOnClick: OnItemClickListener) : RecyclerView.Adapter<BetHistoryDetailAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(betHistory: BetHistoryDetailEntity, view: View)
    }



    class ViewHolder(
        view: View,
        private val listenerOnClick: OnItemClickListener,
        private val betHistoryList: List<BetHistoryDetailEntity>
    ) : RecyclerView.ViewHolder(view)  {

        init {
            view.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listenerOnClick.onItemClick(betHistoryList[position], view)
                }
            }
        }

        var tvBetDate: TextView = view.findViewById(R.id.tvBetDate)
        var tvBetQuot: TextView = view.findViewById(R.id.tvBetQuotItem)
        var tvBetMarketName: TextView = view.findViewById(R.id.tvBetMarketName)
        var tvBetEventName: TextView = view.findViewById(R.id.tvBetEventName)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bet_history_detail, parent, false)
        return ViewHolder(view, listenerOnClick, betHistoryList)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val betHistory = betHistoryList[position]
        holder.tvBetDate.text = betHistory.eventDate
        holder.tvBetQuot.text = betHistory.price
        holder.tvBetEventName.text = betHistory.eventName
        holder.tvBetMarketName.text = betHistory.marketName

    }

    override fun getItemCount() = betHistoryList.size

    fun updateData(newBetHistoryList: List<BetHistoryDetailEntity>) {
        betHistoryList = newBetHistoryList
        notifyDataSetChanged()
    }

}

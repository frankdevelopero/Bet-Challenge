package com.apuestatotal.app.presentation.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apuestatotal.app.R
import com.apuestatotal.app.domain.entity.BetHistoryEntity

class BetHistoryAdapter(private val betHistoryList: List<BetHistoryEntity>, private val listenerOnClick: OnItemClickListener) : RecyclerView.Adapter<BetHistoryAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(betHistory: BetHistoryEntity, view: View)
    }


    class ViewHolder(
        view: View,
        private val listenerOnClick: OnItemClickListener,
        private val betHistoryList: List<BetHistoryEntity>
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
        var tvBetStatus: TextView = view.findViewById(R.id.tvBetStatus)
        var tvBetType: TextView = view.findViewById(R.id.tvBetType)
        var tvBetPayment: TextView = view.findViewById(R.id.tvBetPayment)
        var tvBetAmount: TextView = view.findViewById(R.id.tvBetAmount)
        var tvBetQuot: TextView = view.findViewById(R.id.tvBetQuot)
        var tvBetTitle: TextView = view.findViewById(R.id.tvBetTitle)
        var tvBetMatch: TextView = view.findViewById(R.id.tvBetMatch)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bet_history, parent, false)
        return ViewHolder(view, listenerOnClick, betHistoryList)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val betHistory = betHistoryList[position]
        holder.tvBetType.transitionName = "betTypeTextTransition_${betHistory.db}"
        holder.tvBetDate.text = betHistory.createdDate
        holder.tvBetStatus.text = betHistory.status
        holder.tvBetType.text = betHistory.type
        holder.tvBetPayment.text = betHistory.winning?.toString() ?: "0.00"
        holder.tvBetAmount.text = "S/ ${betHistory.wager}"
        holder.tvBetQuot.text = betHistory.odds.toString()
        holder.tvBetMatch.text = betHistory.eventName
        holder.tvBetTitle.text = betHistory.marketName

        holder.itemView.setOnClickListener {
            listenerOnClick.onItemClick(betHistory, holder.tvBetType)
        }

        when (betHistory.status) {
            "WON" -> holder.tvBetStatus.setBackgroundResource(R.drawable.textview_background_green)
            "LOST" -> holder.tvBetStatus.setBackgroundResource(R.drawable.textview_background_red)
            else -> holder.tvBetStatus.setBackgroundResource(R.drawable.textview_background_blue)
        }
    }

    override fun getItemCount() = betHistoryList.size
}

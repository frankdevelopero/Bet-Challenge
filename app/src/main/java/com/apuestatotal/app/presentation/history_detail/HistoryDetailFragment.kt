package com.apuestatotal.app.presentation.history_detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.apuestatotal.app.R
import com.apuestatotal.app.databinding.FragmentHistoryDetailBinding
import com.apuestatotal.app.domain.entity.BetHistoryDetailEntity
import com.apuestatotal.app.domain.entity.BetHistoryEntity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HistoryDetailFragment : Fragment() {

    private lateinit var binding: FragmentHistoryDetailBinding
    private val betHistoryViewModel: BetHistoryDetailViewModel by viewModels()
    private lateinit var betHistoryDetailAdapter: BetHistoryDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: HistoryDetailFragmentArgs by navArgs()
        val betHistory = args.betHistory

        initRecyclerView()

        setupObservers()

        betHistoryViewModel.fetchBetHistoryDetail(betHistory.game)
        settingViews(betHistory)


    }

    private fun settingViews(betHistory: BetHistoryEntity){
        binding.tvBetDetailType.text = betHistory.type
        binding.tvBetPayment.text = betHistory.winning?.toString() ?: "0.00"
        binding.tvBetTitle.text = betHistory.marketName
        binding.tvBetMatch.text = betHistory.eventName
        binding.tvBetAmount.text = betHistory.wager.toString()
        binding.tvBetQuot.text = betHistory.odds.toString()
        binding.tvBetStatus.text = betHistory.status
        binding.tvBetDate.text = betHistory.createdDate

        when (betHistory.status) {
            "WON" -> binding.tvBetStatus.setBackgroundResource(R.drawable.textview_background_green)
            "LOST" -> binding.tvBetStatus.setBackgroundResource(R.drawable.textview_background_red)
            else -> binding.tvBetStatus.setBackgroundResource(R.drawable.textview_background_blue)
        }

        binding.imgBack.setOnClickListener {
            findNavController().navigate(R.id.action_historyDetailFragment2_to_historyFragment)
        }

    }

    private fun initRecyclerView() {
        betHistoryDetailAdapter = BetHistoryDetailAdapter(emptyList(), object : BetHistoryDetailAdapter.OnItemClickListener {
            override fun onItemClick(betHistory: BetHistoryDetailEntity, view: View) {
            }
        })

        binding.recyclerViewBetDetail.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = betHistoryDetailAdapter
        }
    }


    private fun setupObservers() {
        betHistoryViewModel.betHistory.observe(viewLifecycleOwner) { betDetails ->
            betHistoryDetailAdapter.updateData(betDetails)
        }

        betHistoryViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        betHistoryViewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                Log.e("APIRESPONSE====>>>> ", "Error: ${it.message}")
                Toast.makeText(requireContext(), "Error: ${it.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

}
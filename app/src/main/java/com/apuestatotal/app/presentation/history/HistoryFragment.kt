package com.apuestatotal.app.presentation.history

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.apuestatotal.app.databinding.FragmentHistoryBinding
import com.apuestatotal.app.domain.entity.BetHistoryEntity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    private val betHistoryViewModel: BetHistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupViews()
        betHistoryViewModel.fetchBetHistory()
    }

    private fun setupViews() {
        val statuses = arrayOf("Todas", "Ganadas", "Perdidas", "Abiertas")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, statuses)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.statusSpinner.adapter = adapter
        binding.statusSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedStatus = parent.getItemAtPosition(position) as String
                betHistoryViewModel.filterBetHistory(selectedStatus)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        binding.searchField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                betHistoryViewModel.searchBetHistory(s.toString())
            }
        })



    }

    private fun setupObservers() {
        betHistoryViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.shimmerFrameLayout.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.recyclerView.visibility = if (isLoading) View.GONE else View.VISIBLE
        }

        betHistoryViewModel.betHistory.observe(viewLifecycleOwner) { betHistory ->
            val adapter = BetHistoryAdapter(betHistory, object : BetHistoryAdapter.OnItemClickListener {
                override fun onItemClick(betHistory: BetHistoryEntity, view: View) {
                    val action = HistoryFragmentDirections
                        .actionHistoryFragmentToHistoryDetailFragment2(betHistory)

                    val extras = FragmentNavigatorExtras(view to "betTypeTextTransition_${betHistory.db}")
                    findNavController().navigate(action, extras)

                }
            })
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
        }

        betHistoryViewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                Log.e("APIRESPONSE====>>>> ", "Error: ${it.message}")
                Toast.makeText(requireContext(), "Error: ${it.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}

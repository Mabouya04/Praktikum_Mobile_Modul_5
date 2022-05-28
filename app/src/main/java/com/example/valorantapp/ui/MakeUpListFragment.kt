package com.example.valorantapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.valorantapp.R
import com.example.valorantapp.databinding.FragmentMakeupDetailBinding
import com.example.valorantapp.databinding.FragmentMakeupListBinding

class MakeUpListFragment : Fragment() {
    private val viewModel: MakeUpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMakeupListBinding.inflate(inflater)
        viewModel.getMakeUpList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = MakeUpListAdapter(MakeUpListener { dataItem ->
            viewModel.onMakeUpClicked(dataItem)
            findNavController()
                .navigate(R.id.action_MakeUpListFragment_to_MakeUpDetailFragment)
        })

        return binding.root

    }
}
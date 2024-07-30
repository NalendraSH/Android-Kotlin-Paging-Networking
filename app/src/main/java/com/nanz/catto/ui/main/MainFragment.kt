package com.nanz.catto.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nanz.catto.databinding.FragmentMainBinding
import com.nanz.catto.ui.adapter.MainAdapter
import com.nanz.catto.ui.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val mainViewModel: MainViewModel by inject()
    private val adapter: MainAdapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMain.adapter = adapter

        mainViewModel.getCatList(1, 7).observe(viewLifecycleOwner) { response ->
            activity?.runOnUiThread {
                Log.d("TAG", "onViewCreated: ")
                response.data?.let { catResponse ->
                    adapter.addData(catResponse)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

}
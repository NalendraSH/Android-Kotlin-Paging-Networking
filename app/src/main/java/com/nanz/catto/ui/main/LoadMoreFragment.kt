package com.nanz.catto.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nanz.catto.R
import com.nanz.catto.databinding.FragmentLoadMoreBinding
import com.nanz.catto.ui.adapter.LoadMorePagingAdapter
import com.nanz.catto.ui.adapter.LoadingStateAdapter
import com.nanz.catto.ui.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class LoadMoreFragment : Fragment() {

    private lateinit var binding: FragmentLoadMoreBinding
    private val mainViewModel: MainViewModel by inject()
    private val adapter by lazy { LoadMorePagingAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoadMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvLoadMore.adapter = adapter.withLoadStateFooter(
            footer = LoadingStateAdapter {
                adapter.retry()
            }
        )
        mainViewModel.catListPaging.observe(viewLifecycleOwner) {
            adapter.submitData(lifecycle, it)
        }
    }

}
package com.katyshevtseva.features_content.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.katyshevtseva.features_content.ComponentContainer
import com.katyshevtseva.features_content.R
import com.katyshevtseva.features_content.databinding.FragmentFavouritesBinding
import com.katyshevtseva.features_content.presentation.adapter.CourseAdapter
import com.katyshevtseva.features_content.presentation.util.showAlertDialog
import com.katyshevtseva.features_content.presentation.viewmodel.FavouritesViewModel
import com.katyshevtseva.features_content.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class FavouritesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[FavouritesViewModel::class.java]
    }

    private var _binding: FragmentFavouritesBinding? = null
    private val binding: FragmentFavouritesBinding
        get() = _binding ?: throw RuntimeException("FragmentFavouritesBinding is null")

    private val courseAdapter = CourseAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ComponentContainer.component.inject(this)
        observeViewModel()

        binding.coursesRecyclerView.setAdapter(courseAdapter)
        courseAdapter.likeButtonListener = { viewModel.likeButtonListener(it) }
    }

    private fun observeViewModel() {
        viewModel.coursesLD.observe(viewLifecycleOwner) {
            courseAdapter.submitList(it)
        }
        viewModel.errorLD.observe(viewLifecycleOwner) {
            showAlertDialog(
                requireActivity(),
                resources.getString(R.string.error),
                resources.getString(R.string.could_not_load_courses)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = FavouritesFragment()
    }
}
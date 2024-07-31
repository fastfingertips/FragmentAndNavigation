package com.fastfingertips.fragmentandnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fastfingertips.fragmentandnavigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    // Binding variable to access the views in the fragment_second.xml layout
    private var _binding: FragmentSecondBinding? = null

    // Safe getter for binding variable
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using View Binding
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        // Return the root view of the inflated layout
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve arguments passed to this fragment
        arguments?.let {
            // Get the userName argument from the bundle
            val userName = SecondFragmentArgs.fromBundle(it).userName
            // Set the userName to the TextView
            binding.textViewUserName.text = userName
        }
    }

    // Clean up the binding when the view is destroyed to avoid memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.fastfingertips.fragmentandnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.fastfingertips.fragmentandnavigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    // Binding variable to access the views in the fragment_first.xml layout
    private var _binding: FragmentFirstBinding? = null

    // Safe getter for binding variable
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Display a welcome message when the fragment is created
        Toast.makeText(requireContext(), "Welcome!", Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using View Binding
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        // Return the root view of the inflated layout
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set up a click listener for the "Next" button
        binding.buttonNextFragment.setOnClickListener {
            buttonNext(it)
        }
    }

    // Function to handle the "Next" button click event
    private fun buttonNext(view: View) {
        // Get the username input from the EditText
        val userName = binding.editTextUserName.text.toString()
        // Check if the username is not empty
        if (userName.isNotBlank()) {
            // Create an action to navigate to the SecondFragment with the username as an argument
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(userName)
            // Navigate to the SecondFragment using the action
            Navigation.findNavController(view).navigate(action)
        } else {
            // Display a message asking the user to enter a username
            Toast.makeText(requireContext(), "Please enter a username", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up the binding when the view is destroyed to avoid memory leaks
        _binding = null
    }
}

package com.example.navdemo

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navdemo.databinding.FragmentNameBinding

class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_name, container, false)
        binding.buttonNEXT.setOnClickListener {
            if(TextUtils.isEmpty(binding.nameET.text.toString())){
                Toast.makeText(this.activity,"Please enter your name",Toast.LENGTH_SHORT).show()

            }
            else {
                val bundle: Bundle = bundleOf("user_name" to binding.nameET.text.toString())
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment,bundle)
            }
        }
        return binding.root
    }


}
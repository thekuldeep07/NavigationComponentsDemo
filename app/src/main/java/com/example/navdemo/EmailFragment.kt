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
import com.example.navdemo.databinding.FragmentEmailBinding
import com.example.navdemo.databinding.FragmentNameBinding

class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_email, container, false)
        var name:String? = requireArguments().getString("user_name")
        binding.nameTV.text= "Hey!! ${name} enter your Email"

        binding.submitEmail.setOnClickListener {
            if(TextUtils.isEmpty(binding.emailET.text.toString())){
                Toast.makeText(this.activity,"Please enter your email", Toast.LENGTH_SHORT).show()

            }
            else {
                val bundle: Bundle = bundleOf("user_email" to binding.emailET.text.toString(),
                "user_name" to name )
                it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment,bundle)
            }
        }


        return binding.root
    }


    }

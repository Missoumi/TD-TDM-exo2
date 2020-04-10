package com.example.td4_exo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

private const val ARG_PARAM1 = "param1"

class BookFragement : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root :View = inflater.inflate(R.layout.fragment_book_fragement, container, false)
        var imageView = root.findViewById<ImageView>(R.id.writerImageLarge)
        val imageArray  = resources.obtainTypedArray(R.array.writerImage)
        imageView.setImageResource(imageArray.getResourceId(param1, -1))
        val writers = resources.getStringArray(R.array.writers)
        var writer = root.findViewById<TextView>(R.id.writerLarge)
        writer.text = writers[param1]
        val contents = resources.getStringArray(R.array.contents)
        var content = root.findViewById<TextView>(R.id.contentLarge)
        content.text = contents[param1]
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookFragement.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            BookFragement().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }


}

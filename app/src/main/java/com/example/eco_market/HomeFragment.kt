package com.example.eco_market

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.eco_market.databinding.FragmentHomeBinding
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Response


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var categoryAdapter: CategoryAdapter
    private val apiInterface = Api().create()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        loadCategories()
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    private fun loadCategories() {
        runBlocking {
            apiInterface.getCategory().enqueue(object :
                retrofit2.Callback<MutableList<CategoryData>> {
                override fun onResponse(
                    call: Call<MutableList<CategoryData>>,
                    response: Response<MutableList<CategoryData>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            if (it.isNotEmpty()) {
                                binding.rv.adapter =
                                    CategoryAdapter(it) { category, _ ->
                                        val intent = Intent(
                                            requireContext(),
                                            ProductListActivity::class.java
                                        )
                                            .putExtra("catId", category.categoryId)
                                        startActivity(intent)
                                    }
                            } else {

                            }

                        }

                    } else {
                        Toast.makeText(requireContext(), "Is not seccessful", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onFailure(call: Call<MutableList<CategoryData>>, t: Throwable) {

                }
            })
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
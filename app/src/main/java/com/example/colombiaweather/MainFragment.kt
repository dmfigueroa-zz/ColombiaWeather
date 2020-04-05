package com.example.colombiaweather

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.colombiaweather.cities.CitiesAdapter
import com.example.colombiaweather.cities.CitiesViewModel
import com.example.colombiaweather.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    lateinit var navController : NavController

    private val viewModel: CitiesViewModel by lazy {
        ViewModelProviders.of(this).get(CitiesViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.cities.adapter = CitiesAdapter(CitiesAdapter.OnClickListener {
            viewModel.displayPropertyDetails(it)
        })

        viewModel.navigateToSelectedCity.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                navController.navigate(MainFragmentDirections.actionMainFragmentToCityFragment(it))
                viewModel.displayPropertyDetailsComplete()
            }
        })

        return binding.root
    }
}

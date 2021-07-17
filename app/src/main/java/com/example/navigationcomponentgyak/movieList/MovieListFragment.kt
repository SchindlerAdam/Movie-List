package com.example.navigationcomponentgyak.movieList



import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationcomponentgyak.R
import com.example.navigationcomponentgyak.databinding.FragmentMovieListBinding


class MovieListFragment : Fragment() {


    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieDataList: List<MovieData>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieArray = context?.resources?.getStringArray(R.array.movies)?.toList()

        val wonderWomanDetails = context?.resources?.getStringArray(R.array.wonder_women_2)?.toList()
        val soulDetails = context?.resources?.getStringArray(R.array.soul)?.toList()
        val newsOfWorldDetails = context?.resources?.getStringArray(R.array.news_of_world)?.toList()
        val theLittleThingsDetails = context?.resources?.getStringArray(R.array.the_little_things)?.toList()
        val cinderellaDetails = context?.resources?.getStringArray(R.array.cinderella)?.toList()
        val judasAndTheBlackMessiahDetails = context?.resources?.getStringArray(R.array.judas_black_messiah)?.toList()
        val theManySaintOfNeworksDetails = context?.resources?.getStringArray(R.array.the_many_saints_of_newark)?.toList()
        val morbiusDetails = context?.resources?.getStringArray(R.array.morbius)?.toList()
        val fatherhoodDetails = context?.resources?.getStringArray(R.array.fatherhood)?.toList()
        val noTimeToDieDetails = context?.resources?.getStringArray(R.array.no_time_to_die)?.toList()
        val peterRabbit2Details = context?.resources?.getStringArray(R.array.peter_rabbit_2)?.toList()
        val bobBurgerDetails = context?.resources?.getStringArray(R.array.bob_burger)?.toList()
        val mortalKombatDetails = context?.resources?.getStringArray(R.array.mortal_kombat)?.toList()
        val blackWidowDetails = context?.resources?.getStringArray(R.array.black_widow)?.toList()
        val godzillaVsKongDetails = context?.resources?.getStringArray(R.array.godzilla_vs_kong)?.toList()
        val f9Details = context?.resources?.getStringArray(R.array.f9)?.toList()
        val venom2Details = context?.resources?.getStringArray(R.array.venom2)?.toList()
        val spaceJam2Details = context?.resources?.getStringArray(R.array.spacejam2)?.toList()



        movieDataList = listOf(
            MovieData(movieArray!![0], R.drawable.wonderwomen1984, wonderWomanDetails!!),
            MovieData(movieArray[1], R.drawable.soul, soulDetails!!),
            MovieData(movieArray[2], R.drawable.newsofworld, newsOfWorldDetails!!),
            MovieData(movieArray[3], R.drawable.thelittlethings, theLittleThingsDetails!!),
            MovieData(movieArray[4], R.drawable.cinderella, cinderellaDetails!!),
            MovieData(movieArray[5], R.drawable.judasandtheblackmessiah, judasAndTheBlackMessiahDetails!!),
            MovieData(movieArray[6], R.drawable.themanysaintofnetworks, theManySaintOfNeworksDetails!!),
            MovieData(movieArray[7], R.drawable.morbius, morbiusDetails!!),
            MovieData(movieArray[8], R.drawable.fatherhood, fatherhoodDetails!!),
            MovieData(movieArray[9], R.drawable.notimetodie, noTimeToDieDetails!!),
            MovieData(movieArray[10], R.drawable.peterrabbit2, peterRabbit2Details!!),
            MovieData(movieArray[11], R.drawable.bobburger, bobBurgerDetails!!),
            MovieData(movieArray[12], R.drawable.mortalkombat, mortalKombatDetails!!),
            MovieData(movieArray[13], R.drawable.blackwidow, blackWidowDetails!!),
            MovieData(movieArray[14], R.drawable.godzillakong, godzillaVsKongDetails!!),
            MovieData(movieArray[15], R.drawable.f9thefastsaga, f9Details!!),
            MovieData(movieArray[16], R.drawable.venom2, venom2Details!!),
            MovieData(movieArray[17], R.drawable.spacejam2, spaceJam2Details!!)
        )

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = MovieListAdapter(movieDataList)
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



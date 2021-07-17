package com.example.navigationcomponentgyak.movieDetails


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationcomponentgyak.databinding.FragmentMovieDetailsBinding


class MovieDetailsFragment : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!
    private var imageArgument: Int = 0
    private var titleArgument: String = ""
    private var storyArgument: String = ""
    private var directorArgument: String = ""
    private var writerArgument: String = ""
    private var starsArgument: String = ""


    companion object {
        const val TITLE = "title"
        const val IMAGE = "image"
        const val STORY = "story"
        const val DIRECTOR = "director"
        const val WRITER = "writer"
        const val STARS = "stars"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            imageArgument = it.getInt(IMAGE)
            titleArgument = it.getString(TITLE).toString()
            storyArgument = it.getString(STORY).toString()
            directorArgument = it.getString(DIRECTOR).toString()
            writerArgument = it.getString(WRITER).toString()
            starsArgument = it.getString(STARS).toString()
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivDetailsFragmentLayout.setImageResource(imageArgument)
        binding.tvTitleFragmentLayout.text = titleArgument
        binding.tvDirectorFragmentLayout.text = directorArgument
        binding.tvWriterFragmentLayout.text = writerArgument
        binding.tvStarsFragmentLayout.text = starsArgument
        binding.tvStoryFragmentLayout.text = storyArgument
        val button = binding.btnDetailsFragmentLayout
        button.setOnClickListener {
            val uriQuery: Uri = Uri.parse("$SEARCH_PREFIX${binding.tvTitleFragmentLayout.text}")
            val intent = Intent(Intent.ACTION_VIEW, uriQuery)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
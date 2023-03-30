package com.example.flowroom.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.flowroom.databinding.FragmentMainBinding
import com.example.flowroom.repository.room.Note
import com.example.flowroom.ui.adapter.NotesAdapter
import com.example.flowroom.ui.adapter.SwipeHelper
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<MainViewModel>()
    private val adapter: NotesAdapter? get() = views { listNotes.adapter as? NotesAdapter }
    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMainBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        views {
            listNotes.adapter = NotesAdapter()
            SwipeHelper(viewModel::delete).attachToRecyclerView(listNotes)
            addButton.setOnClickListener { saveNote() }
        }

        viewModel.notes.onEach(::renderNotes).launchIn(lifecycleScope)
    }

    private fun saveNote() {
        views {
            val noteText = addNoteEditText.text.toString().takeIf { it.isNotBlank() } ?: return@views
            viewModel.save(noteText)
        }
    }

    private fun renderNotes(notes: List<Note>) {
        adapter?.submitList(notes)
    }

    private fun <T> views(block: FragmentMainBinding.() -> T): T? = binding?.block()
}
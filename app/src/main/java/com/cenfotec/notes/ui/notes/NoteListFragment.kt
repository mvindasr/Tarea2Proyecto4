package com.cenfotec.notes.ui.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.cenfotec.notes.R
import com.cenfotec.notes.domain.models.NoteModel
import com.cenfotec.notes.ui.notes.adapters.NoteListAdapter
import com.cenfotec.notes.ui.notes.viewmodels.NoteListViewModel


class NoteListFragment : Fragment() {

    private lateinit var viewModel: NoteListViewModel
    private lateinit var notesRecyclerView: RecyclerView

    // va a inicializar y cargar en memoria hasta que yo lo necesite (lazy)
    private val adapter by lazy { NoteListAdapter(
        onItemLongClicked = { item -> onListItemClicked(item)}
    ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_note_list, container, false)
        initViews(view)
        viewModel = ViewModelProvider(this)[NoteListViewModel::class.java]
        observe()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewReady()
    }

    private fun initViews(view: View) {
        with(view) {
            notesRecyclerView = findViewById(R.id.notes_list)
            notesRecyclerView.adapter = adapter
            notesRecyclerView.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            notesRecyclerView.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    private fun observe() {
        viewModel.noteListLiveData.observe(viewLifecycleOwner) { list ->
            adapter.setData(list)
        }
    }

    //presionar varios segundos para el delete
    private fun onListItemClicked(noteModel: NoteModel) {
        Toast.makeText(context, "${noteModel.title} was clicked", Toast.LENGTH_LONG).show()
        // Todo remove item
    }

}
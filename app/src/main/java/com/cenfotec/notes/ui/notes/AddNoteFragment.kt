package com.cenfotec.notes.ui.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.cenfotec.notes.R
import com.cenfotec.notes.ui.notes.viewmodels.AddNoteViewModel
import com.google.android.material.textfield.TextInputEditText


class AddNoteFragment : Fragment() {

    private lateinit var viewModel: AddNoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_note, container, false)
        val btnSave = view.findViewById(R.id.button_save) as Button
        val options = resources.getStringArray(R.array.tags)
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, options)

        val textField = view.findViewById(R.id.tag_dropdown_options) as AutoCompleteTextView
        textField.setAdapter(adapter)
        viewModel = ViewModelProvider(this)[AddNoteViewModel::class.java]


// set on-click listener
        btnSave.setOnClickListener {
            val title = view.findViewById<TextInputEditText>(R.id.edit_title).text.toString()
            val description = view.findViewById<TextInputEditText>(R.id.edit_description).text.toString()
            val tag = textField.text.toString()
            viewModel.addNote(title, description, tag)
            switchToNoteListFragment()
            Toast.makeText(context, "'$title'" + (context?.getText(R.string.add_note_message)
                ?: "fue agregada"), Toast.LENGTH_SHORT).show()

        }

        return view
    }

    private fun switchToNoteListFragment() {
        val listNoteFragment = NoteListFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, listNoteFragment)
            .addToBackStack(null)
            .commit()
    }

}
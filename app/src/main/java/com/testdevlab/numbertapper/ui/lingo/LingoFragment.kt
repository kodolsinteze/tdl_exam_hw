package com.testdevlab.numbertapper.ui.lingo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.testdevlab.numbertapper.R
import com.testdevlab.numbertapper.common.openFragment
import com.testdevlab.numbertapper.databinding.FragmentLingoBinding
import com.testdevlab.numbertapper.model.LingoPiece
import com.testdevlab.numbertapper.ui.GameViewModel
import timber.log.Timber

class LingoFragment : Fragment() {
    private lateinit var binding: FragmentLingoBinding

    private val viewModel: GameViewModel by activityViewModels()

    private val liste by lazy {
        viewModel.returnListe()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLingoBinding.inflate(inflater, container, false)
        Timber.d("LingoFragment inflated")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var todoList = mutableListOf<LingoPiece>()
        val rv = binding.rvTodos
        val adapter = LingoAdapter(todoList)

        rv.adapter = LingoAdapter(todoList)
        rv.layoutManager = LinearLayoutManager(requireContext())

        binding.run {
            rvTodos.adapter = adapter
            addBtn.setOnClickListener {
                Timber.d("Button was pressed")

                if (viewModel.inputCheck(lingoNumEdittext.text.toString())) {
                    val test = lingoNumEdittext.text.toString()
                    var lingo = LingoPiece(test[0].toString(), test[1].toString(), test[2].toString(),
                        test[3].toString(),
                        viewModel.colorCheck(test[0].toString(), 0),
                        viewModel.colorCheck(test[1].toString(), 1),
                        viewModel.colorCheck(test[2].toString(), 2),
                        viewModel.colorCheck(test[3].toString(), 3)
                    )
                    todoList.add(lingo)
                    viewModel.tries()

                    if (viewModel.finished(test)) {
                        binding.finishedLayout.visibility = View.VISIBLE
                        binding.gameLayout.visibility = View.GONE
                        binding.result.text = getString(R.string.try_amount, viewModel.reizes)
                        viewModel.reizes = 0
                        viewModel.updateList()
                    }
                }
                println(liste)
                adapter.notifyItemInserted(todoList.size - 1)
                lingoNumEdittext.setText("")
            }

            returnToMenuBtn.setOnClickListener {
                openFragment(R.id.navigation_menu)
            }
        }
    }
}

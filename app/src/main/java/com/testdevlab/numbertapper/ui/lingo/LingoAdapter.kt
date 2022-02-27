package com.testdevlab.numbertapper.ui.lingo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testdevlab.numbertapper.databinding.LingoGamePieceBinding
import com.testdevlab.numbertapper.model.LingoPiece

class LingoAdapter(
    private var todos: List<LingoPiece>
) : RecyclerView.Adapter<LingoAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: LingoGamePieceBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LingoGamePieceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = todos[position]
        with(holder.binding) {
            tvTitle1.text = user.title1
            tvTitle2.text = user.title2
            tvTitle3.text = user.title3
            tvTitle4.text = user.title4
            tvTitle1.setBackgroundColor(user.color1)
            tvTitle2.setBackgroundColor(user.color2)
            tvTitle3.setBackgroundColor(user.color3)
            tvTitle4.setBackgroundColor(user.color4)
        }
    }

    override fun getItemCount() = todos.size
}

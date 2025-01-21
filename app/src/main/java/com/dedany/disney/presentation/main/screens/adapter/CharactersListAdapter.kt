package com.dedany.disney.presentation.main.screens.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dedany.disney.R
import com.dedany.disney.databinding.ItemViewCharacterBinding
import com.dedany.disney.domain.entities.Character

class CharactersListAdapter : ListAdapter<Character, CharactersListAdapter.CharacterViewHolder>(ListAdapterCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewCharacterBinding.inflate(layoutInflater, parent, false)
        return CharacterViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CharacterViewHolder(
        private val binding: ItemViewCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            binding.textName.text = character.name
            // Movies (separador por defecto ', '): [Tarzán, Blancanieves 1, Blancanieves 2]
            // Separador es ' ¿? ': [Tarzán ¿? Blancanieves 1 ¿? Blancanieves 2]
            binding.textMovies.text = character.multimedia.joinToString()
            binding.textGames.text = character.videoGames.joinToString(" y ")
            Glide.with(binding.root)
                .load(character.image)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(binding.imageCharacter)
        }
    }

    class ListAdapterCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }
}
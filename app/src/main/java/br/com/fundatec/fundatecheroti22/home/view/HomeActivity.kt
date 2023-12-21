package br.com.fundatec.fundatecheroti22.home.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheroti22.gone
import br.com.fundatec.fundatecheroti22.home.domain.CharacterModel
import br.com.fundatec.fundatecheroti22.home.presentation.model.HomeViewModel
import br.com.fundatec.fundatecheroti22.home.presentation.model.HomeViewState
import br.com.fundatec.fundatecheroti22.profile.view.ProfileActivity
import br.com.fundatec.fundatecheroti22.showSnackBar
import com.example.fundatecheroes.createCharacter.view.CreateCharacterActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()


    private val adapter: CharacterListAdapter by lazy {
        CharacterListAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroTI22)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configNewCharacter()

        binding.rvList.adapter = adapter

        viewModel.state.observe(this) {
            when (it) {
                is HomeViewState.Success ->
                    adapter.addList(
                        it.list
                    )

                is HomeViewState.removerCharacter ->
                    showSnackBar(
                        binding.root,
                        R.string.sucessoPersonagem_removido,
                        R.color.teal_700

                    )

                HomeViewState.Loading -> {

                }

                is HomeViewState.Error ->
                    it.errorMessage

                else -> {}
            }
        }


    }

    private fun configSwipeToRemove() {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                v: RecyclerView,
                h: RecyclerView.ViewHolder,
                t: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(h: RecyclerView.ViewHolder, dir: Int) {
                val character = adapter.posicaoPersonagem(h.adapterPosition)
                viewModel.deleteCharacter(character.id)
                adapter.remove(h.adapterPosition)
            }
        }).attachToRecyclerView(binding.rvList)
    }

    private fun configNewCharacter() {
        binding.btNewCharacter.setOnClickListener {
            startActivity(Intent(this@HomeActivity, CreateCharacterActivity::class.java))
        }
    }
}

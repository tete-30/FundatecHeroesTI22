package br.com.fundatec.fundatecheroti22.home.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheroti22.gone
import br.com.fundatec.fundatecheroti22.home.domain.CharacterModel
import br.com.fundatec.fundatecheroti22.home.presentation.model.HomeViewState
import br.com.fundatec.fundatecheroti22.profile.view.ProfileActivity
import com.example.fundatecheroes.createCharacter.view.CreateCharacterActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

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
        adapter.addList(
            listOf(
                CharacterModel(
                    name = "Alerquina",
                    image = "https://1.bp.blogspot.com/-O9fc595Oc6Y/V5uNFWrcNhI/AAAAAAAAHfE/lb6ve2sWBHg-RMeYIwSAMAGPi26CGmv_wCLcB/s1600/harley_quinn_suicide_squad___transparent__2_by_natan_ferri-da74wt2.png"
                ),
                CharacterModel(
                    name = "Coringa",
                    image = "https://i.pinimg.com/originals/08/7c/87/087c872debb03ed7e7b905d4ed57e116.png"
                )
            )

        )
    }

    private fun configNewCharacter() {
        binding.btNewCharacter.setOnClickListener {
            startActivity(Intent(this@HomeActivity, CreateCharacterActivity::class.java))
        }
    }
}

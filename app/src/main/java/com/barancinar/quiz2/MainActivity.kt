package com.barancinar.quiz2

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY

class MainActivity : AppCompatActivity() {
    private lateinit var edMemberName: EditText
    private lateinit var tvDegisenCins: TextView
    private lateinit var tvDegisenDurum: TextView
    private lateinit var btnCins: Button
    private lateinit var btnDurum: Button
    private lateinit var btnPaylas: Button
    private lateinit var lvKoleksiyonListesi: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun loadTypes() {
        val repo = CollectionTypeRepository()
        val items = repo.getItems()

        val adapter = CollectionTypeAdapter(this, items)

        lvKoleksiyonListesi.adapter = adapter
    }

    private fun loadState() {
        val repo = CollectionStateRepository()
        val items = repo.getItems()

        val adapter = CollectionStateAdapter(this, items)

        lvKoleksiyonListesi.adapter = adapter
    }

    private fun initUI() {
        edMemberName = findViewById(R.id.edMemberName)
        tvDegisenCins = findViewById(R.id.tvDegisenCins)
        tvDegisenDurum = findViewById(R.id.tvDegisenDurum)
        btnCins = findViewById(R.id.btnCins)
        btnDurum = findViewById(R.id.btnDurum)
        btnPaylas = findViewById(R.id.btnPaylas)
        lvKoleksiyonListesi = findViewById(R.id.lvKoleksiyonListesi)

        btnCins.setOnClickListener {
            loadTypes()
            lvKoleksiyonListesi.visibility = View.VISIBLE
            lvKoleksiyonListesi.setOnItemClickListener { parent, view, position, id ->
                val item = lvKoleksiyonListesi.getItemAtPosition(position) as? CollectionTypeModel
                if(item != null) {
                    tvDegisenCins.text = getString(item.type)
                    lvKoleksiyonListesi.visibility = View.INVISIBLE

                } else {
                    Toast.makeText(this, "HATA: İstenilen öge alınamadı.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnDurum.setOnClickListener {
            loadState()
            lvKoleksiyonListesi.visibility = View.VISIBLE
            lvKoleksiyonListesi.setOnItemClickListener { parent, view, position, id ->
                val item = lvKoleksiyonListesi.getItemAtPosition(position) as? CollectionStateModel
                if(item != null) {
                    tvDegisenDurum.text = getString(item.state)
                    lvKoleksiyonListesi.visibility = View.INVISIBLE
                } else {
                    Toast.makeText(this, "HATA: İstenilen öge alınamadı.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnPaylas.setOnClickListener {
            val paylasMesaj = getString(R.string.mesaj, edMemberName.text, tvDegisenCins.text, tvDegisenDurum.text)

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, paylasMesaj)

            startActivity(Intent.createChooser(intent, "Paylaş"))
        }
    }
}
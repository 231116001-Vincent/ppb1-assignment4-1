package com.vharya.assignment4

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vharya.assignment4.adapters.AdapterImageGrid
import java.util.ArrayList

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private val imageIDs = intArrayOf(
        R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4,
        R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8
    )

    private val titles = arrayOf(
        "Ghost Of Tsushima", "Cyberpunk 2077", "FarCry 4", "The Witcher 3",
        "Red Dead Redemption 2", "Bloodborne", "Elden Ring",  "Assassin's Creed Revelations"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val gridView: GridView = findViewById(R.id.image_grid)

        toolbar.setTitle(R.string.app_name)

        gridView.adapter = AdapterImageGrid(
            this,
            ArrayList(imageIDs.toList()),
            ArrayList(titles.toList()),
        )

        gridView.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(
            this,
            "${imageIDs[position]} pressed!",
            Toast.LENGTH_SHORT
        ).show()
    }
}
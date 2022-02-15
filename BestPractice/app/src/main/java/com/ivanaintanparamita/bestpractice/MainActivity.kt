package com.ivanaintanparamita.bestpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var tblMakanan : ImageView;
    private lateinit var tblRumah : ImageView;
    private lateinit var tblIbuAnak : ImageView;
    private lateinit var tblKesehatan : ImageView;
    private lateinit var tblExit : ImageView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val imgMenu = findViewById<ImageView>(R.id.imgMenu)

        val navView = findViewById<NavigationView>(R.id.navDrawer)
        navView.itemIconTintList = null
        imgMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        val navController = Navigation.findNavController(this,R.id.fragment)
        NavigationUI.setupWithNavController(navView,navController)

        val textTitle = findViewById<TextView>(R.id.title)
        navController
            .addOnDestinationChangedListener { controller, destination, arguments ->
                textTitle.text = destination.label
            }


        //button
        tblMakanan = findViewById<ImageView>(R.id.imageView1)
        tblRumah = findViewById<ImageView>(R.id.imageView2)
        tblIbuAnak = findViewById<ImageView>(R.id.imageView3)
        tblKesehatan = findViewById<ImageView>(R.id.imageView4)

        tblMakanan.setOnClickListener{
            val intent = Intent(this, MakananMinuman::class.java)
            startActivity(intent)
        }

        tblRumah.setOnClickListener{
            val intent = Intent(this, RumahDapur::class.java)
            startActivity(intent)
        }

        tblIbuAnak.setOnClickListener{
            val intent = Intent(this, IbuAnak::class.java)
            startActivity(intent)
        }

        tblKesehatan.setOnClickListener{
            val intent = Intent(this, KesehatanKecantikan::class.java)
            startActivity(intent)
        }
    }
}
package com.example.caone

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize DrawerLayout & Toolbar
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        // Setup ActionBar Toggle (Hamburger Menu)
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Handle Navigation Item Clicks
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> showToast("Home Clicked")
                R.id.nav_profile -> showToast("Profile Clicked")
                R.id.nav_settings -> showToast("Settings Clicked")
                R.id.nav_logout -> showToast("Logout Clicked")
            }
            drawerLayout.closeDrawers() // Close drawer after selection
            true
        }

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.rv_icons)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val iconList = listOf(
            IconItem(R.drawable.icon_1, "Electronics"),
            IconItem(R.drawable.image_2, "Clothing"),
            IconItem(R.drawable.icon3, "Shoes"),
            IconItem(R.drawable.icon4, "Home"),
            IconItem(R.drawable.icon5, "Books"),
            IconItem(R.drawable.icon6, "Toys")
        )

        recyclerView.adapter = IconsAdapter(iconList)
    }

    // Handle Hamburger Menu Click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

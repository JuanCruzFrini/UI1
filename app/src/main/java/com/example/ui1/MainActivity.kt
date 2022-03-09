package com.example.ui1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var viewPagerAdapter: ViewPagerAdapter

    lateinit var drawerLayout:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "User Interface Practice"

        supportActionBar!!.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
            it.elevation = 10f
        }
        //supportActionBar!!.hide()
        /*supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_launcher_foreground);*/

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        drawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, /*toolbar,*/ R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)

        setUpViewPager()

        if (intent.getBooleanExtra("cambio", true)){
            intent.putExtra("cambio", false)
            onRestart()
        }
    }

    fun setUpViewPager(){
        viewPagerAdapter.addFragment(BlankFragment1(), "Empleados")
        viewPagerAdapter.addFragment(BlankFragment2(), "Empresa")
        val vp =  findViewById<ViewPager>(R.id.viewpager)
        vp.adapter = viewPagerAdapter

        val tablayout = findViewById<TabLayout>(R.id.tablayout)
        tablayout.setupWithViewPager(vp)

        tablayout.addOnTabSelectedListener(object : OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position){
                    0 -> tablayout.setSelectedTabIndicatorColor(Color.BLACK)
                    else -> tablayout.setSelectedTabIndicatorColor(Color.CYAN)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.a1 -> {
                startActivity(Intent(this, AddFragment::class.java))
                true
            }
            R.id.a2 -> {
                Toast.makeText(this, "Action 2", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        onOptionsItemSelected(item)
        return true
    }
}
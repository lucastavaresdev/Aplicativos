package com.lucastomiati.freshfoodapp



import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.OrientationHelper.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lucastomiati.freshfoodapp.fraguiments.Home2Fragment
import com.lucastomiati.freshfoodapp.fraguiments.Home3Fragment
import com.lucastomiati.freshfoodapp.fraguiments.Home4Fragment
import com.lucastomiati.freshfoodapp.fraguiments.HomeFragment
import kotlinx.android.synthetic.main.bottom_menu.*
import kotlinx.android.synthetic.main.home.*
import kotlinx.android.synthetic.main.include_toobar.*

class Home : BaseActivity()  {

    private val mOrNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.home -> {
                print("home pressionada")
                replaceFraguiment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }R.id.home2 -> {
                print("home2 pressionada")
            replaceFraguiment(Home2Fragment())
                return@OnNavigationItemSelectedListener true
            }R.id.home3 -> {
                print("home3 pressionada")
                replaceFraguiment(Home3Fragment())
                return@OnNavigationItemSelectedListener true
            }R.id.home4 -> {
                print("home4 pressionada")
                replaceFraguiment(Home4Fragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        setupToolbar(tollBarMain, R.string.app_store,  R.drawable.icon_search)


        toolbar_icon.setOnClickListener{
            val i2 = Intent(this, Search::class.java)
            startActivity(i2)
            overridePendingTransition(R.transition.slide_in_up, R.transition.no_animation)
        }


        //popula uma lista de 1  a 101
        val posts: ArrayList<String> = ArrayList()

        for(i in 1..10){
            posts.add("post #$i")
        }

        //inicializa o recycler view
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = PostsAdapter(posts)

        //menu
        bottomNav.setOnNavigationItemSelectedListener(mOrNavigationItemSelectedListener)

    }

    private fun replaceFraguiment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fraguimentContainer, fragment)
        fragmentTransaction.commit()
    }


}

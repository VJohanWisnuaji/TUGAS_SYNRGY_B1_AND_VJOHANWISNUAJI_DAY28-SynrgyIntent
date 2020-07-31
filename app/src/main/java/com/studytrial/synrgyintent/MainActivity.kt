package com.studytrial.synrgyintent


import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(FragmentBundle())
        bnv_main.setOnNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(fl_container.id, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.bundle -> fragment = FragmentBundle()
            R.id.serializable -> fragment = FragmentSerializable()
            R.id.parcelable -> fragment = FragmentParcelable()
            R.id.implicit_dial -> fragment = FragmentImplicitDial()
            R.id.implicit_wa -> fragment = FragmentImplicitWA()
        }
        return loadFragment(fragment!!)
    }
}
package com.augrocerrydelivery.audeliveryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.augrocerrydelivery.audeliveryapp.ui.utils.BOTTOM_NAV_BACKSTACK_KEY
import com.augrocerrydelivery.audeliveryapp.ui.utils.BottomNavController
import com.augrocerrydelivery.audeliveryapp.ui.utils.setUpNavigation
import kotlinx.android.synthetic.main.activity_main.*


class HomeActivity : AppCompatActivity(), BottomNavController.NavGraphProvider,
        BottomNavController.OnNavigationGraphChanged,
        BottomNavController.OnNavigationReselectedListener {


    private val bottomNavController by lazy(LazyThreadSafetyMode.NONE) {
        BottomNavController(
                this,
                R.id.main_nav_host_fragment,
                R.id.nav_dashboard,
                this,
                this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigationView(savedInstanceState)

    }


    override fun getNavGraphId(itemId: Int): Int = when (itemId) {
        R.id.nav_dashboard -> {
            R.navigation.navigation_dashboard
        }
        R.id.nav_notification -> {
            R.navigation.nav_notification
        }
        R.id.nav_profile -> {
            R.navigation.nav_profile
        }
        else -> {
            R.navigation.nav_setting
        }
    }


    private fun setupBottomNavigationView(savedInstanceState: Bundle?) {
        bottom_navigation_view.setUpNavigation(bottomNavController, this)
        if (savedInstanceState == null) {
            bottomNavController.setupBottomNavigationBackStack(null)
            bottomNavController.onNavigationItemSelected()
        } else {
            (savedInstanceState[BOTTOM_NAV_BACKSTACK_KEY] as IntArray?)?.let { items ->
                val backstack = BottomNavController.BackStack()
                backstack.addAll(items.toTypedArray())
                bottomNavController.setupBottomNavigationBackStack(backstack)
            }
        }
    }

    override fun onGraphChange() {
    }

    override fun onReselectNavItem(navController: NavController, fragment: Fragment) {
    }


    override fun onBackPressed() = bottomNavController.onBackPressed()
}
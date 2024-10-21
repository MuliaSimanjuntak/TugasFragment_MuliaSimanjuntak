package com.example.tugasfragment

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.tugasfragment.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var nav: Array<String>

    companion object{
        var usernames = "username"
        var emails = "email"
        var phones = "phone"
        var passwords = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nav = resources.getStringArray(R.array.nav)

        with(binding) {
            // Inisialisasi ViewPager2 dengan adapter
            viewPager.adapter = SectionsPagerAdapater(this@MainActivity)

            // Inisialisasi TabLayoutMediator dengan benar
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = nav[position]
            }.attach()
        }
    }

    fun navigateTo(position: Int) {
        binding.viewPager.setCurrentItem(position, true)
    }

    fun saveData(username: String, email : String, phone:String, password:String){
        usernames = username
        emails = email
        phones = phone
        passwords = password
    }
    fun getUsername(): String {
        return usernames
    }
    fun getEmail(): String {
        return emails
    }
    fun getPhone(): String {
        return phones
    }
    fun getPassword(): String {
        return passwords
    }
}

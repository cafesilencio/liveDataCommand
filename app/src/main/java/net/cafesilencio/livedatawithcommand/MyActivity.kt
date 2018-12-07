package net.cafesilencio.livedatawithcommand

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MyActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, MainActivityViewModelFactory()).get(MainActivityViewModel::class.java)

        btnWelcome.setOnClickListener { viewModel.respondToSomeUserAction() }
        viewModel.viewUpdates.observe(this, Observer { it?.forEach { cmd -> cmd(this) } })
    }
}

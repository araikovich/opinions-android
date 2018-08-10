package com.example.tigranchilingarian.rateme.ui.welcome

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.tigranchilingarian.rateme.R
import com.example.tigranchilingarian.rateme.databinding.ActivityWelcomeBinding
import com.example.tigranchilingarian.rateme.ui.core.BaseActivity
import com.example.tigranchilingarian.rateme.ui.core.Layout
import com.example.tigranchilingarian.rateme.ui.core.WithBinding
import com.example.tigranchilingarian.rateme.ui.login.LoginActivity
import com.example.tigranchilingarian.rateme.ui.registration.RegistrationActivity

@Layout(id = R.layout.activity_welcome)
@WithBinding
class WelcomeActivity : BaseActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun injectComponent() {

    }

    companion object {
        fun start(context: BaseActivity) {
            context.startActivity(WelcomeActivity::class.java, true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.setOnRegistrationClickListener {
            RegistrationActivity.start(this)
        }

        binding.setOnLoginClickListener {
            LoginActivity.start(this)
        }
    }

    override fun setupContentWithBinding(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }
}

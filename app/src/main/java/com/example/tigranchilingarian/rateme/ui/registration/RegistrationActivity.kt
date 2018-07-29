package com.example.tigranchilingarian.rateme.ui.registration

import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import com.example.tigranchilingarian.rateme.R
import com.example.tigranchilingarian.rateme.databinding.ActivityRegistrationBinding
import com.example.tigranchilingarian.rateme.di.module.RegistrationModule
import com.example.tigranchilingarian.rateme.ui.core.BaseActivityWithPresenter
import com.example.tigranchilingarian.rateme.ui.core.Layout
import com.example.tigranchilingarian.rateme.ui.core.WithBinding


@Layout(id = R.layout.activity_registration)
@WithBinding
class RegistrationActivity : BaseActivityWithPresenter<RegistrationPresenter.Screen, RegistrationPresenter>(), RegistrationPresenter.Screen {

    private val component by lazy { app.component.plus(RegistrationModule(this)) }

    private var binding: ActivityRegistrationBinding? = null

    override fun createPresenter(): RegistrationPresenter = RegistrationPresenter(this, component)

    override fun injectComponent() {
        component.plus(this)
    }

    override fun setupContentWithBinding(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.navigationBarColor = resources.getColor(R.color.colorPrimaryDark)
        }
    }
}

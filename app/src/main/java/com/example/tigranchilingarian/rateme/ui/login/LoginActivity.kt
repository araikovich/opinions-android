package com.example.tigranchilingarian.rateme.ui.login

import android.databinding.DataBindingUtil
import com.example.tigranchilingarian.rateme.R
import com.example.tigranchilingarian.rateme.databinding.ActivityLoginBinding
import com.example.tigranchilingarian.rateme.di.module.LoginModule
import com.example.tigranchilingarian.rateme.ui.core.BaseActivity
import com.example.tigranchilingarian.rateme.ui.core.BaseActivityWithPresenter
import com.example.tigranchilingarian.rateme.ui.core.Layout
import com.example.tigranchilingarian.rateme.ui.core.WithBinding

@Layout(id = R.layout.activity_login)
@WithBinding
class LoginActivity : BaseActivityWithPresenter<LoginPresenter.Screen, LoginPresenter>(), LoginPresenter.Screen {

    companion object {
        fun start(context: BaseActivity, singleTop: Boolean = false) {
            context.startActivity(LoginActivity::class.java, true, false, singleTop = singleTop)
        }
    }

    private val component by lazy { app.component.plus(LoginModule(this)) }

    private lateinit var binding: ActivityLoginBinding

    override fun createPresenter(): LoginPresenter = LoginPresenter(this, component)

    override fun injectComponent() {
        component.plus(this)
    }

    override fun showProgressbar() {

    }

    override fun hideProgressbar() {

    }

    override fun setupContentWithBinding(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }


}

package com.example.tigranchilingarian.rateme.ui.core

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.tigranchilingarian.rateme.App
import org.greenrobot.eventbus.EventBus

abstract class BaseActivity : AppCompatActivity() {

    val BaseActivity.app get() = application as App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupContent()
        injectComponent()
    }

    override fun onDestroy() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
        super.onDestroy()
    }

    abstract fun injectComponent()

    private fun setupContent() {
        val layout = javaClass.getAnnotation(Layout::class.java)
                ?: throw NullPointerException("Missing the layout Id")
        val withBinding = javaClass.getAnnotation(WithBinding::class.java)
        if (withBinding == null) {
            setContentView(layout.id)
        } else {
            setupContentWithBinding(layout.id)
        }
    }

    open fun setupContentWithBinding(layoutId: Int) {}

    fun startActivity(cls: Class<*>, withFinish: Boolean = false, revertAnimation: Boolean = false, extras: Bundle? = null, singleTop: Boolean = false) {
        if (withFinish) finish()
        val intent = Intent(this, cls)
        if (singleTop) intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        extras?.let { intent.putExtras(extras) }
        startActivity(intent)
        //TODO override transition
        /*
        overridePendingTransition(
                if (revertAnimation) R.anim.anim_activity_close_enter else R.anim.anim_activity_open_enter,
                if (revertAnimation) R.anim.anim_activity_close_exit else R.anim.anim_activity_open_exit)
                */
    }

    fun hideKeyboard(view: View? = this.currentFocus) {
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun showKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0)
    }


    fun hideNavigation() {
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        decorView.systemUiVisibility = uiOptions
    }

    fun startSingleActivity(cls: Class<*>, withFinish: Boolean, extras: Bundle) {
        if (withFinish) finish()
        val intent = Intent(this, cls)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtras(extras)
        startActivity(intent)
        //TODO override transition
        //overridePendingTransition(R.anim.anim_activity_open_enter, R.anim.anim_activity_open_exit)
    }
}
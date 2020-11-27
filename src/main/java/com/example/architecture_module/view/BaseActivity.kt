package com.example.architecture_module.view

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

abstract class BaseActivity<T : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    private lateinit var dataBinding: T

    @get:LayoutRes
    protected abstract val layoutId: Int

    @get:IdRes
    protected abstract val viewModelVariableId: Int

    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onObserve(viewModel)
        dataBinding = DataBindingUtil.setContentView(this, layoutId)
        dataBinding.lifecycleOwner = this
        dataBinding.setVariable(viewModelVariableId, viewModel)
    }

    protected open fun onObserve(viewModel: VM) {
        //empty
    }

    inline fun <Z> LiveData<Z>.observe(
        lifecycleOwner: LifecycleOwner = this@BaseActivity,
        crossinline action: (Z) -> Unit
    ) {
        observe(lifecycleOwner, Observer { action.invoke(it) })
    }
}
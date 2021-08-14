package com.example.architecture_module.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.*

abstract class BaseFragment<T : ViewDataBinding, VM : ViewModel> : Fragment() {

    lateinit var dataBinding: T

    @get:LayoutRes
    protected abstract val layoutId: Int

    @get:IdRes
    protected abstract val viewModelVariableId: Int

    protected abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        onObserve(viewModel)
        dataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        dataBinding.lifecycleOwner = this
        dataBinding.setVariable(viewModelVariableId, viewModel)
        return dataBinding.root
    }

    protected open fun onObserve(viewModel: VM) {
    // empty
    }

    inline fun <Z> LiveData<Z>.observe(
        lifecycleOwner: LifecycleOwner = this@BaseFragment,
        crossinline action: (Z) -> Unit
    ) {
        observe(lifecycleOwner, Observer { action.invoke(it) })
    }
}
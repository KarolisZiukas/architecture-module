package com.example.architecture_module.view

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import android.view.View

open class BindingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding: ViewDataBinding = DataBindingUtil.bind(itemView)!!
}
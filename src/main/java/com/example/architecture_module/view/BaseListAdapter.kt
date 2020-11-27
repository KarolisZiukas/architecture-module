package com.example.architecture_module.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseListAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BindingHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return BindingHolder(layoutInflater)
    }
}

fun BindingHolder.getString(@StringRes stringRed: Int): String {
    return itemView.context.getString(stringRed)
}
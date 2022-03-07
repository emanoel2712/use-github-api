package br.com.evjdev.githubapi.extension

import android.view.View
import android.view.animation.AnimationUtils
import br.com.evjdev.githubapi.R

fun View.animationPushRightToLeft() {
    this.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_left_in_slow))
}

fun View.animationPushLeftToRight() {
    this.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.slide_in_right_slow))
}

fun View.animationPushUpIn() {
    this.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.slide_up_in))
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

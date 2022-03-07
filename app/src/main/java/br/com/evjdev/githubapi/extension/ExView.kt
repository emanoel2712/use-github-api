package br.com.evjdev.githubapi.extension

import android.view.View
import android.view.animation.AnimationUtils
import br.com.evjdev.githubapi.R

fun View.animationPushRightToLeft() {
  this.startAnimation(AnimationUtils.loadAnimation(context, R.anim.push_left_in))
}

fun View.animationPushLeftToRight() {
    this.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.push_right_in))
}

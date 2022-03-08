package br.com.evjdev.githubapi.extension

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import br.com.evjdev.githubapi.R

private val navOptions =
    NavOptions.Builder().setEnterAnim(R.anim.slide_in_right_slow).setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right).build()

fun NavController.navigationWithAnimations(directions: NavDirections) {
    this.navigate(directions, navOptions)
}

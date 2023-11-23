package br.com.fundatec.fundatecheroti22.splash.model

sealed class SplashViewState {

    object ShowLogin : SplashViewState()
    object ShowHome : SplashViewState()

}
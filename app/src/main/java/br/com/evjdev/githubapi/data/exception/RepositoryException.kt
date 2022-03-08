package br.com.evjdev.githubapi.data.exception

import java.io.IOException
import java.lang.Exception

sealed class RepositoryException {
    object HttpException : Exception()
    object NetworkException : IOException()
}

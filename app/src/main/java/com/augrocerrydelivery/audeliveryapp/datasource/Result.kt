package com.augrocerrydelivery.audeliveryapp.datasource

sealed class Result<out T:Any>{
    data class Success<out T:Any>(val data:T):Result<T>()
    data class Error(val error:Throwable?):Result<Nothing>()
}

package cn.eli.vue.api

/**
 * @Author: Eli Shaw
 * @Date: 2019-05-30 10:37:42
 * @Description: 封装 Http 请求状态码
 */
interface IErrorCode {
    fun getCode(): Long
    fun getMessage(): String
}

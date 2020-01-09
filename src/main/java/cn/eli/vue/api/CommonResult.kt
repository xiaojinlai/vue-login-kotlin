package cn.eli.vue.api

/**
 * 通用返回对象
 * Created by macro on 2019/4/19.
 */
class CommonResult<T> {
    var code: Long = 0
    var message: String? = null
    var data: T? = null

    constructor(code: Long, message: String, data: T?) {
        this.code = code
        this.message = message
        this.data = data
    }

    companion object {

        /**
         * 成功返回结果
         * @param data 获取的数据
         */
        fun <T> success(data: T): CommonResult<T> {
            return CommonResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data)
        }

        /**
         * 成功返回结果
         * @param data 获取的数据
         * @param  message 提示信息
         */
        fun <T> success(data: T, message: String): CommonResult<T> {
            return CommonResult(ResultCode.SUCCESS.getCode(), message, data)
        }

        /**
         * 失败返回结果
         * @param errorCode 错误码
         */
        fun <T> failed(errorCode: IErrorCode): CommonResult<T> {
            return CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null)
        }

        /**
         * 失败返回结果
         * @param message 提示信息
         */
        fun <T> failed(message: String): CommonResult<T> {
            return CommonResult<T>(ResultCode.FAILED.getCode(), message, null)
        }

        /**
         * 失败返回结果
         */
        fun failed(): CommonResult<Any> {
            return failed(ResultCode.FAILED)
        }

        /**
         * 参数验证失败返回结果
         */
        fun validateFailed(): CommonResult<Any> {
            return failed(ResultCode.VALIDATE_FAILED)
        }

        /**
         * 参数验证失败返回结果
         * @param message 提示信息
         */
        fun <T> validateFailed(message: String): CommonResult<T> {
            return CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null)
        }

        /**
         * 未登录返回结果
         */
        fun <T> unauthorized(data: T): CommonResult<T> {
            return CommonResult(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data)
        }

        /**
         * 未授权返回结果
         */
        fun <T> forbidden(data: T): CommonResult<T> {
            return CommonResult(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data)
        }
    }
}
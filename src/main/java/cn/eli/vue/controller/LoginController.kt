package cn.eli.vue.controller

import cn.eli.vue.api.CommonResult
import cn.eli.vue.entity.User
import org.springframework.web.bind.annotation.*

/**
 * @author: Eli Shaw
 * @Date: 2019-05-24 15:57:55
 * @Description:
 */
@RestController //此注解是 @ResponseBody 和 @Controller 的组合注解，可返回一个 JSON
class LoginController {

    @RequestMapping(value = ["/admin/login"], method = [RequestMethod.POST])
    fun admin(@RequestBody user: User): CommonResult<*> {
        return if (user.username == "admin" && user.password == "123456") {
            CommonResult.success("admin")
        } else {
            CommonResult.validateFailed()
        }
    }
}

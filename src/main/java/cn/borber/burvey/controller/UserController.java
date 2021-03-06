package cn.borber.burvey.controller;

import cn.borber.burvey.model.BaseResponseBody;
import cn.borber.burvey.model.BaseResponseCode;
import cn.borber.burvey.model.VO.UserLoginVO;
import cn.borber.burvey.model.VO.UserRegisterVO;
import cn.borber.burvey.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BORBER
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public BaseResponseBody login(@RequestBody UserLoginVO vo) {
        String token = userService.login(vo);
        if (token != null) {
            return BaseResponseBody.success(token);
        } else {
            return BaseResponseBody.fail(BaseResponseCode.RC3);
        }
    }

    @PostMapping("register")
    public BaseResponseBody register(@RequestBody UserRegisterVO vo) {
        return BaseResponseBody.success(userService.register(vo));
    }

}

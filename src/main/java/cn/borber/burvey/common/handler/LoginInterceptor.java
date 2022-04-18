package cn.borber.burvey.common.handler;

import cn.borber.burvey.common.exception.LoginException;
import cn.borber.burvey.common.util.JsonUtil;
import cn.borber.burvey.model.DTO.BaseUserDTO;
import cn.borber.burvey.model.UserContext;
import cn.borber.burvey.service.IRedisService;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author BORBER
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private IRedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws LoginException {
        String token = request.getHeader("token");
        log.info("token值：{}", token);
        if (StringUtils.isBlank(token)) {
            log.error("认证失败");
            throw new LoginException("登录失效，请重新登录！");
        }
        String json = (String) redisService.get(token);
        if (json == null) {
            log.info("认证失败");
            throw new LoginException("登录失效，请重新登录！");
        } else {
            BaseUserDTO user = JsonUtil.toObject(json, BaseUserDTO.class);
            UserContext.setBaseUser(user);
        }
        return true;
    }
}

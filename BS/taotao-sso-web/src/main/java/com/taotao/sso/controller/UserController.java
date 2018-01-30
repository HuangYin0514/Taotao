package com.taotao.sso.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;
import com.taotao.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户处理Controller
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/check/{param}/{type}")
    @ResponseBody
    public TaotaoResult chekUsrData(@PathVariable String param, @PathVariable Integer type) {
        TaotaoResult result = userService.checkData(param, type);
        return result;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult regitster(TbUser user) {
        TaotaoResult result = userService.register(user);
        return result;
    }
}

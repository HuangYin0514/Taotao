package com.taotao.sso.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbUser;
import com.taotao.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户处理Controller
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

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

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult login(String username, String password,
                              HttpServletRequest request, HttpServletResponse response) {
        TaotaoResult result = userService.login(username, password);
        //登陆成功后写cookie
        if (result.getStatus() == 200) {
            //把token写入cookie
            CookieUtils.setCookie(request, response, TOKEN_KEY, result.getData().toString());
        }
        return result;
    }

/*    @RequestMapping(value = "/user/token/{token}", method = RequestMethod.GET,
                    //指定返回响应数据的content-type。防止有些浏览器不好使，不能读取json数据。
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String getUserByToken(@PathVariable String token, String callback) {
        TaotaoResult result = userService.getUserByToken(token);
        //判断是否为jsoup请求
        if (StringUtils.isNotBlank(callback)) {
            return callback + "(" + JsonUtils.objectToJson(result) + ")";
        }
        return JsonUtils.objectToJson(result);
    }*/

    //jsonp本质就是给浏览器传递一个js
    //jsonp的第二种方法，spring4.1以上版本使用
    @RequestMapping(value = "/user/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserByToken(@PathVariable String token, String callback) {
        TaotaoResult result = userService.getUserByToken(token);
        //判断是否为jsoup请求
        if (StringUtils.isNotBlank(callback)) {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            //设置回调方法
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
        return result;
    }



    //注释内容是接口文档要求返回的数据。
    //为提高简便性。故作一些调整
    //如果后续有时间需要把taotao-portal-web工程下taotao.js中代码改成ajax方案
    @RequestMapping(value = "/user/logout/{token}", method = RequestMethod.GET)
    /*@ResponseBody*/
    public String /*TaotaoResult*/ logoutByToken(@PathVariable String token) {
        TaotaoResult result = userService.logoutByToken(token);
        /*return result;*/
        return "login";
    }
}

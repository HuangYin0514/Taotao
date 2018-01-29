package com.taotao.item.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * 静态页面处理Controller
 */
@Controller
public class HtmlGenController {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @RequestMapping("/genhtml")
    @ResponseBody
    public String genHtml() throws Exception{
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        Template template = configuration.getTemplate("hello.ftl");
        Map data = new HashMap();
        data.put("hello", "spring freemarker test");
        Writer out = new FileWriter(new File("C:/Users/10713/Desktop/freemark/ftl/test.html"));
        template.process(data, out);
        out.close();
        return "ok";
    }
}

package com.taotao.freemarker;

import freemarker.template.Template;
import org.junit.Test;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

public class TestFreeMarker {

    /*@Test*/
    public void testFreemarker() throws Exception {
        //1创建一个模板文件
        //2创建一饿Configuration对象
        freemarker.template.Configuration configuration = new freemarker.template.Configuration(freemarker.template.Configuration.getVersion());
        //3设置模板所在的路径
        configuration.setDirectoryForTemplateLoading(new File("C:/Users/10713/Documents/ideaFile/BS/taotao-item-web/src/main/webapp/WEB-INF/ftl"));
        //4设置模板的字符集，一般utf-8
        configuration.setDefaultEncoding("utf-8");
        //5使用Configuration对象加载一个模板文件，需要指定模板文件的文件名
        //6创建一个数据集，可以说pojo也可以是map，推荐使用map
//        Template template = configuration.getTemplate("hello.ftl");
        Template template = configuration.getTemplate("student.ftl");
        Map data = new HashMap<>();
        data.put("hello", "hello freemaker");
        Student student = new Student(1, "张三", 11, "辽宁锦州");
        data.put("student", student);
        List<Student> stuList = new ArrayList<>();
        stuList.add(new Student(1, "张三1", 11, "辽宁锦州"));
        stuList.add(new Student(2, "张三2", 11, "辽宁锦州"));
        stuList.add(new Student(3, "张三3", 11, "辽宁锦州"));
        stuList.add(new Student(4, "张三4", 11, "辽宁锦州"));
        stuList.add(new Student(5, "张三5", 11, "辽宁锦州"));
        stuList.add(new Student(6, "张三6", 11, "辽宁锦州"));
        stuList.add(new Student(7, "张三7", 11, "辽宁锦州"));
        data.put("stuList", stuList);
        data.put("date", new Date());
        data.put("val", 123456);
        //7创建一个Writer对象，指定输出文件的路径及文件名
        Writer out = new FileWriter(new File("C:/Users/10713/Desktop/freemark/ftl/student.html"));
        //8使用模板对象的process方法输出文件
        template.process(data,out);
        //9关闭流
        out.close();
    }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-01-27 09:30:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.error;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class exception_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\" />\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\" />\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\" />\r\n");
      out.write("<meta name=\"format-detection\" content=\"telephone=no\" />\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\r\n");
      out.write("<meta name=\"format-detection\" content=\"telephone=no\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>出错了 -淘淘商城</title>\r\n");
      out.write("<!--结算页面样式-->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/base.css\" media=\"all\" />\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"/css/order-commons.css\"\r\n");
      out.write("\tsource=\"widget\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-1.6.4.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/base.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/order.common.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.checkout.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"mainframe\">\r\n");
      out.write("\t<div class=\"w w1 header clearfix\">\r\n");
      out.write("\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\t<a href=\"/\"><img src=\"/images/taotao-logo.gif\" alt=\"淘淘商城\"></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"w\">\r\n");
      out.write("\t\t<div id=\"refresh\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<style type=\"text/css\">\r\n");
      out.write("#refresh {\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tmargin: 30px auto;\r\n");
      out.write("\twidth: 750px;\r\n");
      out.write("\theight: 220px;\r\n");
      out.write("\tbackground:\r\n");
      out.write("\t\turl(/images/errordog.jpg)\r\n");
      out.write("\t\t0 0;\r\n");
      out.write("\tposition: relative\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#refresh .txt {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tleft: 236px;\r\n");
      out.write("\ttop: 16px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tfont-family: \"microsoft yahei\"\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#refresh .m {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tleft: 336px;\r\n");
      out.write("\ttop: 80px;\r\n");
      out.write("\tline-height: 18px;\r\n");
      out.write("\tfont-size: 14px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#refresh .m li {\r\n");
      out.write("\tpadding-bottom: 8px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#refresh .m a {\r\n");
      out.write("\tcolor: #005eab\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#refresh .m .fore1, #refresh .m .fore2 {\r\n");
      out.write("\tfont-family: \"microsoft yahei\"\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#refresh .m .fore1 a {\r\n");
      out.write("\tcolor: #e4393c\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#refresh .m .fore2 a {\r\n");
      out.write("\tcolor: #e4393c;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tfont-size: 18px;\r\n");
      out.write("\tpadding: 0 3px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#refresh .m .fore3 {\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tfont-size: 12px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#refresh .m .fore4 a {\r\n");
      out.write("\tmargin-right: 15px;\r\n");
      out.write("\tfont-size: 12px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\t\t\t<span class=\"txt\">糟了...系统出错了...</span>\r\n");
      out.write("\t\t\t<ul class=\"m\">\r\n");
      out.write("\t\t\t\t<li class=\"fore1\">您可以：稍后再试或联系客服400-8888-9999。\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li class=\"fore2\">返回<a href=\"/\" target=\"_blank\">淘淘首页</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"fore3\">错误消息</li>\r\n");
      out.write(" \t\t\t\t<li class=\"fore4\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- footer start -->\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../commons/footer.jsp", out, false);
      out.write("<!-- footer end -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

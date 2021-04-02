package com.x;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author dxy
 * @date 2021/3/26 - 22:32
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream resourceAsStream = this.getServletContext().getResourceAsStream("WEB-INF/classes/db.properties");
        InputStream stream = Servlet2.class.getClassLoader().getResourceAsStream("db.properties");
        ServletContext servletContext = this.getServletContext();
        InputStream stream1 = servletContext.getResourceAsStream("WEB-INF/classes/db.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String url = properties.getProperty("url");
        resp.getWriter().println(url);
        stream1.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

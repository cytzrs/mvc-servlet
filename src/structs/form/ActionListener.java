package structs.form;

import structs.utils.Structs_xml;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

/**
 * Created by cytzr on 2016/1/19.
 */
public class ActionListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        String xmlPath = context.getInitParameter("structs-config.xml");
        //String tomcatPath = context.getRealPath("\\");
        Map<String, XmlBean> map = Structs_xml.parse(xmlPath);
        context.setAttribute("struts", map);
        System.out.println("信息: 系统加载已完成!!!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("信息: 系统已注销!!!");
    }
}

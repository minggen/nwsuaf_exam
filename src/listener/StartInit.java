package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.utils.HibernateUtils;

public class StartInit implements ServletContextListener {  
     
    // 系统初始化执行方法  
    public void contextDestroyed(ServletContextEvent e) {  
        System.out.println("系统停止...");  
    }  
  
    public void contextInitialized(ServletContextEvent e) {  
        System.out.println("系统初始化开始...");  
          
        HibernateUtils.getSession();
                 
        System.out.println("系统初始化结束...");  
    }  
      
}  

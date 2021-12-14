package org.hzz;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @Author 静默
 * @Email 1193094618@qq.com
 */
public class BootStrap {
    /**
     * 模仿Tomcat的启动类
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        SecurityManager securityManager = System.getSecurityManager();
        if(securityManager != null){
            System.out.println("开启了安全模式");
        }
        ClassLoader classLoader = createClassLoader();
        Class<?> clazz = classLoader.loadClass("org.hzz.readfile.ReadFile");
        System.out.println(clazz.getClassLoader());
        Object instance = clazz.newInstance();
        String methodName = "readFile";
        Class[] parameterTypes = new Class[]{String.class};
        Object[] parameterValues = new Object[]{"docs/books.txt"};
        Method method = instance.getClass().getMethod(methodName, parameterTypes);
        method.invoke(instance, parameterValues);
    }

    /**
     * 自定义一个加载当前lib/read_file.jar的类加载器
     *
     * @return
     */
    public static ClassLoader createClassLoader() throws IOException {
        // lib
        File directory = new File("lib/read_file.jar");
        // file:/D:/Github/Learn-Java/security_manager/lib/read_file.jar
        directory = directory.getCanonicalFile();

        // file:/D:/Github/Learn-Java/security_manager/lib/read_file.jar
        String fileUrlString = directory.toURI().toString();
        URL url = new URL(fileUrlString);
        return AccessController.doPrivileged(
                (PrivilegedAction<URLClassLoader>) () -> new URLClassLoader(new URL[]{url})
        );
    }
}
/** 输出
 * java.net.URLClassLoader@74a14482
 * Hello URLClassLoad example and security manager
 */
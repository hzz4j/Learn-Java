package org.hzz;

/**
 * @Author 静默
 * @Email 1193094618@qq.com
 */
public class DemoDoPrivilege {
    public static void main(String[] args) {
        // 系统模式是没有开启的，也可以通过  -Djava.security.manager 指定vm的参数来开启
        SecurityManager securityManager = System.getSecurityManager();
        if(securityManager==null){
            // 打开系统安全权限检查开关
            System.setSecurityManager(new SecurityManager());
        }

        FileUtil.doPrivilegedAction("temp1.txt");

        System.out.println();

        FileUtil.makeFile("temp2.txt");
    }
}

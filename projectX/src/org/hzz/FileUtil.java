package org.hzz;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

/**
 * @Author 静默
 * @Email 1193094618@qq.com
 */
public class FileUtil {
    public static void main(String[] args) {
        System.out.println("Hello this is FileUtil");
    }
    public static void makeFile(String filename){
        File file = new File(filename);
        try {
            boolean newFile = file.createNewFile();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("makeFile success: "+file.getCanonicalFile().toURI().getPath());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doPrivilegedAction(String filename){
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                @Override
                public Void run() throws Exception {
                    File file = new File(filename);
                    boolean newFile = file.createNewFile();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("doPrivilegedAction success: "+file.getCanonicalFile().toURI().getPath());
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    return null;
                }
            });
        } catch (PrivilegedActionException e) {
            e.printStackTrace();
        }
    }
}

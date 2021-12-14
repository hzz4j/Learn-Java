package org.hzz.readfile;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @Author 静默
 * @Email 1193094618@qq.com
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ReadFile readFile = new ReadFile();
        System.out.println("test");
        readFile.readFile("test/foo.txt");
//        AccessController.doPrivileged(new PrivilegedAction<Void>() {
//            @Override
//            public Void run() {
//                try {
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//        });

    }
}

package org.hzz.readfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

/**
 * @Author 静默
 * @Email 1193094618@qq.com
 */
public class ReadFile {
    public void readFile(String filename) throws Exception {
        AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
            @Override
            public Void run() throws IOException{
                FileInputStream fin = new FileInputStream(filename);
                int i = 0;
                byte[] buf = new byte[1024];
                while ((i = fin.read(buf)) != -1) {
                    String value = new String(buf, 0, i, StandardCharsets.UTF_8);
                    System.out.print(value);
                }
                return null;
            }
        });

    }
}

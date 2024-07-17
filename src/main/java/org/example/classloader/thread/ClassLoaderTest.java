package org.example.classloader.thread;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {
    public static void main(String[] args) {
        final DiskClassLoader diskLoader1 = new DiskClassLoader("D:\\lib\\test");
        Class cls1 = null;
        try {
            cls1 = diskLoader1.loadClass("org.example.classloader.thread.SpeakTest");
            System.out.println(cls1.getClassLoader().toString());
            if (cls1 != null) {
                Object obj = cls1.newInstance();
                Method method = cls1.getDeclaredMethod("speak", null);
                method.invoke(obj, null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        final DiskClassLoader diskLoader = new DiskClassLoader("D:\\lib");
        System.out.println("Thread " + Thread.currentThread().getName() + " classloader: " + Thread.currentThread().getContextClassLoader().toString());

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {

                    Thread.currentThread().setContextClassLoader(diskLoader1);
                    System.out.println("Thread " + Thread.currentThread().getName() + " classloader: " + Thread.currentThread().getContextClassLoader().toString());

                    ClassLoader cl = Thread.currentThread().getContextClassLoader();

                    Class<?> c = cl.loadClass("org.example.classloader.thread.SpeakTest");
                    System.out.println(c.getClassLoader().toString());
                    if (c != null) {
                        Object obj = c.newInstance();
                        Method method = c.getDeclaredMethod("speak", null);
                        method.invoke(obj, null);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setName("thread0");
        thread.start();

    }
}

package org.example.classloader.thread.v2;

import org.example.classloader.thread.ISpeak;

public class SpeakTest implements ISpeak {
    public void speak() {
        System.out.println("hello ,i am the SpeakV2.");
    }
}

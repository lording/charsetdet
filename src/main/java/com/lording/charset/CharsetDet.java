package com.lording.charset;


import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import java.io.IOException;

public class CharsetDet {
    public static void main(String[] args) {
        String text = "我是utf-8 字符集";
        CharsetDetector detector = new CharsetDetector();
        //传入方式为字节数组或输入流
        //detector.setText(new FileInputStream(new File("")));
        detector.setText(text.getBytes());

        //获取所有可能匹配的编码格式数组
        //CharsetMatch[] matches = detector.detectAll();
        //获取可能性最高的编码格式，一般这个就够用
        CharsetMatch match = detector.detect();

        //获取可能性，值从0~100, 可以理解为字符与编码格式的匹配程度从0%~100%，一般60%以上就可以确定了
        int confidence = match.getConfidence();

        //编码格式的名字，例：UTF-8
        String name = match.getName();
        System.out.println("charset nanem: " + name);
        //大致意思是根据字节数据或输入流对应的Unicode编码集，将数据写成字符串
        String textStr = null;
        try {
            textStr = match.getString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("str: " + textStr);
    }
}

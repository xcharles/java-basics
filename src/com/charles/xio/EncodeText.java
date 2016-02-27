package com.charles.xio;

import java.io.UnsupportedEncodingException;

/**
 * Created by charles on 16/2/27.
 * 若你的字节序列以某种方式编码后,要想转成字符串必须使用统一的编码方式,否则乱码
 * 两者要统一
 *
 * 文本文件可以是任意编码的字节序列,若是直接在中文机器上创建文本文件时
 * 它只识别ANSI编码,但是你可以以UTF-8方式的编码创建,并粘贴
 */
public class EncodeText {
    public static void main(String[] args) {
        String s = "苹果ABC";
        /*系统默认编码是utf-8,中文占用3个字节,英文占用1个字节*/
        byte[] b1 = s.getBytes();
        for(byte b : b1) {
            //把byte变成int,再以16进制显示,取整数的最后一个字节,其他均为0
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        /*utf-8编码*/
        try {
            byte[] b2 = s.getBytes("utf-8");
            for(byte b : b2) {
                System.out.print(Integer.toHexString(b & 0xff) + " ");
            }
            System.out.println();
            String str1 = new String(b2);
            System.out.println(str1);
            String str2 = new String(b2,"utf-8");
            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /*gbk编码,中文占用2个字节,英文占用1个字节*/
        try {
            byte[] b3 = s.getBytes("gbk");
            for(byte b : b3) {
                System.out.print(Integer.toHexString(b & 0xff) + " ");
            }
            System.out.println();
            String str1 = new String(b3);
            System.out.println(str1);
            String str2 = new String(b3,"gbk");
            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /*Java的双字节编码(1个字符占用2个字节),所有的字符都占用2个字节,中文和英文都一样*/
        try {
            byte[] b4 = s.getBytes("utf-16be");
            for(byte b : b4) {
                System.out.print(Integer.toHexString(b & 0xff) + " ");
            }
            System.out.println();
            String str1 = new String(b4);
            System.out.println(str1);
            String str2 = new String(b4,"utf-16be");
            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}

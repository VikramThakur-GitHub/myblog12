package com.myblog.myblog11;

public class TestClass4 {
    public static void main(String[] args) {
        String str ="aa aaa bbbb ccccc ";
        int length= str.length();
        int a=0, b=0, c=0, s=0;

        for (int i=0; i<length; i++){

            switch (str.charAt(i)){
                case 'a':
                    a++;
                    break;
                case 'b':
                    b++;
                    break;
                case 'c':
                    c++;
                    break;
                case ' ':
                    s++;
                    break;
            }
        }
        int largest = a;
        char ch='a';

        if (b > largest) {
            largest = b;
            ch='b';
        }

        if (c > largest) {
            largest = c;
            ch='c';
        }

        if (s > largest) {
            largest = s;
            ch=' ';
        }


        System.out.println("The character with highest count is :"+ ch);
    }
}

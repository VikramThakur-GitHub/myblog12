package com.myblog.myblog11;

public class TestClass2 {
    public static void main(String[] args) {

        TestClass2 testClass = new TestClass2();
        int val= testClass.test();
        System.out.println(val);
    }

    public int test(){
        int otp = SampleTest.test1();
        return otp;
    }


}

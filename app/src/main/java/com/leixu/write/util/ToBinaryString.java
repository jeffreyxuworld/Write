package com.leixu.write.util;

import android.util.Log;

/**
 * Created by Lei on 2017/10/20.
 * 十进制转二进制转化
 */

public class ToBinaryString {


    public static void toBinaryString(){
        //十进制转换为二进制
//        System.out.println(Integer.toBinaryString(10));
        Log.i("Lei", Integer.toBinaryString(128));

    }


    public static void toBinaryString1(){

        int a = 10;//定义一个变量并赋给他一个十进制的值
        int remainder;//定义一个变量用于存储余数
        int sum = 0;//定义一个变量用于存放和
        int k = 1;//定义一个变量控制位数

        while(a != 0){

            remainder = a % 2;//对目标数字求余
            a /= 2;//对目标数字求商
            sum = sum + remainder * k;//求和
            k *= 10;//改变位数

        }
//        System.out.println("10进制的123转换为2进制结果为：" + sum );

        Log.i("Lei", "" + sum );


    }


    public static void toBinaryString2(){
        int n = -10;
        String result = "";
        boolean minus = false;

        //如果该数字为负数，那么进行该负数+1之后的绝对值的二进制码的对应位取反，然后将它保存在result结果中
        if(n < 0){
            minus = true;
            n = Math.abs(n + 1);
        }

        while(true){
            int remainder = (!minus && n % 2 == 0) || (minus && n % 2 == 1) ? 0 : 1;

            //将余数保存在结果中
            result = remainder + result;
            n /= 2;

            if(n == 0){
                break;
            }
        }

        //判断是否为负数，如果是负数，那么前面所有位补1
        if(minus){
            n = result.length();
            for(int i = 1; i <= 32 - n; i++){
                result = 1 + result;
            }
        }

//        System.out.println(result);

        Log.i("Lei", result);
    }


    /**
     * 二进制转十进制
     */
    public static void binaryString2Decimal(){

        Log.i("Lei", "" + Integer.parseInt("1101", 2) );
    }

    public static void binaryString2Decimal1(){

        int binaryNumber = 110111;
        int decimal = 0;
        int p = 0;
        while(true){
            if(binaryNumber == 0){
                break;
            } else {
                int temp = binaryNumber%10;
                decimal += temp*Math.pow(2, p);
                binaryNumber = binaryNumber/10;
                p++;
            }
        }
        Log.i("Lei", ""+ decimal);

    }


}

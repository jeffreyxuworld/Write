package com.leixu.write.kotlin.generic

/**
 * Created by Lei on 2017/11/3.
 *
 * 测试泛型的用法
 *
 */
class LeiTest {


    fun main(args: Array<String>){
        var boxInt = Box<Int>(10)
        var boxString = Box<String>("Lei")

        println(boxInt.value)
        println(boxString.value)



    }


}
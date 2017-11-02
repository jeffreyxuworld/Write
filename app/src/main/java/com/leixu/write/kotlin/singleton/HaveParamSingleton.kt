package com.leixu.write.kotlin.singleton

/**
 * Created by Lei on 2017/11/2.
 * 带参数的单例
 *
 */
class HaveParamSingleton private constructor(str: String){

    var string: String = str;

    init {
        println("str is $str")
        println("string is $string")
    }

    companion object {

        var instance: HaveParamSingleton? = null

        fun getInstance(c: String): HaveParamSingleton {
            if(instance == null){
                synchronized(HaveParamSingleton::class){
                    if(instance == null){
                        instance = HaveParamSingleton(c)
                    }
                }
            }

            return instance!!
        }

    }


}
package com.leixu.write.kotlin.singleton

/**
 * Created by Lei on 2017/11/2.
 * 不带参数的懒加载单例
 */
class LazySingleton private constructor(){

    init { println("This ($this) is a singleton") }

    private object Holder { val INSTANCE = LazySingleton() }

    companion object {
        val instance: LazySingleton by lazy {
//            LazySingleton()
            Holder.INSTANCE
        }
    }

    var b:String? = null


}
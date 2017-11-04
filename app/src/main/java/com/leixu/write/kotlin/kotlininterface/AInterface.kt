package com.leixu.write.kotlin.kotlininterface

/**
 * Created by Lei on 2017/11/3.
 *
 */
interface AInterface {

    fun foo() { print("A") }   // 已实现
    fun bar()                  // 未实现，没有方法体，是抽象的

}
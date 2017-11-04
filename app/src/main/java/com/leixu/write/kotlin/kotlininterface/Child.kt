package com.leixu.write.kotlin.kotlininterface

/**
 * Created by Lei on 2017/11/3.
 *
 */
class Child : MyInterface, AInterface, BInterface{

    override fun foo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        super<AInterface>.foo()
        super<BInterface>.foo()

    }



    override var name: String = "Lei"

    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        super<BInterface>.bar();
    }

    fun main(args : Array<String>){
        val c = Child()
        c.foo()
        c.bar()


        println(c.name)
    }

}
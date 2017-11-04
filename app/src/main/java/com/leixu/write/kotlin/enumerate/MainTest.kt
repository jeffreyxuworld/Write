package com.leixu.write.kotlin.enumerate

/**
 * Created by Lei on 2017/11/3.
 *
 */
class MainTest {

    fun main(args: Array<String>){
        val color: Color = Color.BLUE;

        println(Color.values())
        println(Color.valueOf("RED"))
        println(color.name)
        println(color.ordinal)


    }

    inline fun <reified T : Enum<T>> printAllValues() {
        print(enumValues<T>().joinToString { it.name })
    }


}
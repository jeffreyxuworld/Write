package com.leixu.write.kotlin.enumerate

/**
 * Created by Lei on 2017/11/3.
 *
 */
enum class ProtocolState {

    WAITING{
        override fun signal() = TALKING
    },

    TALKING{
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState



}
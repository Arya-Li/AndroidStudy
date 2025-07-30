package com.example.uibestpractice

class Msg(val content : String, val type : Int) {
    // 定义常量，定义收到/发出消息
    // 定义静态方法、静态属性
    companion object {
        /**
         *  1.值必须在编译时确定（只能是基本类型或 String）
         *  2.隐式 public
         *  3.编译后常量会被直接替换为字面量，无运行时开销
         */
        const val  TYPE_RECEIVED = 0
        const val TYPE_SEND = 1
    }
}
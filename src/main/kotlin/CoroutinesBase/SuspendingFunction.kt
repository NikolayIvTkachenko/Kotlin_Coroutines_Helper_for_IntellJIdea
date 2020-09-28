package CoroutinesBase

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var functionCalls = 0

fun main() {
    //function that can be run in a coroutine
    //Make callbacks sezmless

    GlobalScope.launch {
        completedMessage()
    }
    GlobalScope.launch {
        improveMessage()
    }

    print("Message ->")
    Thread.sleep(2000L)
    println ("There have been $functionCalls calls so far")
}

suspend fun testOperation(){
    println("Test Operation")
}

suspend fun completedMessage(){
    delay(500L)
    print(" =  Message ->")
    functionCalls++
}

suspend fun improveMessage(){
    delay(1000L)
    println("Suspend functions are cool")
    functionCalls++
}
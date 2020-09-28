package CoroutinesBase

import kotlinx.coroutines.*

fun main() {

    //A dispatcher determines which thread or thread pool the coroutine runc on
    //Different dispatcher are avalable depending on the task specificity

//    launch(Dispatchers.Default){
//        //do seme thing intensive for CPU
//
//    }


    //Common dispatchers
    //- Main (Main thread update UI for Android or Main dispatcher needs to be defined in Grandle)
    //- Default - for intensive CPU
    //- IO - for network communication
    //- Unconfined - Start the coroutines in the inherited dispatcher that called it
    //- new SingleThreadContext("CustomThread") - Forces creation of  a new thread

    runBlocking {

        //Error is appear. Use for Android
//        launch(Dispatchers.Main) {
//            println("Main dispatcher. Thread : ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined1. Thread : ${Thread.currentThread().name}")
            delay(100L)
            println("Unconfined2. Thread : ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default. Thread : ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO. Thread : ${Thread.currentThread().name}")
        }


        launch(newSingleThreadContext("TestThread")) {
            println("newSingleThreadContext. Thread : ${Thread.currentThread().name}")
        }

    }


}
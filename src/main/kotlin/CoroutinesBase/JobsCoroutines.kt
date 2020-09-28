package CoroutinesBase

import kotlinx.coroutines.*

fun main() {

    //.launch call return a Job
    //Allows us to manipulate the coroutines lifecycle
    //Live in the hierarchy of other Jobs
    //both as parents or childeren
    //Can access lifecycle variables and methods
    //-cancel
    //-join

    val job1 = GlobalScope.launch {
        coroutineScope {
            val job2 = launch {
                println("Processing...")
            }
        }
    }

    runBlocking {
        val job11 = launch {
            //delay(3000L)
            println("Job11 launched")
            val job22 = launch {
                println("Kob22 launched")
                delay(3000L)
                println("Kob22 lis finishing")
            }
            job22.invokeOnCompletion { println("Job22 completed") }
            val job33 = launch {
                println("Job33 launched")
                delay(3000L)
                println("Job33 is finished")
            }
            job33.invokeOnCompletion { println("Job33 completed") }
        }
        job11.invokeOnCompletion { println("Job11 completed or canceled") }
        delay(500L)
        println("Job11 will be canceled")
        job11.cancel()
    }


}
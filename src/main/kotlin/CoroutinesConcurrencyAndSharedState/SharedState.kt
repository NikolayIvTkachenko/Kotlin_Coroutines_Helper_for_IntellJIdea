package CoroutinesConcurrencyAndSharedState

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {

    //Shared State
    //Multiple coroutines can update a shared state variable concurrently
    //Some updates may be lost
    //

    runBlocking {
        var counter = 0
        withContext(Dispatchers.Default) {
            massiveRun { counter++ }
        }
        println("Counter = $counter")
    }

    //It is bag
    //Completed 100000 actions in 22 ms
    //Counter = 65692 this value must be 100000
}

suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) {
                        action()
                    }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}
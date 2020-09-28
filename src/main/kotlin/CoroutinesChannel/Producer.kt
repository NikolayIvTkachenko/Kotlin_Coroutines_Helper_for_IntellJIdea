package CoroutinesChannel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {

    //Channel producer
    //Allows a data source to create and return a channel
    //Needs a Coroutine Scope

    runBlocking {
        produceSquares().consumeEach { println(it) }
    }

    runBlocking {
        val  channel: ReceiveChannel<Int>  = produce{
            for (x in 1..10)
                send(x * x)
        }

        for(y in channel)
            println(y)
    }
}

fun CoroutineScope.produceSquares() = produce {
    for(x in 1..5)
        send(x * x)
}
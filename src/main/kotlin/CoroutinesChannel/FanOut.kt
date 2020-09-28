package CoroutinesChannel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    //FanOut
    //If multiple coroutines receive from the same channel values (work) are distributed among them
    //

    runBlocking {
        val producer = produceNewNumbers()
        repeat(5) { launchProcessor(it, producer) }
        delay(1500L)
        producer.cancel()
    }
}

fun CoroutineScope.produceNewNumbers() = produce {
    var x = 1
    while (true) {
        send(x++)
        delay(100L)
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) =
    launch {
        for (message in channel)
            println("Processor $id received $message")
    }
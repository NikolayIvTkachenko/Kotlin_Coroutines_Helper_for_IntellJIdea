package CoroutinesChannel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {

    //Pipeline
    //A pipeline is a development pattern
    //where one channel output is given as an input to another channel
    //One coroutine is producing a (potentially infinite) set of values
    //One or more coroutines are consuming and transforming those values

    runBlocking {
        val numbers = produceNumbers()
        val squares = square(numbers)
        for (i in 1..5)
            println(squares.receive())
        println("Done!")
        coroutineContext.cancelChildren()
    }
}

fun CoroutineScope.produceNumbers() = produce {
    var x = 1
    while (true)
        send(x++)
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>) = produce {
    for (x in numbers)
        send(x * x)
}
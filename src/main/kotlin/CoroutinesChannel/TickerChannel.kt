package CoroutinesChannel

import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    //Ticker channel
    //Periodically produces a unit after a given delay
    //Has an optional initial delay
    //

    runBlocking {
        val tickerChannel = ticker(100)
        launch {
            val startTime = System.currentTimeMillis()
            tickerChannel.consumeEach {
                val delta = System.currentTimeMillis() - startTime
                println("Received tick after $delta")
            }
        }

        delay(1000)
        println("Done!")
        tickerChannel.cancel()
    }
}
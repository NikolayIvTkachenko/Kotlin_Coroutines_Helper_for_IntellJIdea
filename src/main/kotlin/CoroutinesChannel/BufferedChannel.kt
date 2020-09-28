package CoroutinesChannel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    //Buffered channels
    //Limit of the sie a channel
    //A buffered channel hasa limited capacity but casual  not
    //When the capacity is reached the sender is paused
    //When capacity becomes available new values can be sent


    runBlocking {
        val channel = Channel<Int>(4)
        val sender = launch {
            repeat(10){
                channel.send(it)
                println("Sent $it")
            }
        }

        repeat(3) {
            delay(1000)
            println("Received ${channel.receive()}")
            println("Received ${channel.receive()}")
        }
        sender.cancel()
    }
}
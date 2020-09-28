package CoroutinesChannel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    //Channels
    //A coroutine can asynchronously put elements .send(data)
    //Another can blocking get elements .receive()
    //A channel is closed when there are no more elements .close



    runBlocking {
        val channel = Channel<Int>()
        launch {
            for (x in 1..5)
                channel.send(x * x)
            channel.close()
        }

//        for(i in 1..5)
//            println(channel.receive())
        for (i in channel)
            println(i)
    }
}
package CoroutinesBase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {

    //withContext
    //Allows us to easily change context //SWITCH CONTEXT
    //Easily switch between dispatchers
    //Very lightweight

//    launch(Dispatchers.Default){
//        //default context
//        withContext(Dispatchers.IO){
//            //IO context
//        }
//        //back to default context
//    }

    runBlocking {
        launch(Dispatchers.Default) {
            println("First context: $coroutineContext")
            withContext(Dispatchers.IO){
                println("Second context: $coroutineContext")
            }
            println("Third contex: $coroutineContext")
        }
    }


}
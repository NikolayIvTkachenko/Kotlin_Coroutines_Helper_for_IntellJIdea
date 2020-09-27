import kotlinx.coroutines.*

fun main() {

    //Scope
    //GlobalScope.launch{} - the scope of the coroutinrs is the lifecycle of the entire application
    //runBlocking - create a scope and runs a coroutines in blocking way
    //coroutineScope{} - creates a new scope does not complete until allall children coroutines complete

    runBlocking {
        launch {
            delay(1000L)
            println("Blocking code")

            coroutineScope {
                launch {
                    delay(500L)
                    println("custom coroitine scope")
                }
            }
        }
    }

    GlobalScope.launch {
        delay(1000L)
        println("Global code")

        coroutineScope {
            delay(1000L)
            println("custom coroitine scope")
        }
    }




    GlobalScope.launch {
        delay(1000)
        println("TestFirst01")
    }

    println("Test 2")
    Thread.sleep(2000)
}
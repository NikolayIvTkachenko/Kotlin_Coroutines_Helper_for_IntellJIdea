import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    //a context is a set of data that relates to the coroutine
    //All coroutines have an associated context
    // - Dispatcher - which thread the coroitine is run on
    // - Job - handle on the coroutine lifecycle

    runBlocking {
        launch(CoroutineName("testCoroutine")) {
            println("launch inside runBlocking ")
            println("This is run from ${this.coroutineContext.get(CoroutineName.Key)}")
        }

        GlobalScope.launch {
            println("GlobalScope.launch inside runBlocking ")
            println("This is run from ${this.coroutineContext.get(CoroutineName.Key)}")
        }
    }




}
import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.IndexOutOfBoundsException

fun main() {

    //Exception Handling
    //Exception behavior depends on the coroutine builder
    //launch
    //- Propagates through the parent child hierarchy
    //- The exception will be throw immediately and jobs will fail
    //- use try-catch or an exception handler

    //async
    //- Exceptionare deferred until the result is consumed
    //- if the result is not consumed the exception is never throw
    //- try-catch in the coroutine or in the await() call

//    val testHandler = CoroutineExceptionHandler{
//        coroutineContext, throwable ->
//        // handle exception
//
//    }

//    launch(testHandler){
//        //do some task here
//        throw indexOutOfBoundExcepton()
//    }

//    launch(Dispatchers.Default + testHandler){
//        //do some task here
//        throw IndexOutOfBoundsException
//    }

    runBlocking {

        val testHandler = CoroutineExceptionHandler{
            coroutineContext, throwable ->
            println("Exception handler: ${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch(testHandler) {
            println("Throwing exception from job")
            throw IndexOutOfBoundsException("exception in coroitine")
        }
        job.join()

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException("exception from async")
        }

        try {
            deferred.await()
        }catch (e:ArithmeticException){
            println("Caught Arithmetic Exception ${e.localizedMessage}")
        }

    }
}
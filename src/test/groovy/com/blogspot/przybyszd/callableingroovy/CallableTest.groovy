package com.blogspot.przybyszd.callableingroovy

import spock.lang.Specification

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CallableTest extends Specification {

    ExecutorService executorService = Executors.newSingleThreadExecutor()

    def 'submit callable as MyJob object'() {
        expect:
            executorService.submit(new MyJob()).get() == 42
    }

    def 'submit callable as map'() {
        expect:
            executorService.submit([call: { 42 }] as Callable).get() == 42
    }

    def 'submit callable as closure'() {
        expect:
            executorService.submit { 42 }.get() == null
    }

    def 'submit callable as closure with cast'() {
        when:
            int result = executorService.submit({ return 42 } as Callable<Integer>).get()
        then:
            result == 42
    }
}

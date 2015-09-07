package com.blogspot.przybyszd.callableingroovy

import java.util.concurrent.Callable

class MyJob implements Callable<Integer>{
    @Override
    Integer call() throws Exception {
        return 42
    }
}

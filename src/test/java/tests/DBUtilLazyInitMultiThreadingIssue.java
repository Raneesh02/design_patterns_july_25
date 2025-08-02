package tests;

import org.testng.annotations.Test;
import utilities.MultiThread;

public class DBUtilLazyInitMultiThreadingIssue {

    @Test
    public void dbUtilSingletonLazyMultiThreading(){
        for(int i=0;i<100;i++){
            MultiThread multiThread = new MultiThread();
            multiThread.start();
        }
    }
}
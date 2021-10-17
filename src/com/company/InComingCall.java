package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;

public class InComingCall {

    long answerTime = 350;
    ConcurrentLinkedQueue<Integer> inComingCalls = new ConcurrentLinkedQueue<>();

    public void addCall(Integer connectPort){
        inComingCalls.add(connectPort);
    }

    public void getCall() throws InterruptedException {
        while(!inComingCalls.isEmpty()){
            inComingCalls.poll();
            Thread.sleep(answerTime);
            System.out.println(Thread.currentThread().getName() + " отработала входящий звонок");
        }
    }
}

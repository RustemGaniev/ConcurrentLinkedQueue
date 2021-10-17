package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Calls {

    static int callsNumber = 60;
    static long inComingTime = 100;
    static int startInComingPortNumber = 900;
    ConcurrentLinkedQueue<Integer> inComingCalls = new ConcurrentLinkedQueue<>();


    public void addCall() throws InterruptedException {
        for (int i = 0; i < callsNumber; i++) {
            int connectPort = startInComingPortNumber + i;
            inComingCalls.add(connectPort);
            System.out.println(" У нас входящий звонок!");
            Thread.sleep(inComingTime);
        }
    }

    public void getCall(long answerTime) throws InterruptedException {
        while (!inComingCalls.isEmpty()) {
            Thread.sleep(answerTime);
            inComingCalls.poll();
            System.out.println( Thread.currentThread().getName() + " отработал входящий звонок");

        }
    }

}

package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        int callsNumber = 60;
        int threadSleepingTime = 55;
        int startInComingPortNumber = 900;
        InComingCall inComingCall = new InComingCall();

        ConcurrentLinkedQueue<Integer> calls = new ConcurrentLinkedQueue();

        for(int i = 0; i < callsNumber; i++){
            int incomingPort = i + startInComingPortNumber;
            Thread call = new Thread(null, () -> inComingCall.addCall((incomingPort)), "Входящий звонок ");
            call.start();
            Thread.sleep(threadSleepingTime);
            call.join();
        }

        Thread support = new Thread(null,() -> {
            try {
                inComingCall.getCall();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Служба поддержки");

        support.start();
        support.join();

    }
}

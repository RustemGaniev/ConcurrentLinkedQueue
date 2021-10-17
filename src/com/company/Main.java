package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Calls calls = new Calls();

        Thread call = new Thread(null, () -> {
            try {
                calls.addCall();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread support = new Thread(() -> {
            try {
                calls.getCall();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        call.start();
        support.start();

        call.join();
        support.join();
    }
}

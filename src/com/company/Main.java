package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Calls calls = new Calls();
        long answerIvanovTime = 350;
        long answerPetrovTime = 383;
        long answerSydorovTime = 397;

        Thread call = new Thread(null, () -> {
            try {
                calls.addCall();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread support1 = new Thread(() -> {
            try {
                calls.getCall(answerIvanovTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Сотрудник службы поддержки Иванов ");

        Thread support2 = new Thread(() -> {
            try {
                calls.getCall(answerPetrovTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Сотрудник службы поддержки Сидоров ");

        Thread support3 = new Thread(() -> {
            try {
                calls.getCall(answerSydorovTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Сотрудник службы поддержки Петров ");


        call.start();
        support1.start();
        support2.start();
        support3.start();

        call.join();
        support1.join();
        support2.join();
        support3.join();
    }
}

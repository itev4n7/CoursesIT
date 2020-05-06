package com.it.les1;

public class TestMain {
    public static void main(String[] args) throws Exception {
        Object o = new Object();
        new Thread(
                  () -> {
                      System.out.println("run-wait");
                      synchronized (o) {
                          try {
                              o.wait();
                              System.out.println("run-complete");
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                  }
        ).start();
        System.out.println("sleep...");
        Thread.sleep(2000);
        System.out.println("Main sleep");
        System.out.println("Main notify");
        synchronized (o) {
            o.notify();
        }
    }
}

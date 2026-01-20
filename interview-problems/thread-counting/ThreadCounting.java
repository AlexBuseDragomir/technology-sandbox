package org.example.threadcounting;

import java.util.concurrent.Semaphore;

/*
  Print odd/even numbers in sequence using 2 threads
  Goal: Two threads: one prints odd numbers up to 10,
  the other prints even numbers up to 10,
  but output must be in order: 1 2 3 4 ... 10.
*/

public class ThreadCounting {

  private static final int LIMIT = 10;
  private static int counter = 0;

  public static void startCounting() {
    counter = 0;

    final Semaphore semaphoreA = new Semaphore(1);
    final Semaphore semaphoreB = new Semaphore(0);

    final Runnable taskA = () -> runTask("Thread A", semaphoreA, semaphoreB);
    final Runnable taskB = () -> runTask("Thread B", semaphoreB, semaphoreA);

    final Thread t1 = Thread.startVirtualThread(taskA);
    final Thread t2 = Thread.startVirtualThread(taskB);

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private static void runTask(String name, Semaphore mine, Semaphore other) {
    try {
      while (true) {
        mine.acquire();
        try {
          if (counter >= LIMIT) {
            return; // wake the other thread so it can also terminate
          }
          counter++;
          System.out.println(name + " incremented to: " + counter);
        } finally {
          other.release();
        }
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      other.release();
    }
  }
}

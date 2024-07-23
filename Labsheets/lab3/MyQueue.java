import java.util.Scanner;

class MyQueue {
  static private int[] queue;
  static private int size, front, rear;

  MyQueue(int size) {
    MyQueue.size = size; // this.size
    front = rear = 0;
    queue = new int[size];
  }

  public void enqueue(int n) {
    if (MyQueue.isFull()) {
      System.out.println("Queue is full");
      return;
    } else {
      queue[rear] = n;
      rear++;
    }
    return;
  }

  public void dequeue(int n) {
    if (MyQueue.isEmpty()) {
      System.out.println("Queue is empty");
      return;
    } else {
      for (int i = 0; i < size - 1; i++)
        queue[i] = queue[i + 1];
      queue[size - 1] = 0;
      rear--;
    }
    return;
  }

  public void length() {
    if (MyQueue.isEmpty()) {
      System.out.println("Queue is empty");
      return;
    }
    System.out.println("Length of queue is: " + rear);
    return;
  }

  public void front() {
    if (MyQueue.isEmpty()) {
      System.out.println("Queue is empty");
      return;
    }
    System.out.println("Front element is: " + queue[front]);
    return;
  }

  public void back() {
    if (MyQueue.isEmpty()) {
      System.out.println("Queue is empty");
      return;
    }
    System.out.println("Back element is: " + queue[rear - 1]);
    return;
  }

  static private boolean isEmpty() {
    if (front == rear)
      return true;
    else
      return false;
  }

  static private boolean isFull() {
    if (size == rear)
      return true;
    else
      return false;
  }

  public static void main(String args[]) {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter size of queue: ");
    int size = sc.nextInt();
    MyQueue que = new MyQueue(size);
    boolean flag = true;
    while (flag) {
      System.out.println("Enter your choice: ");
      System.out.println("1. Enqueue ");
      System.out.println("2. Dequeue ");
      System.out.println("3. Length ");
      System.out.println("4. Front ");
      System.out.println("5. Back ");
      System.out.println("6. Exit ");

      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          System.out.print("Data to enqueue: ");
          int dataE = sc.nextInt();
          que.enqueue(dataE);
          break;
        case 2:
          System.out.print("Data to dequeue: ");
          int dataD = sc.nextInt();
          que.dequeue(dataD);
          break;
        case 3:
          que.length();
          break;
        case 4:
          que.front();
          break;
        case 5:
          que.back();
          break;
        case 6:
          flag = false;
          break;
      }
    }
  }
}

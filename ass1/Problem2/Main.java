package Q2;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void remove(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (head.data == data) {
            head = head.next;
            return;
        }
        Node prev = null;
        Node current = head;
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Data not found");
            return;
        }
        prev.next = current.next;
        current.next = null;
    }

    public void display() {
        Node current = head;
        if (current == null) {
            System.out.println("Empty list, nothing to display");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Menu:
            // 1. Add
            // 2. Remove
            // 3. Display
            // 4. Exit
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int valueToAdd = scanner.nextInt();
                    list.add(valueToAdd);
                    break;
                case 2:
                    int valueToRemove = scanner.nextInt();
                    list.remove(valueToRemove);
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}

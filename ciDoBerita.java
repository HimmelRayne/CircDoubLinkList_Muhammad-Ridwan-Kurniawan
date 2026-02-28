import java.util.Scanner;

class Node {
    String data;
    Node next, prev;
    Node(String data) {
        this.data = data;
        this.next = this.prev = null;
    }
}

class CircularDoublyLinkedList {
    Node head = null;

    void insert(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head.prev = head;
            return;
        }
        Node tail = head.prev;
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
    }

    void delete(int pos) {
        if (head == null) return;
        Node temp = head;
        int count = 1;
        do {
            if (count == pos) {
                if (temp.next == temp) {
                    head = null;
                    return;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                if (temp == head) head = temp.next;
                return;
            }
            temp = temp.next;
            count++;
        } while (temp != head);
        System.out.println("Position out of range.");
    }

    void displayForward() throws InterruptedException {
        if (head == null) { System.out.println("List kosong."); return; }
        Node temp = head;
        do {
            System.out.println(temp.data);
            temp = temp.next;
            if (temp != head) Thread.sleep(3000);
        } while (temp != head);
    }

    // FIX: was stopping before printing head node (off-by-one in loop termination)
    void displayBackward() throws InterruptedException {
        if (head == null) { System.out.println("List kosong."); return; }
        Node temp = head.prev; // start at tail
        do {
            System.out.println(temp.data);
            temp = temp.prev;
            if (temp != head.prev) Thread.sleep(3000);
        } while (temp != head.prev); // stop after full circle
    }

    void displayAt(int pos) {
        if (head == null) { System.out.println("List kosong."); return; }
        Node temp = head;
        int count = 1;
        do {
            if (count == pos) {
                System.out.println(temp.data);
                return;
            }
            temp = temp.next;
            count++;
        } while (temp != head);
        System.out.println("Position out of range.");
    }
}

public class ciDoBerita {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        int choice;
        do {
            System.out.println("1.Insert berita");
            System.out.println("2.Hapus berita");
            System.out.println("3.Tampilkan forward");
            System.out.println("4.Tampilkan backward");
            System.out.println("5.Tampil berita tertentu");
            System.out.println("6.Exit");
            System.out.print("Pilih: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan berita: ");
                    String text = sc.nextLine();
                    list.insert(text);
                    break;
                case 2:
                    System.out.print("Masukkan posisi: ");
                    int pos = sc.nextInt();
                    list.delete(pos);
                    break;
                case 3:
                    list.displayForward();
                    break;
                case 4:
                    list.displayBackward();
                    break;
                case 5:
                    System.out.print("Masukkan posisi: ");
                    int p = sc.nextInt();
                    list.displayAt(p);
                    break;
                case 6:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 6);
        sc.close();
    }
}
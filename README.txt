Buat program (Java & Python) untuk simulasi teks berjalan berisi berita seperti yang sering tampil di televisi. Program menggunakan struktur data Circular Doubly Linked List. Program dilengkapi dengan fitur tambah dan hapus teks berita. Teks berita akan tampil secara berurutan berdasarkan urutan dalam linked list.

MENU:
1. Insert berita (berita baru selalu ditambahkan di akhir)
2. Hapus berita (berdasarkan nomor urut)
3. Tampilkan berita secara forward (teks berita akan tampil dari depan ke belakang dengan delay 3 detik antar berita)
4. Tampilkan berita secara backward (teks berita akan tampil dari belakang ke depan dengan delay 3 detik antar berita)
4. Tampil berita tertentu (berdasarkan nomor urut)
5. Exit

yang disubmit adalah:
1. source code (*.java dan *.py / *.ipynb) jangan diZIP
2. link video berisi demo program (gdrive/ github/ youtube atau yg lain)
3. prompt AI dalam file teks (*.txt), jika menggunakan bantuan AI. Sebutkan tools AI yg digunakan.

Prompt yang Saya pakai: 
Fix this code (Java and Python) but keep the interface:
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
    }
    void displayForward() throws InterruptedException {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.println(temp.data);
            Thread.sleep(3000);
            temp = temp.next;
        } while (temp != head);
    }
    void displayBackward() throws InterruptedException {
        if (head == null) return;
        Node temp = head.prev;
        Node stop = temp;
        do {
            System.out.println(temp.data);
            Thread.sleep(3000);
            temp = temp.prev;
        } while (temp != stop);
    }
    void displayAt(int pos) {
        if (head == null) return;
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
    }
}
public class Main {
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
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    String text = sc.nextLine();
                    list.insert(text);
                    break;
                case 2:
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
                    int p = sc.nextInt();
                    list.displayAt(p);
                    break;
            }
        } while (choice != 6);
    }
}

AI yang Saya pakai: Copilot (debugging), Claude (bug fixing)

Link Video (Java): https://youtu.be/ZkYZcU3rkZo
Link Video (Python): https://youtu.be/B2qFTmOX1wQ

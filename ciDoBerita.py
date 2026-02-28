import time 
#Saya sudah coba buat menggunakan fungsi delay sendiri namun ternyata boros CPU sehingga saya memilih menggunakan library

class Node:
    def __init__(self, data):
        self.data = data
        self.next = self
        self.prev = self

class CircularDoublyLinkedList:
    def __init__(self):
        self.head = None

    def insert(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            return
        tail = self.head.prev
        tail.next = new_node
        new_node.prev = tail
        new_node.next = self.head
        self.head.prev = new_node

    def delete(self, pos):
        if self.head is None:
            return
        temp = self.head
        count = 1
        while True:
            if count == pos:
                if temp.next == temp:
                    self.head = None
                    return
                temp.prev.next = temp.next
                temp.next.prev = temp.prev
                if temp == self.head:
                    self.head = temp.next
                return
            temp = temp.next
            count += 1
            if temp == self.head:
                print("Position out of range.")
                return

    def display_forward(self):
        if self.head is None:
            print("List kosong.")
            return
        temp = self.head
        first = True
        while True:
            if not first:
                time.sleep(3)
            print(temp.data)
            first = False
            temp = temp.next
            if temp == self.head:
                break

    def display_backward(self):
        if self.head is None:
            print("List kosong.")
            return
        temp = self.head.prev
        first = True
        while True:
            if not first:
                time.sleep(3)
            print(temp.data)
            first = False
            temp = temp.prev
            if temp == self.head.prev:
                break

    def display_at(self, pos):
        if self.head is None:
            print("List kosong.")
            return
        temp = self.head
        count = 1
        while True:
            if count == pos:
                print(temp.data)
                return
            temp = temp.next
            count += 1
            if temp == self.head:
                print("Position out of range.")
                return

def main():
    lst = CircularDoublyLinkedList()
    while True:
        print("1.Insert berita")
        print("2.Hapus berita")
        print("3.Tampilkan forward")
        print("4.Tampilkan backward")
        print("5.Tampil berita tertentu")
        print("6.Exit")
        print("Pilih menu: ", end="")
        choice = int(input())
        if choice == 1:
            text = input("Masukkan berita: ")
            lst.insert(text)
        elif choice == 2:
            pos = int(input("Masukkan posisi: "))
            lst.delete(pos)
        elif choice == 3:
            lst.display_forward()
        elif choice == 4:
            lst.display_backward()
        elif choice == 5:
            p = int(input("Masukkan posisi: "))
            lst.display_at(p)
        elif choice == 6:
            print("Keluar...")
            break
        else:
            print("Pilihan tidak valid.")

if __name__ == "__main__":
    main()
public class SingleLinkedList {
    class Node {
        int data;
        Node next;

        Node(int dt) {
            this.data = dt;
            this.next = null;
        }
    }

    Node head;

    public static void main(String[] args) {
        SingleLinkedList slist = new SingleLinkedList();

        System.out.println("Insert:");
        slist.insertBeginning(99);
        // 99-->null
        slist.printList();

        slist.insertBeginning(11);
        // 11-->99-->null
        slist.printList();

        slist.insertLast(5);
        // 11-->99-->5-->null
        slist.printList();

        slist.insertLast(15);
        // 11-->99-->5-->15-->null
        slist.printList();

        slist.insertMiddle(29, 2);
        // 11-->99-->29-->5-->15-->null
        slist.printList();

        slist.insertMiddle(82, 1);
        // 11-->82-->99-->29-->5-->15-->null
        slist.printList();

        System.out.println("Delete:");
        slist.deleteBeginning();
        // 82-->99-->29-->5-->15-->null
        slist.printList();

        slist.deleteLast();
        // 82-->99-->29-->5-->null
        slist.printList();

        slist.deleteMiddle(2);
        // 82-->99-->5-->null
        slist.printList();

        System.out.println("Search:");
        slist.search(99);
        slist.search(50);

    }

    // Insert
    // Insert di awal (Beginning)
    public void insertBeginning(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    // Insert di tengah (Middle)
    public void insertMiddle(int newData, int position) {

        if (position == 0) {
            insertBeginning(newData);
        }

        Node newNode = new Node(newData);
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
            if (current == null) {
                System.out.println("indeks tidak tersedia");
                return;
            }
        }
        newNode.next = current.next;
        current.next = newNode;

    }

    // Insert di akhir (Last)
    public void insertLast(int newData) {
        Node newNode = new Node(newData);
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

    // Delete
    // Delete di awal (Beginning)
    public void deleteBeginning() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    // Delete di tengah (Middle)
    public void deleteMiddle(int position) {
        if (position == 0) {
            deleteBeginning();
            return;
        }
        Node previous = head;
        for (int i = 1; i < position; i++) {
            previous = previous.next;
            if (previous == null) {
                System.out.println("indeks tidak tersedia");
                return;
            }
        }
        if (previous.next == null) {
            System.out.println("indeks tidak tersedia");
            return;
        }
        Node current = previous.next;
        previous.next = current.next;

    }

    // Delete di akhir (Last)
    public void deleteLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Print
    public void printList() {
        Node tNode = head;

        while (tNode != null) {
            System.out.print(tNode.data + "-->");
            tNode = tNode.next;
        }
        System.out.println("null\n");
    }

    // Search
    public void search(int key) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data == key) {
                System.out.println(key + " ditemukan pada indeks ke-" + count);
                return;
            }
            count++;
            current = current.next;
        }
        System.out.println(key + " tidak ditemukan");
        return;
    }

}

public class DoublyLinkedList implements LinkedList {
    Node head;
    Node tail;

    public static void main(String[] args) {
        DoublyLinkedList dlist = new DoublyLinkedList();

        System.out.println("Insert:");
        // null
        dlist.printNode();

        dlist.insertHead(69);
        // null<--69-->null
        dlist.printNode();

        dlist.insertHead(70);
        // null<--70<-->69-->null
        dlist.printNode();

        dlist.insertHead(12);
        // null<--12<-->70<-->69-->null
        dlist.printNode();

        dlist.insertEndTest(50);
        // null<--12<-->70<-->69<-->50-->null
        dlist.printNode();

        dlist.insertEnd(32);
        // null<--12<-->70<-->69<-->50<-->32-->null
        dlist.printNode();

        dlist.insertMiddle(20, 1);
        // null<--12<-->20<-->70<-->69<-->50<-->32-->null
        dlist.printNode();

        System.out.println("Delete:");
        dlist.deleteHead();
        // null<--20<-->70<-->69<-->50<-->32-->null
        dlist.printNode();

        dlist.deleteEnd();
        // null<--20<-->70<-->69<-->50-->null
        dlist.printNode();

        dlist.deleteMiddle(2);
        // null<--20<-->70<-->50-->null
        dlist.printNode();

        System.out.println("Search:");
        dlist.search(69);
    }

    // Insert di awal
    @Override
    public void insertHead(int value) {

        Node newNode = new Node(value);

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        } else {
            head = newNode;
            tail = newNode;
        }

    }

    // Insert di tengah
    @Override
    public void insertMiddle(int value, int position) {

        if (position == 0) {
            insertHead(value);
        }

        Node newNode = new Node(value);
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
            if (current == null) {
                System.out.println("indeks tidak tersedia");
                return;
            }
        }
        newNode.next = current.next;
        newNode.prev = current;
        Node current2 = newNode.next;
        current.next = newNode;
        current2.prev = newNode;
    }

    // Insert di akhir
    @Override
    public void insertEndTest(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        tail = newNode;

    }

    @Override
    public void insertEnd(int value) {
        Node newNode = new Node(value);

        if (tail != null) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;

        } else {
            head = newNode;
            tail = newNode;
        }
    }

    // Delete di awal
    @Override
    public void deleteHead() {
        if (head == null) {
            return;
        }
        head = head.next;
        head.prev = null;

    }

    // Delete di tengah
    @Override
    public void deleteMiddle(int position) {
        if (position == 0) {
            deleteHead();
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
        Node current2 = current.next;
        previous.next = current2;
        current2.prev = previous;
        current.next = null;
        current.prev = null;
    }

    // Delete di akhir
    @Override
    public void deleteEnd() {
        if (tail == null) {
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    // Print
    @Override
    public void printNode() {
        Node current = head;

        if (current != null) {
            System.out.print("null<--");
            while (current != null) {
                System.out.print(current.value);
                if (current.next != null) {
                    System.out.print("<-->");
                }
                current = current.next;
            }
            System.out.println("-->null\n");
        } else {
            System.out.println("null\n");
            return;
        }

    }

    // Search
    @Override
    public void search(int key) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.value == key) {
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

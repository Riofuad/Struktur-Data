public class CircularQueue {
    int SIZE = 5; // Size queue
    int front, rear;
    int items[] = new int[SIZE];

    CircularQueue() {
        front = -1;
        rear = -1;
    }

    // Cek Queue Full
    boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    // Cek Queue Empty
    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    // Insert element (enqueue)
    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    // Delete element (dequeue)
    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % SIZE;
            }
            return (element);
        }
    }

    // Print
    void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.println("Items -> ");
            for (i = front; i != rear; i = (i + 1) % SIZE)
                System.out.print(items[i] + " ");
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);
        }
    }

    public static void main(String[] args) {

        CircularQueue c = new CircularQueue();

        // Gagal delete,"Queue is empty"
        c.deQueue();

        c.enQueue(11);
        c.enQueue(70);
        c.enQueue(99);
        c.enQueue(25);
        c.enQueue(32);

        // Gagal enQueue,"Queue is full", karena front == 0 && rear == SIZE - 1
        c.enQueue(87);

        /*
         * Front -> 0 
	 * Items -> 
	 * 11 70 99 25 32 
	 * Rear -> 4
         */
        c.display();

        int elem = c.deQueue();
        if (elem != -1) {
            System.out.println("Deleted Element is " + elem);
        }
        /*
         * Front -> 1 
	 * Items -> 
	 * 70 99 25 32 
	 * Rear -> 4
         */
        c.display();

        c.enQueue(87);

        /*
         * Front -> 1 
	 * Items -> 
	 * 70 99 25 32 87 
	 * Rear -> 0
         */
        c.display();

        // Gagal enQueue, "Queue is full" karena front == rear + 1
        c.enQueue(8);
    }

}

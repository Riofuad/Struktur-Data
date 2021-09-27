import java.util.ArrayList;

public class PriorityQueue {
    // Heapify the tree
    void heapify(ArrayList<Integer> hT, int i) {
        int size = hT.size();
        // Mencari yang terbesar dari root, leftChild atau rightChild
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && hT.get(l) > hT.get(largest))
            largest = l;
        if (r < size && hT.get(r) > hT.get(largest))
            largest = r;

        // Tukar dan lanjutkan heapify jika root bukan yang terbesar
        if (largest != i) {
            int temp = hT.get(largest);
            hT.set(largest, hT.get(i)); // hT.set(index, element)
            hT.set(i, temp);

            heapify(hT, largest);
        }
    }

    // Insert element into the tree
    void insert(ArrayList<Integer> hT, int newNum) {
        int size = hT.size();
        if (size == 0) {
            hT.add(newNum);
        } else {
            hT.add(newNum);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(hT, i);
            }
        }
    }

    // Delete element from the tree
    void deleteNode(ArrayList<Integer> hT, int num) {
        int size = hT.size();
        int i;
        if (size == 0) {
            System.out.println("Empty tree");
        } else {
            for (i = 0; i < size; i++) {
                if (num == hT.get(i))
                    break;
            }
            try {
                int temp = hT.get(i);
                hT.set(i, hT.get(size - 1));
                hT.set(size - 1, temp);

                hT.remove(size - 1);
                for (int j = size / 2 - 1; j >= 0; j--) {
                    heapify(hT, j);
                }
            } catch (Exception e) {
                System.out.println("Cant deleted unregisted number");
            }
        }
    }

    // Print the tree
    void printArray(ArrayList<Integer> array) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {

        ArrayList<Integer> array = new ArrayList<Integer>();

        PriorityQueue p = new PriorityQueue();

        // Failed delete, "Empty tree",karena size == 0
        p.deleteNode(array, 5);

        p.insert(array, 5);
        p.insert(array, 4);
        p.insert(array, 9);
        p.insert(array, 1);
        p.insert(array, 3);
        p.insert(array, 2);

        System.out.println("Max-Heap before add 7");
        // 9 4 5 1 3 2
        p.printArray(array);

        p.insert(array, 7);
        System.out.println("Max-Heap array: ");
        // 9 4 7 1 3 2 5
        p.printArray(array);

        p.deleteNode(array, 4);
        System.out.println("After deleting an element: ");
        // 9 5 7 1 3 2
        p.printArray(array);

        // Failde delete,"Cant delete unregisted number", karena hT.get(size)
        p.deleteNode(array, 11);
    }
}

import java.util.List;
import java.util.Scanner;
class DynamicArray{
    private static final int initialCapacity  =16;
    private int arr[], size,cap;

    DynamicArray(){
        size = 0;
        arr = new int[initialCapacity];
        cap = initialCapacity;
    }

   void add(int val){
        if(size==cap){
            System.out.println("Memory full so i expand the memory");
            expandArray();

        }
       arr[size++] = val;
    }
    private void expandArray(){
        cap *=2;
        arr = java.util.Arrays.copyOf(arr, cap);
    }
    void display() {
        if (size == 0) {
            System.out.println("The array is empty.");
            return;
        }
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // New line after displaying all elements
    }
    void insertAtPos(int pos, int val) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position.");
            return;
        }
        if (size == cap) {
            expandArray();
        }
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = val;
        size++;
    }
    void deleteAtPos(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position.");
            return;
        }
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        if (cap > initialCapacity && cap > 3 * size) {
            shrinkArray();
        }
    }
    void shrinkArray() {
        cap /= 2;
        arr = java.util.Arrays.copyOf(arr, cap);
    }


}


public class Main {
    public static void main(String[] args) {
        DynamicArray Array = new DynamicArray();
        Scanner scan = new Scanner(System.in);
        int val, pos, res;

        while (true) {
            System.out.println("Dynamic Array use this number for using this Array");
            System.out.println("Enter 1 for add a value on Last index");
            System.out.println("Enter 2 for add a value on Specific index");
            System.out.println("Enter 3 for display all value on the List");
            System.out.println("Enter 4 for delete the value from specific position");
            System.out.println("Enter 5 for Exit \n\n");

            int opt = scan.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Enter the value: ");
                    val = scan.nextInt();
                    Array.add(val);
                    break;

                case 2:
                    System.out.println("Enter your position");
                    pos = scan.nextInt();
                    val = scan.nextInt();
                    if(pos<0){
                        System.out.println("Invalid Values");
                        break;
                    }
                    Array.insertAtPos(pos, val);
                    break;

                case 3:
                    System.out.println("These are the all values where in list");
                    Array.display();
                    break;

                case 4:
                    System.out.println("Enter the values for which index of element where you delete");
                    pos = scan.nextInt();
                    if(pos<0){
                        System.out.println("Invalid Number");
                    }
                    Array.deleteAtPos(pos);
                    break;

                case 5:
                    System.exit(0);
                    System.out.println("Thank You");
                    break;

                default: System.out.println("Invalid key");


            }
        }


    }
}

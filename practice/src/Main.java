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

    void deleteAtEnd(){
        if(size==0){
            System.out.println("Array is empty");
        }
        size--;
        System.out.println("Deleted the last element of Array");
    }
    void deleteAtBeginning(){
        if(size==0){
            System.out.println("Array is empty");
        }
        for(int i=0;i<size-1;i++){
            arr[i] = arr[i+1];
        }
        size--;
        System.out.println("deleted");
    }
    void insertAtBeginning(int val){
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = val;
        size++;
    }
    void clear(){
        for(int i =size-1;i>=0;i--){
            size--;
        }
        System.out.println("Clear the all of the values on array");
    }

}

public class Main {
    public static void main(String[] args) {
        DynamicArray Array = new DynamicArray();
        Scanner scan = new Scanner(System.in);
        int val, pos;
        while (true) {
            System.out.println("\n\nDynamic Array use this number for using this Array");
            System.out.println("Enter 1 for add a value on Last index");
            System.out.println("Enter 2 for add a value on Specific index");
            System.out.println("Enter 3 for display all value on the List");
            System.out.println("Enter 4 for delete the value from specific position");
            System.out.println("Enter 5 for Exit");
            System.out.println("Enter 6 for delete the value from least index");
            System.out.println("Enter 7 for delete at beginning");
            System.out.println("Enter 8 for insert at beginning");
            System.out.println("Enter 9 for clear all elements");

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

                case 0:
                    System.exit(0);
                    System.out.println("Thank You");
                    break;

                case 6:
                    Array.deleteAtEnd();
                    break;

                case 7:
                    Array.deleteAtBeginning();
                    break;

                case 8:
                    val = scan.nextInt();
                    Array.insertAtBeginning(val);
                    break;

                case 9:
                    Array.clear();
                    break;

                default: System.out.println("Invalid key");
            }
        }


    }
}

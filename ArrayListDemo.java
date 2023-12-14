/* Re implementation of ArrayList
 * @author Bijay
 */
package arraylist;

class ArrayList<T> {
    // Default initial size of list is 10
    Object list[] = new Object[10];
    private int dataSize = 0;
    private int capacity = 10;

    public void add(T data) {
        if (dataSize < capacity) {
        } else {
            grow();
        }
        list[dataSize] = data;
        dataSize++;
    }

    // Remove by index
    public void remove(int i) {
        if (i < 0 || i >= dataSize) {
            System.out.println("Cannot remove: Invalid index");
            return;
        }
        int j;
        // Shift the elements to left by one position
        for (j = i; j < dataSize; j++) {
            list[j] = list[j + 1];
        }
        dataSize--;
        if (dataSize <= (int) capacity / 2) {
            shrink();
        }
    }

    // Remove by item
    public void remove(T item) {
        int i;
        for (i = 0; i < dataSize; i++) {
            if (list[i] == item) {
                int j;
                // Shift the elements to left by one position
                for (j = i; j < dataSize; j++) {
                    list[j] = list[j + 1];
                }
                dataSize--;
            }
        }
        if (dataSize <= (int) capacity / 2) {
            shrink();
        }
    }

    private void grow() {
        // Extend the capacity size by 20% of the current capacity
        int newCapacity = (int) (capacity * 1.2);
        capacity = newCapacity;
        Object newList[] = new Object[newCapacity];
        System.arraycopy(list, 0, newList, 0, list.length);
        list = newList;
    }

    private void shrink() {
        // Shrink the capacity size by 40% of the current capacity
        int newCapacity = (int) (capacity * .6);
        capacity = newCapacity;
        Object newList[] = new Object[newCapacity];
        System.arraycopy(list, 0, newList, 0, dataSize);
        list = newList;
    }

    public void printAll() {
        for (int i = 0; i < dataSize; i++) {
            System.out.println(list[i]);
        }
    }

    public T get(int index) {
        if (index < 0 || index >= dataSize) {
            throw new IndexOutOfBoundsException();
        }
        return (T) list[index];
    }

    public boolean isEmpty() {
        if (dataSize == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return dataSize;
    }

    public void clear() {
        dataSize = 0;
    }
}

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            al.add(i);
        }
        for (int i = 5; i < 99; i++) {
            al.remove(Integer.valueOf(i));
        }
        al.clear();
        al.printAll();
        // al.printAll();
        // ArrayList<Character> al2 = new ArrayList<Character>();
        // al2.add('b');
        // al2.add('i');
        // al2.add('j');
        // al2.remove(Character.valueOf('b'));
        // al2.printAll();
        // System.out.println(al2.get(2));

        // ArrayList<String> myAlist = new ArrayList<String>();
        // myAlist.add("Geeks");
        // myAlist.add("Practice");
        // myAlist.add("Quiz");
        // System.out.println("Original ArrayList : ");
        // myAlist.printAll();
        // myAlist.remove("Practice");
        // System.out.println("Modified ArrayList : ");
        // myAlist.printAll();
        // al2.printAll();
    }
}
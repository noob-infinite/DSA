package Lab03.pack;

import java.util.Arrays;

public class MyArray extends MyArrayBasic{ 
    public MyArray(int capacity) {
        MAX_SIZE = capacity > 0 ? capacity : 1;
        data = new int[MAX_SIZE];
    }
    public MyArray() {
        MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
    }
    @Override
    public int add(int d) {
        if (isFull())
            expandByK();
        data[size++] = d;
        return size;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void expandByK() {
        expandByK(2);
    }
    private void expandByK(int k) {
        MAX_SIZE = k * MAX_SIZE;
        int [] tmp = new int[MAX_SIZE];
        // for (int i = 0; i < data.length; i++)
        //     tmp[i] = data[i];
        System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
        // System.out.println("expand array " + tmp.length + "-->" + Arrays.toString(tmp));
    }
    @Override
    public void delete(int index) {
        if (isEmpty())
           return;
        super.delete(index);
    }   
    @Override
    public void insert_unordered(int index, int d) {
        if (isFull())
            expandByK();
        if (size == 0) {
            data[0] = d;
            size++;
            return;
        }
        int left = index == 0 ? Integer.MIN_VALUE : data[index - 1];
        if ((index == 0 && data[0] > d) || (left < d && data[index] > d)) {
            for (int i = size; i > index; i--) {
                data[i] = data[i-1];
            }
            data[index] = d;
            size++;
        }
    }
    public void insert(int d) {
        if (isFull())
            expandByK();
        if (size == 0) {
            data[0] = d;
            size++;
            return;
        }
        int idx = 0;
        while (idx < size && data[idx] < d) {
            idx++;
        }
        
        for (int i = size; i > idx; i--)
            data[i] = data[i-1];
        data[idx] = d;
        size++;
    }
    public int binarySearch(int d) {
        int a = 0, b = size - 1;
        int m;
        while (a<=b) {
            m = (a + b) / 2;
            if (data[m] == d) return m;
            if (d < data[m]) b = m - 1;
            else a = m + 1; // d > data[m]
        }
        return -(a + 1);
    }

}

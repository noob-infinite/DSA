package Lab03.pack;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    public MyArrayBasic() {
    }
    public MyArrayBasic(int ... a) {
        if (a == null) return;
        int firstN = a.length > MAX_SIZE ? MAX_SIZE : a.length;
        for (int idx = 0; idx < firstN; idx++) {
            data[idx] = a[idx];
            size++;
        }      
    }

    public int find(int d) {
        for (int i = 0; i < size; i++) 
            if (data[i] == d) 
                return i;
        return -1;
    }

    public void insert_unordered(int d, int index) {
        for (int i = size; i > index; i--)
            data[i] = data[i-1];
        data[index] = d;
        size++;
    }

    public int add(int d) {
        data[size++] = d;
        return size;
    }

    public void delete(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1]; //shift left
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size - 1; i++)
            sb.append(data[i]+", ");
        if (size > 0) sb.append(data[size-1]);
        sb.append("]");
        return sb.toString();
    }

    public int getAt(int idx) {
        return data[idx];
    }

    public void setAt(int d, int idx) {
        data[idx] = d;
    }
}

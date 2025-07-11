package Lab01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import Lab01.pack.Breed;
import Lab01.pack.Dog;

public class Lab01_XXYYYY_Sol {
    public static void main(String[] args) {
        // task1();
        // task2();
        // task3();
        // task4();
        // task5();
        // task6();
        task7();
    }
    static void task1() {
        // Given 2 arraylist of same type, Create an arraylist named q1List which contains all elements
        // from both source lists
        System.out.println("-task1----");
        List<String> lisA = new ArrayList<>(Arrays.asList("Lilly","Tulip"));
        List<String> lisB = Arrays.asList("Tulip", "Daisy");
        List<String> lisC;
        // your code begin
        lisC = new ArrayList<>();
        lisC.addAll(lisA);  
        lisC.addAll(lisB);  
        // your code end  
        System.out.println(lisA); // [Lilly, Tulip]
        System.out.println(lisB); // [Tulip, Daisy]
        System.out.println(lisC); // [Lilly, Tulip, Tulip, Daisy]
    }
    static void task2() {
        // shallow copy matter
        System.out.println("-task2----");
        ArrayList<StringBuilder> lis2a = new ArrayList<>(Arrays.asList(new StringBuilder("Lily"), new StringBuilder("Daisy")));
        ArrayList<StringBuilder> lis2b = new ArrayList<>(lis2a);
        lis2b.add(new StringBuilder("30"));
        StringBuilder sb = lis2a.get(0);
        sb.append("mySuffix");
        // pick your answer what would be the below result
        if (lis2b.get(0).equals(sb)) {
            System.out.println("lis2b[0] also becomes " + sb);
        } else {
            System.out.println("copy constructor creates a new copy of lis2a[0] for lis2b");
        }
    }
    static void task3() {
        System.out.println("-task3----");
        List<String> lis3 = Arrays.asList("Lily","Daisy","Tulip","Daisy");
        // your code begin
        List<String> tmp = Arrays.asList(lis3.get(0));
        lis3 = tmp;
        // your code end
        System.out.println(lis3);   // [Lily]
    }
    static void task4() { // set element is unique (class Dog and enum Breed)
        System.out.println("-task4----");
        List<String> lis4a = Arrays.asList("Lily", "Daisy", "Tulip", "Daisy");
        HashSet<String> flowers = new HashSet<>(lis4a);
        for (var ele: flowers)
            System.out.print(ele + " ");
        System.out.println(); // Tulip Daisy Lily

        List<Dog> lis4b = Arrays.asList(new Dog(Breed.pomeranian,1200),
                                new Dog(Breed.beagle, 2300), new Dog(Breed.jack,1440),
                                new Dog(Breed.beagle, 2300)
                            );
        HashSet<Dog> dogs = new HashSet<>(lis4b);
        for (var ele : dogs)
            System.out.print(ele + " ");
        System.out.println(); // Dog(beagle, 2300) Dog(jack, 1440) Dog(pomeranian, 1200) 
    }
    static void task5() { // number of unique element
        System.out.println("-task5----");
        List<Dog> lis5a = Arrays.asList(new Dog(Breed.pomeranian,1200),
                                new Dog(Breed.beagle, 2300), new Dog(Breed.jack,1440),
                                new Dog(Breed.beagle, 2300)
                            );
        System.out.println( new HashSet<>(lis5a).size() ); // 3
    }
    static void task6() { // count same elements
        System.out.println("-task6----");
        List<Dog> lis6a = Arrays.asList(new Dog(Breed.pomeranian,1200),
                                new Dog(Breed.beagle, 2300), new Dog(Breed.jack,1440),
                                new Dog(Breed.beagle, 2300)
                            );
        HashMap<Breed,Integer> map = new HashMap<>();
        // your code begin
        /* for (Dog d : lis6a) {
            //  map.compute(d.myBreed(), (k, v) -> v == null ? 1 : v + 1);
         */
        for (Dog d : lis6a) { 
            map.putIfAbsent(d.myBreed(), 0);
            int cnt = map.get(d.myBreed());
            map.put(d.myBreed(),cnt+1);
        }
        // your code end
        for (Entry<Breed, Integer> ele : map.entrySet()) {
          System.out.println(ele.getKey() + "\t" + ele.getValue());   
        } //pomeranian 1    beable 2    jack 1
    }
    static void task7() { // access time
        int N = 10_000;
        ArrayList<Integer> lis = new ArrayList<>();
        Integer [] arr = new Integer[N];
        LinkedList<Integer> llis;

        for (int i = 0; i < N; i++) {
            lis.add(i+1);
        }
        Collections.shuffle(lis);
        lis.toArray(arr);
        llis = new LinkedList<>(lis);

        task7_timer(arr, lis, llis);
    }
static void task7_timer(Integer [] arr, ArrayList<Integer> lis, LinkedList<Integer> llis) {
    int factor = 10;
    int num_iter = 100_000 * factor; // in case your CPU is too powerful
    int [] index = {0, (arr.length/4), (arr.length/2), (3*arr.length/4)};
    long start, stop = System.nanoTime();
    int pos = 0,x;
    for (int i = 0; i < index.length; i++) {
        pos = index[i];
        start = System.nanoTime();
        for (int j = 0; j < num_iter; j++) 
            x = arr[pos];
        stop = System.nanoTime();
        System.out.printf("Array accessing at %d takes %s\n",pos,String.format("%,d",(stop-start)));
        start = System.nanoTime();
        for (int j = 0; j < num_iter; j++) 
            x = lis.get(pos);
        stop = System.nanoTime();
        System.out.printf("ArrayList accessing at %d takes %s\n",pos,String.format("%,d",(stop-start)));
        start = System.nanoTime();
        for (int j = 0; j < num_iter; j++) 
            x = llis.get(pos);
        stop = System.nanoTime();
        System.out.printf("LinkedList accessing at %d takes %s\n",pos,String.format("%,d",(stop-start)));
        System.out.println("-----------------");
    }
}
}

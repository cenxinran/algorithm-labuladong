package main.java.com.cenran.rumen_003_hashmap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @className: Test
 * @author: Docer
 * @date: 2024/10/16 0:09
 * @Version: 1.0
 * @description: 不建议使用可变对象（比如ArrayList）作为 HashMap 的键的原因
 */
public class Test {
    public static void main(String[] args) {
        HashMap<ArrayList<Integer>, Integer> hashMap = new HashMap<ArrayList<Integer>, Integer>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);

        hashMap.put(arrayList, 999);
        System.out.println(hashMap.containsKey(arrayList));
        System.out.println(hashMap.get(arrayList));
        System.out.println("--------");

        arrayList.add(3);
        System.out.println(hashMap.containsKey(arrayList));
        System.out.println(hashMap.get(arrayList));

        arrayList.remove(2);
        System.out.println("--------");
        System.out.println(hashMap.containsKey(arrayList));
        System.out.println(hashMap.get(arrayList));
    }
}

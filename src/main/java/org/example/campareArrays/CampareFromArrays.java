package org.example.campareArrays;

import java.util.Arrays;

//
//Напишите обобщенный метод compareArrays(), который принимает два массива и
//        возвращает true, если они одинаковые, и false в противном случае. Массивы могут быть
//        любого типа данных, но должны иметь одинаковую длину и содержать элементы одного
//        типа.
public class CampareFromArrays {
    public static <T> boolean compareArrays(T[] firstArray, T[] secondArray) {
        if (firstArray.length != secondArray.length) {
            return false;
        }
        for (int i = 0; i < firstArray.length; i++) {
            if (!firstArray[i].equals(secondArray[i])) {
                return false;
            }
        }
        return true;
    }
}

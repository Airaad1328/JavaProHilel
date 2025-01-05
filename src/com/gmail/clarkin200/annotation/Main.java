package com.gmail.clarkin200.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        MethodInfo methodMergeInfo = ArrayUtils.class.getDeclaredMethod("mergeSort", int[].class).getAnnotation(MethodInfo.class);
        Author mergeAuthor = ArrayUtils.class.getDeclaredMethod("mergeSort", int[].class).getAnnotation(Author.class);

        MethodInfo methodBinaryInfo = ArrayUtils.class.getDeclaredMethod("binarySearch", int[].class, int.class).getAnnotation(MethodInfo.class);
        Author binaryAuthor = ArrayUtils.class.getDeclaredMethod("binarySearch", int[].class, int.class).getAnnotation(Author.class);

        System.out.println("Information about mergeSort from MethodInfo annotation");
        System.out.println("Method name: " + methodMergeInfo.name());
        System.out.println("Return value: " + methodMergeInfo.returnValue());
        System.out.println("Description: " + methodMergeInfo.description());
        System.out.println();
        System.out.println("Information about mergeSort from Author annotation");
        System.out.println("Author name: " + mergeAuthor.name());
        System.out.println("Author surname: " + mergeAuthor.surname());
        System.out.println();

        System.out.println("Information about binarySearch from MethodInfo annotation");
        System.out.println("Method name: " + methodBinaryInfo.name());
        System.out.println("Return value: " + methodBinaryInfo.returnValue());
        System.out.println("Description: " + methodBinaryInfo.description());
        System.out.println();
        System.out.println("Information about binarySearch from Author annotation");
        System.out.println("Author name: " + binaryAuthor.name());
        System.out.println("Author surname: " + binaryAuthor.surname());

        Class<?> exampleClass = Class.forName("com.gmail.clarkin200.annotation.ArrayUtils");
        int[] arrToSort = {5, 2, 12, 42, 5, 1};

        Object obj = exampleClass.getDeclaredConstructor().newInstance();
        Method mergeMethod = exampleClass.getDeclaredMethod("mergeSort", int[].class);
        int[] resultArray = (int[]) mergeMethod.invoke(obj, arrToSort);

        System.out.println();
        System.out.println("Call method mergeSort by reflexion");
        System.out.println(Arrays.toString(resultArray));

        Method binarySearch = exampleClass.getDeclaredMethod("binarySearch", int[].class, int.class);
        int resultBinary = (int) binarySearch.invoke(obj, resultArray, 12);

        System.out.println("Call method binarySearch by reflexion");
        System.out.println("Binary search result : " + resultBinary);


    }
}

package com.musala;

import com.sun.tools.javac.util.Assert;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class WeakHashMapExample {

    public static void main(String[] args) {

        final WeakHashMap<UniqueImageName, BigImage> map = new WeakHashMap<>();
        final BigImage bigImage = new BigImage("image_id");
        UniqueImageName imageName = new UniqueImageName("name_of_big_image");

        map.put(imageName, bigImage);
        System.out.println("key exists: " + map.containsKey(imageName));

        imageName = null;
        System.gc();

        System.out.println("key exists: " + map.containsKey(imageName));
    }
}

class UniqueImageName {

    private String name;

    public UniqueImageName(String name) {
        this.name = name;
    }
}

class BigImage {

    private String id;

    public BigImage(String id) {
        this.id = id;
    }
}
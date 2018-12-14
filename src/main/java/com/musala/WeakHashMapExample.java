package com.musala;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class WeakHashMapExample {

    public static void main(String[] args) {

        final WeakHashMap<UniqueImageName, BigImage> map = new WeakHashMap<>();
        final BigImage bigImage = new BigImage("image_id");
        UniqueImageName imageName = new UniqueImageName("name_of_big_image");

        map.put(imageName, bigImage);
        System.out.println("key exists: " + map.containsKey(imageName));

        imageName = null;
        System.gc();

        await().atMost(10, TimeUnit.SECONDS).until(map::isEmpty);

        if (map.isEmpty()) {
            System.out.println("Map was emptied.");
        }
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
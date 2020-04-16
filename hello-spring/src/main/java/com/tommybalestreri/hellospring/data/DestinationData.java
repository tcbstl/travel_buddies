//package com.tommybalestreri.hellospring.data;
//
//import com.tommybalestreri.hellospring.models.Destination;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//public class DestinationData {
//
//    private static final Map<Integer, Destination> destinations = new HashMap<>();
//
//    public static Collection<Destination> getAll(){
//        return destinations.values();
//    }
//
//    public static Destination getById(int id){
//        return destinations.get(id);
//    }
//
//    public static void add(Destination destination) {
//        destinations.put(destination.getId(), destination);
//    }
//
//    public static void remove(int id){
//        destinations.remove(id);
//    }
//}

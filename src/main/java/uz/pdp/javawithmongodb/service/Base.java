package uz.pdp.javawithmongodb.service;

public interface Base<T> {

    T create(T t);
    T get(String id);
    T update(T t);
    boolean delete(String id);
}

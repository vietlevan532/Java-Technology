package DAO;

import POJO.Phone;

import java.util.List;

public interface iDAO<T, K> {

    K add(T t);

    T get(K k);

    List<T> getAll();

    boolean removeById(K k);

    boolean remove(T t);

    boolean update(T t);

}

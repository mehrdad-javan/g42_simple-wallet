package se.lexicon.dao;

import se.lexicon.exception.DataNotFoundException;

import java.util.Collection;
import java.util.Optional;

public interface BaseDao<T, ID> {

  T create(T t);

  Optional<T> findById(ID id);

  Collection<T> findAll();

  void remove(ID id) throws DataNotFoundException;
}

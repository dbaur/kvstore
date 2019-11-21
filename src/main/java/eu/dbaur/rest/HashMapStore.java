package eu.dbaur.rest;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapStore implements Store {

  private static final Map<String, String> STORE = new ConcurrentHashMap<>();


  @Override
  public Map<String, String> getAll() {
    return ImmutableMap.copyOf(STORE);
  }

  @Override
  public void put(String key, String value) {
    STORE.put(key, value);
  }

  @Override
  public String get(String key) {
    return STORE.get(key);
  }
}

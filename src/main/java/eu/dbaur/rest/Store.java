package eu.dbaur.rest;

import java.util.Map;

public interface Store {

  Map<String, String> getAll();

  void put(String key, String value);

  String get(String key);


}

package eu.dbaur.rest;

import com.google.common.base.Strings;
import java.util.Map;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("kv")
public class KVStore {

  private final Store store = new HashMapStore();

  public KVStore() {
    store.put("test", "test");
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, String> getAll() {
    return store.getAll();
  }

  @GET
  @Path("/{key}")
  @Produces(MediaType.APPLICATION_JSON)
  public String get(@PathParam("key") String key) {

    if (Strings.isNullOrEmpty(key)) {
      throw new BadRequestException("key is null or empty");
    }

    final String value = store.get(key);

    if (value == null) {
      throw new NotFoundException("no value present");
    }

    return value;
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{key}")
  public String put(@PathParam("key") String key, String value) {

    if (Strings.isNullOrEmpty(key)) {
      throw new BadRequestException("key is null or empty");
    }

    if (Strings.isNullOrEmpty(value)) {
      throw new BadRequestException("value is null or empty");
    }

    store.put(key, value);
    return get(key);
  }

}

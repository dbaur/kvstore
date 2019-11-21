package eu.dbaur.rest;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Main class.
 */
public class Main {

  // Base URI the Grizzly HTTP server will listen on
  public static final String BASE_URI = "http://localhost:8080/";

  /**
   * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
   *
   * @return Grizzly HTTP server.
   */
  public static HttpServer startServer() {
    // create a resource config that scans for JAX-RS resources and providers
    // in eu.dbaur.rest package
    final ResourceConfig rc = new ResourceConfig().packages("eu.dbaur.rest");

    // create and start a new instance of grizzly http server
    // exposing the Jersey application at BASE_URI
    return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
  }

  /**
   * Main method.
   */
  public static void main(String[] args) throws IOException {
    final HttpServer server = startServer();

    Runtime.getRuntime().addShutdownHook(new Thread(
        server::shutdown
    ));

    System.out.println(String.format("Jersey app started with WADL available at "
        + "%sapplication.wadl", BASE_URI));
  }
}


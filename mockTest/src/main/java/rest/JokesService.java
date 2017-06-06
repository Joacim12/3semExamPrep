package rest;

import com.google.gson.Gson;
import exercise.CommunicationException;
import exercise.Fetcher;
import exercise.Joke;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Joacim
 */
@Path("jokes")
public class JokesService {

    @Context
    private UriInfo context;
    Gson gson = new Gson();

    /**
     * Creates a new instance of JokesService
     */
    public JokesService() {
    }

    /**
     * Retrieves representation of an instance of rest.JokesService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getourstolenjoke")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws CommunicationException {
        Fetcher f = new Fetcher("email");
        Joke j = f.fetchJoke("http://api.icndb.com");
        return gson.toJson(j);
    }

    /**
     * PUT method for updating or creating an instance of JokesService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}

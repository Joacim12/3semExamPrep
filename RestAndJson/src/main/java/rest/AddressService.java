package rest;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.DataGenerator;

/**
 * REST Web Service
 *
 * @author joacim
 */
@Path("addresses")
public class AddressService {

    @Context
    private UriInfo context;
    Gson gson;
    DataGenerator dg;

    /**
     * Creates a new instance of AddressService
     */
    public AddressService() {
        dg = new DataGenerator();
        gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of rest.AddressService
     *
     * @param amount
     * @param data
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{amount}/{data}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("amount") int amount, @PathParam("data") String data) {
        return gson.toJson(dg.getData(amount, data));
    }
}

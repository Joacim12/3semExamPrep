package rest;

import com.google.gson.Gson;
import entity.City;
import entity.Country;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import jsonMappers.CityJson;
import jsonMappers.CountryJson;
import worldFacade.WorldFacade;

/**
 * REST Web Service
 *
 * @author joaci
 */
@Path("world")
public class WorldService {

    @Context
    private UriInfo context;
    Gson gson = new Gson();
    WorldFacade wf = new WorldFacade("PU");

    /**
     * Creates a new instance of WorldService
     */
    public WorldService() {
    }

    /**
     * Retrieves representation of an instance of rest.WorldService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCountries() {
        List<CountryJson> cJson = new ArrayList();
        for (Object[] country : wf.getCountries()) {
            String code = (String) country[0];
            String name = (String) country[1];
            String continent = (String) country[2];
            String capital = (String) country[3];
            cJson.add(new CountryJson(code, name, continent, capital));
        }
        return gson.toJson(cJson);
    }
    
    @GET
    @Path("/country/{country}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountry(@PathParam("country") String country){
        Country co = wf.getCountry(country);
        CountryJson c = new CountryJson(co.getCode(),co.getName(),co.getContinent(),co.getCapital().getName());
        return gson.toJson(c);
    }

    @GET
    @Path("{greater}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCountriesGreaterThan(@PathParam("greater") int greater) {
        List<CountryJson> cJson = new ArrayList();
        for (Object[] country : wf.getCountriesPopGreather(greater)) {
            String code = (String) country[0];
            String name = (String) country[1];
            String continent = (String) country[2];
            String capital = (String) country[3];
            cJson.add(new CountryJson(code, name, continent, capital));
        }
        return gson.toJson(cJson);
    }

    @GET
    @Path("/city/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCitiesInCountry(@PathParam("code") String code) {
        List<CityJson> cJson = new ArrayList();
        for (Object[] city : wf.getCitiesInCountry(code)) {
            String name = (String) city[0];
            int population = (Integer) city[1];
            cJson.add(new CityJson(name, population));
        }
        return gson.toJson(cJson);
    }

    /**
     * POST method for updating or creating an instance of WorldService
     *
     * @param code what country do you wanna update??
     * @param content representation for the resource
     * @return succes
     */
    @POST
    @Path("post/{code}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(@PathParam("code")String code,String content) {
        Country country = wf.getCountry(code);
        City c = gson.fromJson(content, City.class);
        c.setCountryCode(country);
        country.addCity(c);
        return "{\"Succes\":\"true\"}";
    }
}

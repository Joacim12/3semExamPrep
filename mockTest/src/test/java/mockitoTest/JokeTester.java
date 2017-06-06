package mockitoTest;


import exercise.CommunicationException;
import exercise.Fetcher;
import exercise.Joke;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Joacim
 */
public class JokeTester {
    private static Fetcher f;

    public JokeTester() {

    }

    @BeforeClass
    public static void setUpClass() {
        f = mock(Fetcher.class);
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public  void testGetJoke() throws CommunicationException {
        System.out.println("Testing getting joke");
        when(f.fetchJoke("http://api.icndb.com")).thenReturn(new Joke("Bad Joke","by Joacim"));
        Joke joke = f.fetchJoke("http://api.icndb.com");
        assertTrue(joke.getJoke().equals("Bad Joke"));
    }
    
    @Test(expected = CommunicationException.class)
    public void testException() throws CommunicationException{
        System.out.println("Testing exception");
        when(f.fetchJoke("BADURL")).thenThrow(CommunicationException.class);
        f.fetchJoke("BADURL");
    }
    
//     @Test
//    public void testRest() {
//        given()
//                .contentType("application/json")
//                .when()
//                .get("/api/jokes/getourstolenjoke").then()
//                .statusCode(200);
//    }
    
}

import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class PaidEventsTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void paidevents_instantiatesCorrectly_true() {
    Events testEvents = new Event("Google", "Silicon Valley", "IOT", "8000", 1);
    assertEquals(true, testEvents instanceof Events);
  }

  @Test
  public void getEventsName_paideventsInstantiatesWithEventsName_Google() {
    Events testEvents = events1;
    assertEquals("Google", testEvents.getEventsName());
  }

}
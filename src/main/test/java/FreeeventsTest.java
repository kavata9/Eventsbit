import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.events.Event;

public class FreeeventsTest {

  @Test
  public void event_instantiatesCorrectly_true() {
    Event testEvent = new Event("Nairobi DG meetup");
    assertEquals(true, testEvent instanceof Event);
  }

  @Test
  public void getName_eventInstantiatesWithName_Nairobi DG meetup() {
    Event testEvent = new Event("Nairobi DG meetup", "iHub","Techprenuer");
    assertEquals("Nairobi DG meetup", testPerson.getName());
  }

  @Test
  public void getLocation_eventInstantiatesWithLocation_String() {
    Event testEvent = new Event("Nairobi DG meetup", "iHub","Techprenuer");
    assertEquals("iHub", testEvent.getLocation());
  }

  @Test
  public void getDescription_eventInstantiatesWithDescription_String() {
    Event testEvent = new Event("Nairobi DG meetup", "iHub","Techprenuer");
    assertEquals("Techprenuer", testEvent.getDescription());
  }

}
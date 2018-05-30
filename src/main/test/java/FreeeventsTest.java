import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.events.Event;

public class FreeeventsTest {

  @Test
  public void event_instantiatesCorrectly_true() {
    Event testEvent = new Event("Nairobi DG meetup");
    assertEquals(true, testEvent instanceof Event);
  }

}
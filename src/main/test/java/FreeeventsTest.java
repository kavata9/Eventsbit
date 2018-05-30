import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class FreeeventsTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

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

  @Test
  public void equals_returnsTrueIfNameAreSame_true() {
    Event testEvent = event1;
    Event anotherEvent = event1;
    assertTrue(testEvent.equals(anotherEvent));
  }

  @Test
  public void save_assignsIdToFreeEvent() {
    Event testEvent = event1;
    testEvent.save();
    Event savedEvent = Event.all().get(0);
    assertEquals(savedEvent.getId(), testEvent.getId());
  }

  @Test
  public void all_returnsAllInstancesOfFreeEvent_true() {
    Event firstEvent = event1;
    firstEvent.save();
    Event secondEvent = event2;
    secondEvent.save();
    assertEquals(true, Event.all().get(0).equals(firstEvent));
    assertEquals(true, Event.all().get(1).equals(secondEvent));
  }



}
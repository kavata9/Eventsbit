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

  @Test
  public void getLocation_paideventsInstantiatesWithLocation_Sillicon_valley() {
    Events testEvents = events1;
    assertEquals("Sillicon_valley", testEvents.getLocation());
  }

  @Test
  public void getFreeEventsId_paideventsnInstantiatesWithFreeEventsId_1() {
    Events testEvents = events1;
    assertEquals(1, testEvents.getFreeEventsId());
  }

  @Test
  public void equals_returnsTrueIfNameAndLocationAreSame_true() {
    Events testEvents = events1;
    Events anotherEvents = events1;
    assertTrue(testEvents.equals(anotherEvents));
  }

  @Test
  public void save_insertsObjectIntoDatabase_PaidEvents() {
    Events testEvents = events1;
    testEvents.save();
    assertEquals(true, PaidEvents.all().get(0).equals(testEvents));
  }
  @Test
  public void save_assignsIdToPaidEvents() {
    Events testEvents = new Events("Google", "Silicon Valley", "IOT", "8000", 1
    testEvents.save();
    Events saveEvents = Events.all().get(0);
    assertEquals(savedEvents.getId(), testEvents.getId());
  }


}
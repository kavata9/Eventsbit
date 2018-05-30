public class PaidEvents {
    private String eventsname;
    private String location;
    private int freeeventsid;
    // private Timestamp timestamp;
    private int charges;
    private int id;
  
    public PaidEvents(String eventsname, String location, int freeeventsid, int charges) {
      this.eventsname = eventsname;
      this.location = location;
      this.freeeventsid = freeeventsid;
      this.charges = charges;
    }
  
    public String getEventsName() {
      return eventsname;
    }
  
    public String getLocation() {
      return location;
    }
  
    public int getFreeEventsId() {
      return freeeventsid;
    }

    public int getCharges() {
      return charges;
    }

  }
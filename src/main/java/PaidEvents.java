import org.sql2o.*;


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
    public int getId(){
      return id;
    }

    @Override
  public boolean equals(Object otherPaidEvents) {
    if (!(otherPaidEvents instanceof PaidEvents)) {
      return false;
    } else {
      PaidEvents newEvents = (PaidEvents) otherPaidEvents;
      return this.getEventsName().equals(newEvents.getEventsName())
          && this.getLocation().equals(newEvents.getLocation());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO paidevents (eventsname, location, charges,freeeventsid,) VALUES (:eventsname, :location, :charges, :freeeventsId,)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("eventsname", this.eventsname)
        .addParameter("location", this.location)
        .addParameter("charges", this.charges)
        .addParameter("freeeventsid", this.freeeventsid)
        .executeUpdate()
        .getKey();
    }
  }

  }
import org.sql2o.*;


public class FreeEvents {
    private String name;
    private String location;
    private String description;
  
    public FreeEvents(String name, String location, String description) {
      this.name = name;
      this.location = location;
    }
  
    public String getName() {
      return name;
    }
  
    public String getLocation() {
      return location;
    }

    public String getDescription() {
        return description;
      }

      @Override
  public boolean equals(Object otherFreeEvent){
    if (!(otherFreeEvent instanceof FreeEvents)) {
      return false;
    } else {
    FreeEvents newFreeEvent = (FreeEvents) otherFreeEvent;
      return this.getName().equals(newFreeEvent.getName()) &&
             this.getLocation().equals(newFreeEvent.getLocation());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO freeevents (name, location, description) VALUES (:name, :location, :description)";
      con.createQuery(sql)
        .addParameter("name", this.name)
        .addParameter("location", this.location)
        .addParameter("description", this.description)
        .executeUpdate();
    }
  }
  
  }
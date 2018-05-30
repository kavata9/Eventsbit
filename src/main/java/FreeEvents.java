import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;


public class FreeEvents {
    private String name;
    private String location;
    private String description;
    private int id;
  
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

      public int getId() {
        return id;
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
      String sql = "INSERT INTO freeevents (name, location, description) VALUES (:name, :location, description)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("location", this.location)
        .addParameter("description", this.description)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<FreeEvents> all() {
    String sql = "SELECT * FROM freeevents";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(FreeEvents.class);
    }
  }

  public static FreeEvents find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM freeevents where id=:id";
      FreeEvents freeevents = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(FreeEvents.class);
      return freeevents;
    }
  }
  
  
  }
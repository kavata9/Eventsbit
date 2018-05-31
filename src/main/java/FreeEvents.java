import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;


public class FreeEvents {
    private String name;
    private String location;
    private String description;
    private int id;
  
    public FreeEvents(String name, String description, String location) {
      this.name = name;
      this.description = description;
      this.location = location;
      
    }
  
    public String getName() {
      return name;
    }

    public String getDescription() {
      return description;
    }
  
    public String getLocation() {
      return location;
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
             this.getDescription().equals(newFreeEvent.getDescription()) &&
             this.getLocation().equals(newFreeEvent.getLocation());

    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO freeevents (name, description, location) VALUES (:name, :description, :location)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("description", this.description)
        .addParameter("location", this.location)
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
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
  
  }
import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/events_bit_test", "agnes", "a9%Mrdvs");
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deletePersonsQuery = "DELETE FROM freeevents *;";
      String deleteMonstersQuery = "DELETE FROM paidevents *;";
      con.createQuery(deletePersonsQuery).executeUpdate();
      con.createQuery(deleteMonstersQuery).executeUpdate();
    }
  }

}
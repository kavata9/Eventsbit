import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("sign", request.session().attribute("sign"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


   get("/eventbrowser", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("sign", request.session().attribute("sign"));
     model.put("template", "templates/eventbrowser.vtl");
     model.put("showevent", false);
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

//    get("/freeevents", (request, response) -> {
//     Map<String, Object> model = new HashMap<String, Object>();
//     model.put("sign", request.session().attribute("sign"));
//     model.put("template", "templates/freeevents.vtl");
//     // model.put("showevent", false);
//     return new ModelAndView(model, layout);
//   }, new VelocityTemplateEngine());
   
   post("/eventbrowser", (request, reponse) -> {
       Map<String, Object> model = new HashMap<String, Object>(); 
       String name = request.queryParams("name");
       String description = request.queryParams("description");
       String location = request.queryParams("location");
       FreeEvents newFreeEvents = new FreeEvents(name, location, description);
       newFreeEvents.save();
       model.put("showevent", true);
       model.put("FreeEvents",newFreeEvents);
       model.put("template", "templates/eventbrowser.vtl");
       return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
  }
}



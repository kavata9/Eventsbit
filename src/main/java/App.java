// import java.util.Map;
// import java.util.HashMap;
// import java.util.List;
// import java.util.ArrayList;
// import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
// import static spark.Spark.*;

// public class App {
//   public static void main(String[] args) {
//     staticFileLocation("/public");
//     String layout = "templates/layout.vtl";

//     get("/", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("sightings", Sighting.all());
//       model.put("animals", Animal.all());
//       model.put("AnimalClass", Animal.class);
//       model.put("template", "templates/index.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());

//     post("/event/new", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       String name = request.queryParams("name");
//       String location = request.queryParams("location");
//       String eventname = request.queryParams("eventname");
//       String public = request.queryParams("public").toLowerCase();
//       String private = request.queryParams("private").toLowerCase();
//       String special = request.queryParams("special").toLowerCase();
//       Event newEvent = new Event(name, private);

//       if (public.equals("yes")) {
//         if(newEvent.completePublic(public, private, surprise)) {
//           newEvent.save();
//           newEvent.setPublic(public, private, agsurprise);
//           Events newEvents = new Events(rangername, location, newAnimal.getId());
//           newSighting.save();
//         } else {
//           response.redirect("/failure2");
//         }
//       } else if (endangered.equals("no")) {
//         if(newAnimal.completeSave()) {
//           newAnimal.save();
//           Sighting newSighting = new Sighting(rangername, location, newAnimal.getId());
//           newSighting.save();
//         } else {
//           response.redirect("/failure");
//         }
//       }

//       response.redirect("/");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());

//     get("/failure", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("template", "templates/failure.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());

//     get("/failure2", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("template", "templates/failure2.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());

//   }
// }
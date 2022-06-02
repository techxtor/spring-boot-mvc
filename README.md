MVC with Spring Boot
---
- Create Controller with `@Controller` annotation.
- Create Listeners with `@RequestMapping` annotation.
    - Listener accepts the request, process them and returns the response to client.
    - "index.jsp" is looked for in `webapp` folder
    
### Notes:
- Spring Boot internal Tomcat doesn't convert JSP pages to Servlet. So, we need Tomcat Jasper
    - Add `org.apache.tomcat.tomcat-jasper` as dependency
- In Servlet, `HttpServletRequest request` is used to capture request, here `@RequestParam("_param_")` is used instead.
- In servlet, `HttpSession session` is used for data transfer, it is replaced with:
    1. ModelAndView
    2. Model
    3. ModelMap
    
### ModelAndView
- Sets view name and models
    - `setViewName` sets view name
    - `addObject` sets models
---
    ModelAndView mv = new ModelAndView();
    mv.setViewName("_viewName_");
    mv.addObject("_attributeName_", _attributeValue_);
    return mv;
---
- view name and models can also be set using 
---
    ModelAndView mv = new ModelAndView("_viewname_", model);
    ModelAndView mv = new ModelAndView("_viewname_"); // if only view is required
---

### Prefix and Suffix
- Below properties can be added for specifying prefix and suffix in application.properties file.
---
* spring.mvc.view.prefix= /views/
* spring.mvc.view.suffix= .jsp
---

### Model:
- sets model
- pass it as argument `Model m` to listener method
---
     m.addAttribute("_attributeName_", _attributeValue_);
---

### ModelMap:
- same as Model, extends `LinkedHashMap<String, Object>`

### @ModelAttribute
- When in JSP page, reference of model is de-capitalized version of model name
    - Example for Model "Alien" if reference is ${alien} - below code works
---
    @RequestMapping("/add-alien")
    public String AddAlien(Alien a) {
        return "alien-result";
    }
---
- However if the reference has a different name, we need to explicitly specify that.
    - Example for Model "Alien", if reference is ${a1}, `@ModelAttribute` should link "a1" with "Alien"
---
    @RequestMapping("/add-alien")
    public String AddAlien(@ModelAttribute("a1") Alien a) {
        return "alien-result";
    }
---
- It can be used at method level as well.
- Below code makes attribute "name" with value of "Manish" available for all listeners, present in that controller class.
---
    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("name", "Manish");
    }
---

### POST Mapping
- `@RequestMapping` accepts all http method type.
- To make listener respond to specific http Method (here `POST`), there are 2 ways:
   1. add `method` attribute to `@RequestMapping`
---
    @RequestMapping(value = "/add-alien", method = RequestMethod.POST)
    public String AddAlien(@ModelAttribute("a1") Alien a) {
        return "alien-result";
    }
---
   2. add `@PostMapping` instead of `@RequestMapping`
---
    @PostMapping(value = "/add-alien")
---   

### GET Mapping
- `@RequestMapping` accepts all http method type.
- To make listener respond to specific http Method (here `GET`), there are 2 ways:
   1. add `method` attribute to `@RequestMapping`
---
    @RequestMapping(value = "/get-aliens", method = RequestMethod.GET)
    public String getAlien(Model m) {
        List<Alien> alienList = Arrays.asList(new Alien(101, "Techxtor"), new Alien(102, "Manish"));
        m.addAttribute("result", alienList);
        return "show-aliens";
    }
---
   2. add `@GetMapping` instead of `@RequestMapping`
---
    @GetMapping(value = "/get-aliens")
---   
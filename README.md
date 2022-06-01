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
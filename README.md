MVC with Spring Boot
---
- Create Controller with `@Controller` annotation.
- Create Listeners with `@RequestMapping` annotation.
    - Listener accepts the request, process them and returns the response to client.
    - "index.jsp" is looked for in `webapp` folder

### Notes:
- Spring Boot internal Tomcat doesn't convert JSP pages to Servlet. So, we need Tomcat Jasper
    - Add `org.apache.tomcat.tomcat-jasper` as dependency

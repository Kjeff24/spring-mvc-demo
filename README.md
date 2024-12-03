# SPRING MVC
How to setup spring mvc project based on different scenario

## TECHNOLOGY
1. Spring Boot: 3.4.0
2. Tomcat: 11.0.1
3. Java: 17

## PROJECTS
### EXAMPLE 1 SERVLET CONTAINER XML CONFIGURATION
- Path: [example-1](example-1-servlet-container-xml-configuration)
- Purpose: This project is a Spring Boot 3.4.0 application configured with an XML-based setup for the MVC architecture. The application demonstrates a traditional approach to configuring Spring MVC, with the servlet container explicitly configured using [XML](example-1-servlet-container-xml-configuration/src/main/webapp/WEB-INF/web.xml). Dispatcher servlet mapping and other essential configurations are defined in XML files, ensuring a classic and explicit configuration style. The application is packaged as a WAR file for deployment to an external servlet container like Tomcat.

#### PROJECT STRUCTURE
```
src/  
├── main/  
│   ├── java/  
│   │   └── org.example  
│   │       ├── controllers/              # Controllers for handling requests  
│   │       └── models/                   # models  
│   ├── resources/  
│   ├── webapp/  
│   │   ├── WEB-INF/  
│   │   │   ├── jsp/                     # JSP views  
│   │   │   │   └── index.jsp            # Sample JSP page  
│   │   │   └── springmvc-config.xml     # XML-based Spring MVC configuration  
│   │   └── web.xml                      # Servlet container configuration
├── test/                                # Unit and integration tests
└── target/                            
```

### EXAMPLE 2 SERVLET CONTAINER CLASS CONFIGURATION
- Path: [example-2](example-2-servlet-container-class-configuration)
- Purpose: Instead of the traditional web.xml, we use [AbstractDispatcherServletInitializer](example-2-servlet-container-class-configuration/src/main/java/org/example/configs/WebAppInitializer.java) to configure the DispatcherServlet and servlet mappings programmatically in Java.
This approach removes the need for web.xml while still setting up Spring MVC in a clear and explicit way. The application is packaged as a WAR file, ready to be deployed to an external servlet container like Tomcat.
- Configuration: `WebApplicationInitializer` and `AbstractDispatcherServletInitializer` are used to configure the Servlet container programmatically, replacing the traditional `web.xml`.  
  - `WebApplicationInitializer` is an interface in Spring that allows you to configure the `ServletContext` programmatically during the initialization of a web application.
  - `AbstractDispatcherServletInitializer` is an abstract class provided by Spring to simplify the configuration of `DispatcherServlet` in a Java-based web application. It’s a subclass of `WebApplicationInitializer`, but with several methods already implemented to reduce boilerplate code.

Use case 1
```
public class WebConfig implements WebApplicationInitializer {
    // The onStartup method is called when the application is starting up.
    @Override
    public void onStartup(ServletContext container) {
        // Create a new instance of the XmlWebApplicationContext, which will load the Spring configuration from an XML file.
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        // Set the location of the Spring MVC configuration XML file.
        // This XML file contains configurations for view resolvers, component scanning, etc.
        appContext.setConfigLocation("/WEB-INF/springmvc-config.xml");
        
        // Register the DispatcherServlet with the servlet container. The DispatcherServlet is the front controller in Spring MVC.
        // It will handle all incoming requests and delegate them to the appropriate controllers.
        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(appContext));
        // Set the load-on-startup priority. A value of 1 means the DispatcherServlet will be loaded when the application starts.        registration.setLoadOnStartup(1);
        // Map the DispatcherServlet to the root URL pattern ("/"). This means all incoming requests will be handled by this servlet.
        registration.addMapping("/");
    }
}

```
Use Case 2
```
public class WebAppInitializer extends AbstractDispatcherServletInitializer {

    // This method is called to create the root application context.
    // In this case, we're not using a root context, so we return null.
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    // This method is used to create the servlet application context, which is the context for the DispatcherServlet.
    // We create an instance of XmlWebApplicationContext, which loads the Spring MVC configuration from an XML file.
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        // Set the location of the Spring MVC configuration XML file.
        // This file contains configurations for beans, view resolvers, and other Spring MVC-related settings.
        appContext.setConfigLocation("/WEB-INF/springmvc-config.xml");
        return appContext;
    }

    // This method defines the servlet mappings. In this case, we map the DispatcherServlet to the root URL path ("/").
    // All incoming requests will be handled by the DispatcherServlet.
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};  // The DispatcherServlet will handle all requests to the root path ("/").
    }
}
```
### PROJECT STRUCTURE
```
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org
│   │   │       └── example
│   │   │           ├── Main.java
│   │   │           ├── configs
│   │   │           │   └── WebAppInitializer.java
│   │   │           ├── controllers
│   │   │           │   ├── HelloController.java
│   │   │           │   └── RestApiController.java
│   │   │           └── models
│   │   │               └── User.java
│   │   ├── resources
│   │   └── webapp
│   │       └── WEB-INF
│   │           ├── jsp
│   │           │   └── home.jsp
│   │           └── springmvc-config.xml
│   └── test
│       └── java
└── target

```

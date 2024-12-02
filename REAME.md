# SPRING MVC
How to setup spring mvc project based on different scenario

## TECHNOLOGY
1. Spring Boot: 3.4.0
2. Tomcat: 11.0.1
3. Java: 17

## PROJECTS
### EXAMPLE-1
This project is a Spring Boot 3.4.0 application configured with XML-based setup for MVC architecture. The application demonstrates a traditional approach to configuring Spring MVC while leveraging modern Spring Boot features. It is packaged as a WAR file for deployment to an external servlet container like Tomcat.

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

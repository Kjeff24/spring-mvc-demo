package org.example.configs;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

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

package org.example.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * WebAppInitializer is responsible for configuring the DispatcherServlet in a Spring web application.
 * This class replaces the need for a web.xml file in the servlet container and uses Java-based configuration.
 * It extends AbstractAnnotationConfigDispatcherServletInitializer to set up the application context and servlet mappings.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Returns the configuration classes for the root application context.
     * This context is used for beans that are shared across the entire application.
     * In this example, it is not required, so we return an empty array.
     *
     * @return an empty array as there are no root config classes
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * Returns the configuration classes for the DispatcherServlet application context.
     * This context is specific to the DispatcherServlet and typically holds MVC-related beans.
     * Here, we use the WebConfig class to load the Spring MVC configuration.
     *
     * @return an array containing the WebConfig class, which configures Spring MVC
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    /**
     * Returns the servlet mappings for the DispatcherServlet.
     * This method defines which URL patterns the DispatcherServlet should handle.
     * In this case, we map the DispatcherServlet to handle all URLs ("/").
     *
     * @return an array containing the root URL mapping ("/")
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}

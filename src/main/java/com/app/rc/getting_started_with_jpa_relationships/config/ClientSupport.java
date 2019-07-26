package com.app.rc.getting_started_with_jpa_relationships.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Demonstration of using property from the custom properties file
 */
@Component
@PropertySource("classpath:testSubjects.properties")
public class ClientSupport {

    private static final Logger LOG = LoggerFactory.getLogger(ClientSupport.class);

    @Value("${app.name}")
    private String name;

    @Value("${app.author}")
    private String author;

    @Value("${app.version}")
    private String version;

    /**
     * Default Constructor mandatory
     */
    public ClientSupport() {
        // Default
    }

    /**
     * Load the name property value from the file
     *
     * @return Value of app.name property
     */
    @PostConstruct
    public String getName() {
        LOG.info("App Name (PostConstruct) : {}", this.name);
        return this.name;
    }

    /**
     * Load the author property value from the file
     *
     * @return Value of app.author property
     */
    @PostConstruct
    public String getAuthor() {
        LOG.info("App Author (PostConstruct) : {}", this.author);
        return author;
    }

    /**
     * Load the version property value from the file
     *
     * @return Value of app.version property
     */
    @PostConstruct
    public String getVersion() {
        LOG.info("App Version (PostConstruct) : {}", this.version);
        return version;
    }
}

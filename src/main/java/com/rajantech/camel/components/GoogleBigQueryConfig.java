package com.rajantech.camel.components;

import org.apache.camel.component.google.bigquery.GoogleBigQueryComponent;
import org.apache.camel.component.google.bigquery.GoogleBigQueryConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleBigQueryConfig {
	
	@Value("${credentials.fileLocation}")
	private String fileLocation;
	
	
	public GoogleBigQueryComponent createComponent() {
        GoogleBigQueryComponent component = new GoogleBigQueryComponent();
        GoogleBigQueryConnectionFactory connectionFactory = createConnectionFactory();
        component.setConnectionFactory(connectionFactory);
        return component;
    }

    public GoogleBigQueryConnectionFactory createConnectionFactory() {
        GoogleBigQueryConnectionFactory connectionFactory = new GoogleBigQueryConnectionFactory();
        connectionFactory.setCredentialsFileLocation(fileLocation);
        return connectionFactory;
    }
	

}

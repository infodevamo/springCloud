package org.formation.document;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

/**
 * The accounts Spring configuration.
 * 
 * @author Paul Chapman
 */
@Configuration
@PropertySource("classpath:db-config.properties")
public class DocumentsConfiguration {

	protected Logger logger;

	public DocumentsConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

	/**
	 * Creates an in-memory "rewards" database populated with test data for fast
	 * testing
	 */
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");

		// Create an in-memory H2 relational database containing some demo
		// accounts.
		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:testdb/schema.sql")
				.addScript("classpath:testdb/data.sql").build();

		logger.info("dataSource = " + dataSource);

		// Sanity check
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> documents = jdbcTemplate.queryForList("SELECT NAME FROM DOCUMENT");
		logger.info("System has " + documents.size() + " documents");

		// Populate with random registration date
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -2);
		for (Map<String, Object> item : documents) {
			String name = (String) item.get("NAME");
			cal.set(Calendar.DAY_OF_MONTH, (int)System.currentTimeMillis()%28);
			jdbcTemplate.update("UPDATE DOCUMENT SET UPLOADED_DATE = ? WHERE name = ?", cal.getTime(), name);
		}

		return dataSource;
	}
}

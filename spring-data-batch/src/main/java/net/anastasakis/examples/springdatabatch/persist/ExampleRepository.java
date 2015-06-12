package net.anastasakis.examples.springdatabatch.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author cyrus
 */
@Component
public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {
	
	
}

package net.anastasakis.examples.springdatabatch;

import java.util.Arrays;
import java.util.UUID;

import javax.inject.Inject;

import net.anastasakis.examples.springdatabatch.persist.ExampleEntity;
import net.anastasakis.examples.springdatabatch.persist.ExampleRepository;

import org.springframework.stereotype.Component;

@Component(value="runner")
public class Runner {

	@Inject
	private ExampleRepository exampleRepository;
	
	public void run(){
		final ExampleEntity entity1 = new ExampleEntity(UUID.randomUUID().toString());
		final ExampleEntity entity2 = new ExampleEntity(UUID.randomUUID().toString());
		exampleRepository.save(Arrays.asList(entity1,entity2));
	}
	
}

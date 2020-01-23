package org.duttydev.ssdrapi.samplespringdatarestapi;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SampleSpringDataRestApiApplication implements CommandLineRunner {

	@Autowired
	private EventRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringDataRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker();
		Random r = new Random();

		int numEvents = r.nextInt(250 + 1);

		for (int i = 0; i < numEvents; i++) {
			Instant start = faker.date().future(5, TimeUnit.DAYS).toInstant();
			Instant end = faker.date().future(r.nextInt(4+1) + 1, TimeUnit.HOURS, Date.from(start)).toInstant();

			int numGuests = r.nextInt(1 +5);
			List<String> guests = new ArrayList<>(numGuests);
			for (int j = 0; j < numGuests; j++) {
				guests.add(faker.internet().emailAddress());
			}

			Event event = Event.builder()
					.name(faker.company().name() + " Event")
					.description(faker.lorem().paragraph())
					.startTime(start)
					.endTime(end)
					.guesEmails(guests)
					.build();

			repo.save(event);
		}
	}
}

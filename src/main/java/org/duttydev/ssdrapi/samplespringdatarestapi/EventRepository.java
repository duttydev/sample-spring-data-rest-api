package org.duttydev.ssdrapi.samplespringdatarestapi;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "events", collectionResourceRel = "events")
public interface EventRepository extends PagingAndSortingRepository<Event, String> {
}

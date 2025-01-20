package com.online.multitenantlib.service;

import com.online.multitenantlib.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    List<Publisher> getAllPublishers();
    Optional<Publisher> getPublisherByName(String name);
    Publisher addPublisher(Publisher publisher);
    Publisher updatePublisher(Publisher publisher);
    void deletePublisher(Publisher publisher);
}

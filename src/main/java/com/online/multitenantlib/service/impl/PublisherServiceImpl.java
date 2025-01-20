package com.online.multitenantlib.service.impl;

import com.online.multitenantlib.model.Publisher;
import com.online.multitenantlib.repo.PublisherRepository;
import com.online.multitenantlib.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> getPublisherByName(String name) {
        return publisherRepository.findByPublisherName(name);
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisher(Publisher publisher) {
        publisherRepository.delete(publisher);
    }
}

package com.example.sudoswap.service.collection.impl;

import com.example.sudoswap.entity.nft.CollectionEntity;
import com.example.sudoswap.repository.CardRepository;
import com.example.sudoswap.repository.CollectionRepository;
import com.example.sudoswap.service.collection.CollectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepository;
    private final CardRepository cardRepository;

    public CollectionServiceImpl(CollectionRepository collectionRepository, CardRepository cardRepository) {
        this.collectionRepository = collectionRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public void createCollection(String name, int numberOfCards) {
        collectionRepository.save(new CollectionEntity(name, numberOfCards));
    }

    @Override
    public void editCollection(Long id, String name, int numberOfCards) throws Exception {
        CollectionEntity collection = collectionRepository.findById(id).orElseThrow(Exception::new);
        collection.setName(name);
        collection.setNumberOfCards(numberOfCards);
        collectionRepository.save(collection);
    }

    @Override
    public void deleteCollection(Long id) throws Exception {
        collectionRepository.deleteById(id);
    }

    @Override
    public List<CollectionEntity> findAll() {
        return collectionRepository.findAll();
    }

    @Override
    public CollectionEntity findById(Long id) throws Exception {
        return collectionRepository.findById(id).orElseThrow(Exception::new);
    }
}

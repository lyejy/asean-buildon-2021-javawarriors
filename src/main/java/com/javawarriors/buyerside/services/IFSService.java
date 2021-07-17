package com.javawarriors.buyerside.services;

import com.javawarriors.buyerside.entities.*;
import com.javawarriors.buyerside.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service layer for handling logic related to item for sale listings
 */
@Service
public class IFSService {

    @Autowired
    private IFSRepo ifsRepo;
    @Autowired
    private JwtUserDetailsService userService;

    @Autowired
    private OfferService offerService;
    @Autowired
    private DealService dealService;
    @Autowired
    private SellerQnAService sellerQnAService;

    // public List<ItemForSaleListing> saveAll(Iterable<ItemForSaleListing>
    // entities) {
    // return ifsRepo.saveAll(entities);
    // }

    public List<ItemForSaleListing> findAll() {
        return ifsRepo.findAll();
    }

    public ItemForSaleListing save(ItemForSaleListing entity) {
        return ifsRepo.save(entity);
    }

    public void deleteById(Long ifsId) {
        sellerQnAService.deleteByIfsListing(ifsId);
        dealService.deleteByIfsId(ifsId);
        offerService.deleteByIfsId(ifsId);
        ifsRepo.deleteById(ifsId);
    }

    public List<ItemForSaleListing> getSearchResults(String keyword) {
        return ifsRepo.findByTitleContaining(keyword);
    }

    public List<ItemForSaleListing> findByUser(Long userId) {
        User user = userService.findInRepoById(userId);
        return ifsRepo.findByUser(user);
    }

    public List<ItemForSaleListing> getSearchResults(String keyword, String categoryName) {
        // return ifsRepo.findByTitleContaining(keyword);
        return ifsRepo.findByTitleAndCategoryContaining(keyword, categoryName);
    }

    public ItemForSaleListing findByListingId(Long id) {
        return ifsRepo.findById(id).get();
    }
}

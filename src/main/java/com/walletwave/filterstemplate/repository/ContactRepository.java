package com.walletwave.filterstemplate.repository;

import com.walletwave.filterstemplate.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {
	
	
}
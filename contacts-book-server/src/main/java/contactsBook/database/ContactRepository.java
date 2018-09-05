package contactsBook.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import contactsBook.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{
	
	List<Contact> findAll();
	
	

}

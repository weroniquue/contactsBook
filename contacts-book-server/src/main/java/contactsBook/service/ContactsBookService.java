package contactsBook.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contactsBook.database.ContactCategoryRepository;
import contactsBook.database.ContactRepository;
import contactsBook.exception.AppException;
import contactsBook.model.Contact;
import contactsBook.model.ContactCategory;
import contactsBook.model.ContactCategoryEnum;
import contactsBook.payload.ContactRequest;

@Service
public class ContactsBookService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ContactCategoryRepository categoryRepository;

	private static final Logger logger = LoggerFactory.getLogger(ContactsBookService.class);
	public static String DEFAULT_CATEGORY = "OTHER";

	public List<?> getAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		return contacts;
	}

	public ContactCategory findCategory(Optional<String> categoryName) {
		return categoryRepository.findByName(ContactCategoryEnum.valueOf(categoryName.orElse(DEFAULT_CATEGORY)))
				.orElseThrow(() -> new AppException("Category not found!"));
	}

	public Contact createContact(ContactRequest contactRequest) {

		ContactCategory category = findCategory(contactRequest.getCategory());

		Contact contact = new Contact(contactRequest.getFirstName(), contactRequest.getLastName(),
				contactRequest.getPhoneNumber().orElse(""), contactRequest.getEmail().orElse(""),
				contactRequest.getStreet().orElse(""), contactRequest.getCode().orElse(""),
				contactRequest.getCategory().orElse(""), category);

		return contactRepository.save(contact);

	}

	public Optional<Contact> getContactById(Long id) {
		return contactRepository.findById(id);
	}

	public void deleteContact(Long id) {
		contactRepository.deleteById(id);
	}

	public void editContact(Contact contact, ContactRequest contactEditRequest) {
		
		ContactCategory category = findCategory(contactEditRequest.getCategory());
		
		contact.setFirstName(contactEditRequest.getFirstName());
		contact.setLastName(contactEditRequest.getLastName());
		contact.setPhoneNumber(contactEditRequest.getPhoneNumber().orElse(contact.getPhoneNumber().get()));
		contact.setEmail(contactEditRequest.getEmail().orElse(contact.getEmail().get())); 
		contact.setStreet(contactEditRequest.getStreet().orElse(contact.getStreet().get()));
		contact.setCode(contactEditRequest.getCode().orElse(contact.getCode().get()));
		contact.setCity(contactEditRequest.getCity().orElse(contact.getCity().get()));
		contact.setCategory(category);
		
		contactRepository.save(contact);

		}


}

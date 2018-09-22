package contactsBook.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import contactsBook.exception.ResourceNotFoundException;
import contactsBook.model.Contact;
import contactsBook.payload.ApiResponse;
import contactsBook.payload.ContactRequest;
import contactsBook.service.ContactsBookService;

@RestController
@RequestMapping("/api")
public class ContactsBookController {

	@Autowired
	private ContactsBookService contactsBookService;

	@GetMapping("/")
	public List<?> getAllContacts() {
		return contactsBookService.getAllContacts();
	}

	@PostMapping
	public ResponseEntity<?> createContact(@Valid @RequestBody ContactRequest contactRequest) {

		Contact contact = contactsBookService.createContact(contactRequest);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/contact/{id}")
				.buildAndExpand(contact.getId()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "Contact created successfully"));
	}

	@GetMapping("/contact/{id}")
	public Contact getContactById(@PathVariable Long id) {
		return contactsBookService.getContactById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));

	}

	@DeleteMapping("/contact/{id}")
	public ResponseEntity<?> deleteContact(@PathVariable Long id) {
		if (contactsBookService.getContactById(id) != null) {
			contactsBookService.deleteContact(id);
			return new ResponseEntity<>(new ApiResponse(true, "Contact deleted successfully"), HttpStatus.OK);
		}

		return new ResponseEntity<>(new ApiResponse(false, "Such id is not found in database!"), HttpStatus.NOT_FOUND);

	}

	@PostMapping("/contact/{id}")
	public ResponseEntity<?> editContact(@PathVariable Long id, @Valid @RequestBody ContactRequest contactEditRequest){
		
		Contact contact = getContactById(id);
		contactsBookService.editContact(contact, contactEditRequest);
		
		return new ResponseEntity<>(new ApiResponse(true, "Coontact updated"), HttpStatus.OK);
		
	}

}

package contactsBook.payload;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ContactRequest {

	@NotBlank
	@Size(max = 20)
	private String firstName;

	@NotBlank
	@Size(max = 20)
	private String lastName;

	private Optional<String> phoneNumber;

	private Optional<String> email;

	private Optional<String> street;

	private Optional<String> code;

	private Optional<String> city;

	private Optional<String> category;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Optional<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Optional<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Optional<String> getEmail() {
		return email;
	}

	public void setEmail(Optional<String> email) {
		this.email = email;
	}

	public Optional<String> getStreet() {
		return street;
	}

	public void setStreet(Optional<String> street) {
		this.street = street;
	}

	public Optional<String> getCode() {
		return code;
	}

	public void setCode(Optional<String> code) {
		this.code = code;
	}

	public Optional<String> getCity() {
		return city;
	}

	public void setCity(Optional<String> city) {
		this.city = city;
	}

	public Optional<String> getCategory() {
		return category;
	}

	public void setCategory(Optional<String> category) {
		this.category = category;
	}

	public ContactRequest(@NotBlank @Size(max = 20) String firstName, @NotBlank @Size(max = 20) String lastName,
			Optional<String> phoneNumber, @Email Optional<String> email,
			Optional<String> street, 
			Optional<String> code,
			Optional<String> city,
			Optional<String> category) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.street = street;
		this.code = code;
		this.city = city;
		this.category = category;
	}

}

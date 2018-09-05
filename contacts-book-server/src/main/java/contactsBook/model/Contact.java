package contactsBook.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String firstName;

	@NotBlank
	@Size(max = 20)
	private String lastName;

	private String phoneNumber;

	@Email
	private String email;

	private String street;

	private String code;

	private String city;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private ContactCategory category;

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(@NotBlank @Size(max = 20) String firstName, @NotBlank @Size(max = 20) String lastName,
			String phoneNumber, @Email String email, String street, String code, String city,
			ContactCategory category) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.street = street;
		this.code = code;
		this.city = city;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Optional<String> getFirstName() {
		return Optional.ofNullable(firstName);
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Optional<String> getLastName() {
		return Optional.ofNullable(lastName);
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Optional<String> getPhoneNumber() {
		return Optional.ofNullable(phoneNumber);
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Optional<String> getEmail() {
		return Optional.ofNullable(email);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Optional<String> getStreet() {
		return Optional.ofNullable(street);
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Optional<String> getCode() {
		return Optional.ofNullable(code);
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Optional<String> getCity() {
		return Optional.ofNullable(city);
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ContactCategory getCategory() {
		return category;
	}

	public void setCategory(ContactCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", street=" + street + ", code=" + code + ", city=" + city
				+ ", category=" + category + "]";
	}

}

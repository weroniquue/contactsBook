package contactsBook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class ContactCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name="category_name")
	private ContactCategoryEnum categoryName;

	public ContactCategory() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContactCategoryEnum getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(ContactCategoryEnum categoryName) {
		this.categoryName = categoryName;
	}
	

	

	

}

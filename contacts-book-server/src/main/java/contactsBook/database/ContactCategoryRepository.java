package contactsBook.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import contactsBook.model.ContactCategory;
import contactsBook.model.ContactCategoryEnum;

@Repository
public interface ContactCategoryRepository extends CrudRepository<ContactCategory, Long>{
	
	@Query("SELECT e from ContactCategory e where e.categoryName= :categoryName")
	Optional<ContactCategory> findByName(@Param("categoryName") ContactCategoryEnum categoryName);

}

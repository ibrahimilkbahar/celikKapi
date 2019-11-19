package tr.com.mindworks.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tr.com.mindworks.model.TDistrict;
import tr.com.mindworks.model.TPropertyLov;

@Repository
public interface PropertyLovRepository extends JpaRepository<TPropertyLov, Integer>
{
	@Query("SELECT p FROM TPropertyLov p WHERE p.propertyLovDefId.id =:propertyLovDefId")
	List<TPropertyLov> findAllPropertyLovByDefId(@Param("propertyLovDefId") Integer propertyLovDefId);

}

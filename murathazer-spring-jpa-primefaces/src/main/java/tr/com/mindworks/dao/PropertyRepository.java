package tr.com.mindworks.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tr.com.mindworks.model.TCity;
import tr.com.mindworks.model.TOfferingProperty;
import tr.com.mindworks.model.TProperty;
import tr.com.mindworks.model.TPropertyGroup;
import tr.com.mindworks.model.TPropertyType;

@Repository
public interface PropertyRepository extends JpaRepository<TProperty, Integer>
{
	@Query("SELECT p FROM TPropertyType p order by p.orderBy")
	public List<TPropertyType> findAllPropertyTypes();
	
	@Query("SELECT p FROM TPropertyGroup p order by p.orderBy")
	public List<TPropertyGroup> findAllPropertyGroups();
	
	
	@Query("SELECT p FROM TProperty p WHERE p.propertyGroupId.id =:propertyGroupId and p.id not in ( select k.id from TOfferingProperty  k where k.offeringId.id =:offeringId)")
    public List<TProperty> findAvailablePropertiesForThatOffering(@Param("offeringId") Integer offeringId,@Param("propertyGroupId") Integer propertyGroupId);

	@Query("SELECT p FROM TProperty p WHERE p.propertyGroupId.id =:propertyGroupId and p.id in ( select k.id from TOfferingProperty  k where k.offeringId.id =:offeringId)")
    public List<TProperty> findPropertiesOfThatOffering(@Param("offeringId") Integer offeringId,@Param("propertyGroupId") Integer propertyGroupId);
}

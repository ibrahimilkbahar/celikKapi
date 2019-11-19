package tr.com.mindworks.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tr.com.mindworks.model.TOfferingProperty;
import tr.com.mindworks.model.TProperty;

@Repository
public interface OfferingPropertyRepository extends JpaRepository<TOfferingProperty, Integer>
{
	@Query("SELECT p FROM TOfferingProperty p WHERE p.propertyId.id =:propertyId and p.offeringId.id =:offeringId")
	public TOfferingProperty findByOfferingIdAndPropertyId(@Param("offeringId") Integer offeringId, @Param("propertyId")Integer propertyId);
	
	@Query("SELECT p FROM TOfferingProperty p WHERE p.propertyId.code =:propertyCode and p.offeringId.id =:offeringId")
	public TOfferingProperty findByOfferingIdAndPropertyCode(@Param("offeringId") Integer offeringId, @Param("propertyCode")String propertyCode);
	
    @Modifying
    @Transactional
	@Query("Delete from TOfferingProperty p WHERE p.offeringId.id =:offeringId")
	public void deleteWithOfferingId(@Param("offeringId") Integer offeringId);

    @Query("SELECT p.propertyId FROM TOfferingProperty p WHERE p.propertyId.id =:propertyId and p.offeringId.id =:offeringId")
	public List<TProperty> findAllPropertiesOfOffering(@Param("offeringId")Integer offeringId, @Param("propertyId")Integer propertyId);

    
    @Modifying
    @Transactional
	@Query("Delete from TOfferingProperty p WHERE p.offeringId.id =:offeringId and p.propertyId.id =:propertyId")
    public void deleteByOfferingIdAndPropertyId(@Param("offeringId") Integer offeringId, @Param("propertyId") Integer propertyId);
	

}

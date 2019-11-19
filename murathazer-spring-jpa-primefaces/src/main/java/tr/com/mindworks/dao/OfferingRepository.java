package tr.com.mindworks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.mindworks.model.TOffering;

@Repository
public interface OfferingRepository extends JpaRepository<TOffering, Integer>
{
	
}

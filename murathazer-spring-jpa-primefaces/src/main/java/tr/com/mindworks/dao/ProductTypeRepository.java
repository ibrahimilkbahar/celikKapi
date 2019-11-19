package tr.com.mindworks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.mindworks.model.TProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<TProductType, Integer>
{

}

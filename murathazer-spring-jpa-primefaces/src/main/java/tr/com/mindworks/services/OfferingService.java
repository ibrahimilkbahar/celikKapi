package tr.com.mindworks.services;

import java.util.List;

import org.primefaces.model.DualListModel;

import tr.com.mindworks.model.TOffering;
import tr.com.mindworks.model.TOfferingProperty;
import tr.com.mindworks.model.TProductType;
import tr.com.mindworks.model.TProperty;

public interface OfferingService
{
	List<TOffering> findAll();
	void deleteOffering(Integer offeringId);
	TOffering findOfferingById(Integer offeringId);
	void saveOffering(TOffering offering);
	
	
	List<TProductType> findAllProductType();
	
	DualListModel<TProperty> getOfferingPropertyList(Integer offeringId,Integer propertyGroupId);
	void saveOfferingProperty(TOfferingProperty offeringProperty);
	TOfferingProperty getOfferingProperty(Integer offeringId, Integer propertyId);
	void updateOfferingProperties(List<TProperty> propertyList, TOffering offering,Integer propertyGroupId);
}

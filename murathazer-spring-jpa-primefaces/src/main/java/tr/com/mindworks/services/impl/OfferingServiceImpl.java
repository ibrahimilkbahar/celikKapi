package tr.com.mindworks.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.mindworks.dao.OfferingPropertyRepository;
import tr.com.mindworks.dao.OfferingRepository;
import tr.com.mindworks.dao.ProductTypeRepository;
import tr.com.mindworks.dao.PropertyRepository;
import tr.com.mindworks.model.TOffering;
import tr.com.mindworks.model.TOfferingProperty;
import tr.com.mindworks.model.TProductType;
import tr.com.mindworks.model.TProperty;
import tr.com.mindworks.services.OfferingService;

@Service("offeringService")
public class OfferingServiceImpl implements OfferingService, Serializable {
	@Autowired
	private OfferingRepository offeringRepository;
	@Autowired
	private OfferingPropertyRepository offeringPropertyRepository;

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Override
	public List<TOffering> findAll() {
		return offeringRepository.findAll();
	}

	@Override
	public void deleteOffering(Integer offeringId) {
		offeringRepository.delete(offeringId);
	}

	@Override
	public TOffering findOfferingById(Integer offeringId) {
		return offeringRepository.findOne(offeringId);
	}

	@Override
	public void saveOffering(TOffering offering) {
		offeringRepository.save(offering);
	}

	@Override
	public List<TProductType> findAllProductType() {
		return productTypeRepository.findAll();
	}

	@Override
	public DualListModel<TProperty> getOfferingPropertyList(Integer offeringId, Integer propertyGroupId) {
		List<TProperty> propertySource = new ArrayList<TProperty>();
		List<TProperty> propertyTarget = new ArrayList<TProperty>();
		propertySource = propertyRepository.findAvailablePropertiesForThatOffering(offeringId, propertyGroupId);
		propertyTarget = propertyRepository.findPropertiesOfThatOffering(offeringId, propertyGroupId);
		return new DualListModel<TProperty>(propertySource, propertyTarget);
	}

	@Override
	public void saveOfferingProperty(TOfferingProperty offeringProperty) {
		offeringPropertyRepository.save(offeringProperty);
	}

	@Override
	public TOfferingProperty getOfferingProperty(Integer offeringId, Integer propertyId) {
		return offeringPropertyRepository.findByOfferingIdAndPropertyId(offeringId, propertyId);
	}

	@Override
	public void updateOfferingProperties(List<TProperty> updatedPropertyList, TOffering offering,Integer propertyGroupId) {

		List<TProperty> currentPropertyList = offeringPropertyRepository.findAllPropertiesOfOffering(offering.getId(),propertyGroupId);
		
		HashMap<String, TProperty> updatedProperties = new HashMap<String,TProperty>();
		HashMap<String, TProperty> currentProperties = new HashMap<String,TProperty>();
		
		for (TProperty tProperty : updatedPropertyList)  
			updatedProperties.put(tProperty.getCode(),tProperty);
		
		for (TProperty tProperty : currentPropertyList)  
			currentProperties.put(tProperty.getCode(),tProperty);
		
		
		

		for (int i = 0; i < updatedPropertyList.size(); i++) {
			TProperty tProperty = updatedPropertyList.get(i);
			
			if(currentProperties.containsKey(tProperty.getCode())) 
			{
				TOfferingProperty offProp =  offeringPropertyRepository.findByOfferingIdAndPropertyCode(offering.getId(), tProperty.getCode());
				offProp.setOrderBy(i);
				offeringPropertyRepository.save(offProp);
			}else 
			{
				TOfferingProperty offProp = new TOfferingProperty();
				offProp.setOrderBy(i);
				offProp.setOfferingId(offering);
				offProp.setPropertyId(tProperty);
				offeringPropertyRepository.save(offProp);
			}
		}
		
		for (TProperty tProperty : currentPropertyList) {
			if(!updatedProperties.containsKey(tProperty.getCode())) 
			{
				offeringPropertyRepository.deleteByOfferingIdAndPropertyId(offering.getId(),tProperty.getId());
			}
		}
	}
}

package tr.com.mindworks.controllers.offering;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Provider;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;
import tr.com.mindworks.annotations.SpringFlowScoped;
import tr.com.mindworks.controllers.BaseController;
import tr.com.mindworks.model.TCustomerContact;
import tr.com.mindworks.model.TOffering;
import tr.com.mindworks.model.TOfferingProperty;
import tr.com.mindworks.model.TProductType;
import tr.com.mindworks.model.TProperty;
import tr.com.mindworks.services.OfferingService;

@Component("offeringController")
@SpringFlowScoped
@SessionScope
public class OfferingController extends BaseController {

	@Autowired
	private Provider<OfferingService> offeringService;

	@Getter
	@Setter
	private TOffering offering;
	@Getter
	@Setter
	private List<TOffering> offeringList;
	
	@Getter
	@Setter
	private List<TProductType> productTypeList;
	@Getter
	@Setter
	private Integer productTypeId;
		
	@Getter
	@Setter
	private DualListModel<TProperty> propertyDualListMain;
	
	@PostConstruct
	public void initOfferingList() {
		offeringList = offeringService.get().findAll();
		productTypeList = offeringService.get().findAllProductType();
	}

	public void initializeDetailOffering() {
		FacesContext context = FacesContext.getCurrentInstance();
		String offeringId = context.getExternalContext().getRequestParameterMap().get("offeringId");
		if (offeringId == null || "".equals(offeringId)) {
			jsfMessageUtil.addInfoMessage("offering bulunamadı.");
		} else {
			offering = offeringService.get().findOfferingById(Integer.parseInt(offeringId));
			productTypeList = offeringService.get().findAllProductType();
			productTypeId= offering.getProductTypeId().getId();
			
			propertyDualListMain = offeringService.get().getOfferingPropertyList(offering.getId(),1);
		}
	}

	public void initializeCreateOffering() {
		offering = new TOffering();
		productTypeList = offeringService.get().findAllProductType();
	}

	public String saveOffering() {
		try {
			offering.setProductTypeId(new TProductType(productTypeId));
			offeringService.get().saveOffering(offering);
			jsfMessageUtil.addInfoMessage("Sunu Kaydedildi. :)");
			List<TProperty> offeringPropertyList = propertyDualListMain.getTarget();
			
			offeringService.get().updateOfferingProperties(offeringPropertyList,offering,1);
			
			return "offeringSaved";
		} catch (Exception exception) {
			jsfMessageUtil.handleException("Sunu Kaydedilemedi.!!!", exception);
			return null;
		}
	}

	public void deleteOffering(TOffering offering) {
		offeringService.get().deleteOffering(offering.getId());
		offeringList = offeringService.get().findAll();
	}
	
    
}

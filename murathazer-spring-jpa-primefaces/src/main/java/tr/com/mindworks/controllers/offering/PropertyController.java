package tr.com.mindworks.controllers.offering;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;
import tr.com.mindworks.annotations.SpringFlowScoped;
import tr.com.mindworks.controllers.BaseController;
import tr.com.mindworks.model.TProperty;
import tr.com.mindworks.model.TPropertyGroup;
import tr.com.mindworks.model.TPropertyLov;
import tr.com.mindworks.model.TPropertyLovDef;
import tr.com.mindworks.model.TPropertyType;
import tr.com.mindworks.services.PropertyService;

@Component("propertyController")
@SpringFlowScoped
@SessionScope
public class PropertyController extends BaseController {

	@Autowired
	private Provider<PropertyService> propertyService;
	@Getter
	@Setter
	private TProperty property;
	@Getter
	@Setter
	private List<TProperty> propertyList;

	@Getter
	@Setter
	private List<TPropertyType> propertyTypeList;

	@Getter
	@Setter
	private List<TPropertyGroup> propertyGroupList;

	@Getter
	@Setter
	private Integer propertyTypeId, propertyGroupId, propertyLovDefId;

	@Getter
	@Setter
	private List<TPropertyLovDef> propertyLovDefList;

	@PostConstruct
	public void initPropertyList() {
		propertyList = propertyService.get().findAll();
		propertyTypeList = propertyService.get().findAllPropertyType();
		propertyGroupList = propertyService.get().findAllPropertyGroup();
	}

	public void initializeDetailProperty() {
		FacesContext context = FacesContext.getCurrentInstance();
		String propertyId = context.getExternalContext().getRequestParameterMap().get("propertyId");
		if (propertyId == null || "".equals(propertyId)) {
			jsfMessageUtil.addInfoMessage("property bulunamadı.");
		} else {
			property = propertyService.get().findPropertyById(Integer.parseInt(propertyId));
			propertyGroupId = property.getPropertyGroupId().getId();
			propertyTypeId = property.getPropertyTypeId().getId();
			propertyLovDefList = propertyService.get().findAllPropertyLovDef();
			if (property.getPropertyLovDefId() != null)
				propertyLovDefId = property.getPropertyLovDefId().getId();
		}
	}

	public void initializeCreateProperty() {
		property = new TProperty();
		property.setPropertyTypeId(new TPropertyType());
		property.setPropertyGroupId(new TPropertyGroup());
		propertyTypeList = propertyService.get().findAllPropertyType();
		propertyGroupList = propertyService.get().findAllPropertyGroup();
		propertyLovDefList = propertyService.get().findAllPropertyLovDef();
	}

	public String saveProperty() {
		try {
			property.setPropertyGroupId(new TPropertyGroup(propertyGroupId));
			property.setPropertyTypeId(new TPropertyType(propertyTypeId));
			if (property.getPropertyTypeId().getId().equals(6)) {
				property.setPropertyLovDefId(new TPropertyLovDef(propertyLovDefId));
			} else {
				property.setPropertyLovDefId(null);
			}
			propertyService.get().saveProperty(property);
			jsfMessageUtil.addInfoMessage("Özellik Kaydedildi. :)");
			return "propertySaved";
		} catch (Exception exception) {
			jsfMessageUtil.handleException("Özellik Kaydedilemedi.!!!", exception);
			return null;
		}
	}

	public void deleteProperty(TProperty property) {
		propertyService.get().deleteProperty(property.getId());
		propertyList = propertyService.get().findAll();
	}
}

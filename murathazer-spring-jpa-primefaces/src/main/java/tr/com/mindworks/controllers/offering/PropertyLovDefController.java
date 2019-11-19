package tr.com.mindworks.controllers.offering;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;
import tr.com.mindworks.annotations.SpringFlowScoped;
import tr.com.mindworks.controllers.BaseController;
import tr.com.mindworks.model.TCustomerContact;
import tr.com.mindworks.model.TPropertyLov;
import tr.com.mindworks.model.TPropertyLovDef;
import tr.com.mindworks.services.PropertyService;

@Component("propertyLovDefController")
@SpringFlowScoped
@SessionScope
public class PropertyLovDefController extends BaseController {

	@Autowired
	private Provider<PropertyService> propertyService;
	@Getter
	@Setter
	private TPropertyLovDef propertyLovDef;
	@Getter
	@Setter
	private List<TPropertyLovDef> propertyLovDefList;

	@Getter
	@Setter
	private TPropertyLov propertyLov;
	@Getter
	@Setter
	private List<TPropertyLov> propertyLovList;

	@PostConstruct
	public void initPropertyLovDefList() {
		propertyLovDefList = propertyService.get().findAllPropertyLovDef();
	}

	public void initializeDetailPropertyLovDef() {
		FacesContext context = FacesContext.getCurrentInstance();
		String propertyLovDefId = context.getExternalContext().getRequestParameterMap().get("propertyLovDefId");
		if (propertyLovDefId == null || "".equals(propertyLovDefId)) {
			jsfMessageUtil.addInfoMessage("property bulunamadı.");
		} else {
			propertyLovDef = propertyService.get().findPropertyLovDefById(Integer.parseInt(propertyLovDefId));
			if (propertyLovDef.getTPropertyLovList() != null) {
				propertyLovList = propertyLovDef.getTPropertyLovList();
			}
			propertyLov = new TPropertyLov();
		}
	}

	public void initializeCreatePropertyLovDef() {
		propertyLovDef = new TPropertyLovDef();
	}

	public String savePropertyLovDef() {
		try {

			propertyService.get().savePropertyLovDef(propertyLovDef);
			jsfMessageUtil.addInfoMessage("Özellik Seçim Listesi Kaydedildi. :)");
			propertyLov = new TPropertyLov();
			return "propertyLovDefSaved";
		} catch (Exception exception) {
			jsfMessageUtil.handleException("Özellik Seçim Listesi Kaydedilemedi.!!!", exception);
			return null;
		}
	}

	public void deletePropertyLovDef(TPropertyLovDef propertyLovDef) {
		propertyService.get().deletePropertyLovDef(propertyLovDef.getId());
		propertyLovDefList = propertyService.get().findAllPropertyLovDef();
	}

	public void deletePropertyLov(TPropertyLov propertyLov) {
		propertyService.get().deletePropertyLov(propertyLov.getId());
		propertyLovList = propertyService.get().findAllPropertyLovByDefId(propertyLovDef.getId());
	}

	public void savePropertyLov(ActionEvent actionEvent) {
		propertyLov.setPropertyLovDefId(propertyLovDef);
		propertyService.get().savePropertyLov(propertyLov);

		propertyLov = new TPropertyLov();
		propertyLovList = propertyService.get().findAllPropertyLovByDefId(propertyLovDef.getId());
	}
}

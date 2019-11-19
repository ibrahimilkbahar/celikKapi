package tr.com.mindworks.controllers.customer;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;
import tr.com.mindworks.annotations.SpringFlowScoped;
import tr.com.mindworks.controllers.BaseController;
import tr.com.mindworks.model.TCity;
import tr.com.mindworks.model.TCountry;
import tr.com.mindworks.model.TCustomer;
import tr.com.mindworks.model.TCustomerAddress;
import tr.com.mindworks.model.TCustomerContact;
import tr.com.mindworks.model.TDistrict;
import tr.com.mindworks.services.CustomerService;


@Component("customerDetailController")
@SpringFlowScoped
@SessionScope
public class CustomerDetailController extends BaseController
{
    @Autowired
    private Provider<CustomerService> customerService;



    @Getter
    @Setter
    private TCustomer customer;

    
    
    @Getter
    @Setter
    private TCustomerAddress newCustomerAddress;
    @Getter
    @Setter
    private List<TDistrict> districtList;
    @Getter
    @Setter
    private List<TCity> cityList;
    @Getter
    @Setter
    private List<TCountry> countryList;
    @Getter
    @Setter
    private Integer countryId,cityId,districtId,motherlandId;
    @Getter
    @Setter
    private List<TCustomerAddress> customerAddresses;
    
    
    
    @Getter
    @Setter
    private TCustomerContact newCustomerContact;
    @Getter
    @Setter
    private List<TCustomerContact> customerContacts;
    
    
    
    public void initializeCreateCustomer()
    {
    	countryList = customerService.get().findAllCountry();
    	newCustomerAddress = new TCustomerAddress();
    	newCustomerContact = new TCustomerContact();
    	customer = new TCustomer();
    }
    public void onCountryChange(final AjaxBehaviorEvent event) 
    {
    	cityList = customerService.get().findCitiesByCountryId(countryId);    	
    }
    public void onCityChange(final AjaxBehaviorEvent event) 
    {
    	districtList = customerService.get().findDistrictsByCityId(cityId);
    }
     
    public void initializeDetailCustomer()
    {
    	countryList = customerService.get().findAllCountry();   	
    	
    	FacesContext context = FacesContext.getCurrentInstance();
        String customerId = context.getExternalContext().getRequestParameterMap().get("customerId");
    	if(customerId==null || "".equals(customerId)) 
    	{
    		jsfMessageUtil.addInfoMessage("Müşteri bulunamadı.");
    	}
    	else 
    	{
    		customer = customerService.get().findCustomerById(Integer.parseInt(customerId));
    		customerContacts = customerService.get().findAllCustomerContacts(customer);
    		customerAddresses = customerService.get().findAllCustomerAddresses(customer);
        	newCustomerAddress = new TCustomerAddress();
        	newCustomerContact = new TCustomerContact();
    	}
    	
    }
    
    public void saveContact(ActionEvent actionEvent) 
    {
    	newCustomerContact.setCustomerId(customer);    	
    	customerService.get().saveCustomerContact(newCustomerContact);
    	
    	newCustomerContact = new TCustomerContact();
    	customerContacts = customerService.get().findAllCustomerContacts(customer);
    }
    
    public void deleteCustomerContact(TCustomerContact customerContact) {
    	customerService.get().deleteCustomerContact(customerContact.getId());
    	customerContacts = customerService.get().findAllCustomerContacts(customer);
    }
    
    public void saveAddress(ActionEvent actionEvent) 
    {
    	newCustomerAddress.setCustomerId(customer);
    	newCustomerAddress.setDistrictId(new TDistrict(districtId));
    	customerService.get().saveCustomerAddress(newCustomerAddress);
    	
    	newCustomerAddress = new TCustomerAddress();
    	customerAddresses = customerService.get().findAllCustomerAddresses(customer);
    }
    public void deleteCustomerAddress(TCustomerAddress customerAddress) {
    	customerService.get().deleteCustomerAddress(customerAddress.getId());
    	customerAddresses = customerService.get().findAllCustomerAddresses(customer);
    }
    
    public String saveCustomer()
    {
        try
        {
            customerService.get().saveCustomer(customer);
            jsfMessageUtil.addInfoMessage("Müşteri Kaydedildi. :)");
            return "customerSaved";
        }
        catch (Exception exception)
        {
            jsfMessageUtil.handleException("Müşteri Kaydedilemedi.!!!", exception);
            return null;
        }
    }
}

package tr.com.mindworks.services;

import java.util.List;

import tr.com.mindworks.model.TCity;
import tr.com.mindworks.model.TCountry;
import tr.com.mindworks.model.TCustomer;
import tr.com.mindworks.model.TCustomerAddress;
import tr.com.mindworks.model.TCustomerContact;
import tr.com.mindworks.model.TDistrict;


public interface CustomerService
{
	List<TCustomer> findCustomerByName(String name);
	List<TCustomer> findAll();
    void saveCustomer(TCustomer customer);
	void deleteCustomer(Integer customerId);
	TCustomer findCustomerById(Integer customerId);
	
    
	List<TCountry> findAllCountry();
	List<TCity> findCitiesByCountryId(Integer countryId);
	List<TDistrict> findDistrictsByCityId(Integer cityId);
	
	
	List<TCustomerAddress> findAllCustomerAddresses(TCustomer customer);
	void saveCustomerAddress(TCustomerAddress newCustomerAddress);
	void deleteCustomerAddress(Integer customerAddressId);
	
	
	List<TCustomerContact> findAllCustomerContacts(TCustomer customer);
	void saveCustomerContact(TCustomerContact newCustomerContact);
	void deleteCustomerContact(Integer customerContactId);
	


}

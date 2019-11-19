package tr.com.mindworks.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.mindworks.dao.CustomerAddressRepository;
import tr.com.mindworks.dao.CustomerContactRepository;
import tr.com.mindworks.dao.CustomerRepository;
import tr.com.mindworks.model.TCity;
import tr.com.mindworks.model.TCountry;
import tr.com.mindworks.model.TCustomer;
import tr.com.mindworks.model.TCustomerAddress;
import tr.com.mindworks.model.TCustomerContact;
import tr.com.mindworks.model.TDistrict;
import tr.com.mindworks.services.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService, Serializable {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerContactRepository customerContactRepository;
	
	@Autowired
	private CustomerAddressRepository customerAddressRepository;
	
	
	//#########################Customer####################
	@Override
	public List<TCustomer> findCustomerByName(String name) {
		return customerRepository.findByFullname(name);
	}
	
	@Override
	@Transactional
	public void saveCustomer(TCustomer customer) {
		customerRepository.saveAndFlush(customer);
	}

	@Override
	public List<TCustomer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public TCustomer findCustomerById(Integer customerId) {
		return customerRepository.findOne(customerId);
	}
	

	@Override
	public void deleteCustomer(Integer customerId) {
		customerRepository.delete(customerId);		
	}
	
	
	
	//#########################Customer Address####################
	@Override
	public List<TCountry> findAllCountry() {
		return customerAddressRepository.findAllCountry();
	}

	@Override
	public List<TCity> findCitiesByCountryId(Integer countryId) {
		return customerAddressRepository.findCityByCountryId(countryId);
	}

	@Override
	public List<TDistrict> findDistrictsByCityId(Integer cityId) {
		return customerAddressRepository.findDistrictByCityId(cityId);
	}

	@Override
	public List<TCustomerAddress> findAllCustomerAddresses(TCustomer customer) {
		return customerAddressRepository.findAllCustomerAddressByCustomerId(customer.getId());
	}

	@Override
	public void saveCustomerAddress(TCustomerAddress newCustomerAddress) {
		customerAddressRepository.save(newCustomerAddress);
		
	}

	@Override
	public void deleteCustomerAddress(Integer customerAddressId) {
		customerAddressRepository.delete(customerAddressId);
	}




	//#########################Customer Contacts####################
	@Override
	public void saveCustomerContact(TCustomerContact newCustomerContact) {
		customerContactRepository.save(newCustomerContact);
	}

	@Override
	public List<TCustomerContact> findAllCustomerContacts(TCustomer customer) {
		return customerContactRepository.findAllCustomerContactsByCustomerId(customer.getId());
	}
	
	@Override
	public void deleteCustomerContact(Integer customerContactId) {
		customerContactRepository.delete(customerContactId);
	}

}

package com.driver.services.impl;

import com.driver.exceptions.AdminNotPresentException;
import com.driver.exceptions.CountryNotFoundException;
import com.driver.exceptions.ServiceProviderNotFoundException;
import com.driver.model.Admin;
import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Character.isLowerCase;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin register(String username, String password) {
        Admin admin = new Admin(username, password);
        adminRepository1.save(admin);
        return admin;
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName) throws AdminNotPresentException {
        Optional<Admin> admin = adminRepository1.findById(adminId);
        if(!admin.isPresent()){
            throw new AdminNotPresentException("Admin not Registered");
        }
        ServiceProvider serviceProvider = new ServiceProvider(providerName);
        serviceProvider.setAdmin(admin.get());

        Admin Admin1 = admin.get();
        List<ServiceProvider> serviceProviderList = Admin1.getServiceProviders();
        serviceProviderList.add(serviceProvider);
        Admin1.setServiceProviders(serviceProviderList);

        return Admin1;
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{
        if(countryName.equals(countryName.toLowerCase())){
            countryName = countryName.toUpperCase();
        }

        if(!CountryName.values().equals(countryName)){
            throw new CountryNotFoundException("Country not found");
        }
        Country country = new Country(countryName);
        Optional<ServiceProvider> serviceProvider = serviceProviderRepository1.findById(serviceProviderId);
        if(!serviceProvider.isPresent()){
            throw new ServiceProviderNotFoundException("Service Provider not found");
        }
        List<Country> countryList = serviceProvider.get().getCountrys();
        countryList.add(country);
        serviceProvider.get().setCountrys(countryList);

        return serviceProvider.get();
    }
}

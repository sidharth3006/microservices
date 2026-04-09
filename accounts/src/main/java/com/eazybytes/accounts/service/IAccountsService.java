package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAccountsService {
    /**
     *
     * @param customerDto - CustomerDTO Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - Input Mobile number
     * @return Accounts Details based on a given mobileNumber
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto - CustomerDto object
     * @return boolean indicating if the update of Account details is successful or not
     *
     */
     boolean updateAccount(CustomerDto customerDto);


    /**
     *
     * @param customerDto - CustomerDto object
     * @return boolean indicating if the deletion of Account  is successful or not
     *
     */
    boolean deleteAccount(String mobileNumber);

}

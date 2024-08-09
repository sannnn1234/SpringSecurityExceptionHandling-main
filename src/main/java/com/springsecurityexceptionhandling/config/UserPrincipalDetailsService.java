package com.springsecurityexceptionhandling.config;

import com.springsecurityexceptionhandling.entity.Employee;
import com.springsecurityexceptionhandling.repos.EmployeeCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private final EmployeeCrudRepo empDetails;

    @Autowired
    private UserPrincipalDetailsService(EmployeeCrudRepo empDetails){
        this.empDetails = empDetails;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee uesrDetails = empDetails.findByUsername(username);
        LoginPrinciple loginPrinciple= new LoginPrinciple(uesrDetails);
        if (uesrDetails == null) {
            throw new UsernameNotFoundException("No user found");
        }
        return loginPrinciple;
    }
}

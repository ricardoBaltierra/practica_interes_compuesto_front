/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicascloud.baselinefront.service;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import practicascloud.baselinefront.dominio.CalculateRequest;
/**
 *
 * @author JavaRevolutions
 */
import practicascloud.baselinefront.dominio.ResumeInvestment;
@Service
public class ServiceSismos implements Serializable {
    @Autowired
    RestTemplate restTemplate;
    
    public ResumeInvestment getResumeInvestment(CalculateRequest calculateRequest) throws Exception {
    	ResumeInvestment resumeInvestment = restTemplate.postForObject("http://localhost:8082/compundInterest/calculate", calculateRequest, ResumeInvestment.class);
    	return resumeInvestment;
    }
}

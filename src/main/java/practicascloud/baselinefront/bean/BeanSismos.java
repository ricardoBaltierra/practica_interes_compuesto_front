package practicascloud.baselinefront.bean;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import practicascloud.baselinefront.dominio.CalculateRequest;
import practicascloud.baselinefront.dominio.ResumeInvestment;
import practicascloud.baselinefront.service.ServiceSismos;

@Named(value = "beanSismos")
@SessionScoped
public class BeanSismos implements Serializable {
    @Autowired
    private ServiceSismos serviceSismos;    

	private Double initialInvestment = Double.valueOf(0);
	private Double annualContribution = Double.valueOf(0);
	private Double investmentIncrease = Double.valueOf(0);
	private Integer investmentYears = Integer.valueOf(0);
	private Double investmentReturn = Double.valueOf(0);
	private ResumeInvestment resume = new ResumeInvestment();
	
	public String calculateInvestment() {
		CalculateRequest calculateRequest = new CalculateRequest();
		calculateRequest.setInitialInvestment(initialInvestment);
		calculateRequest.setAnnualContribution(annualContribution);
		calculateRequest.setInvestmentIncrease(investmentIncrease);
		calculateRequest.setInvestmentYears(investmentYears);
		calculateRequest.setInvestmentReturn(investmentReturn);
		
		try {
			resume = serviceSismos.getResumeInvestment(calculateRequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index.faces";
	}

	public Double getInitialInvestment() {
		return initialInvestment;
	}

	public void setInitialInvestment(Double initialInvestment) {
		this.initialInvestment = initialInvestment;
	}

	public Double getAnnualContribution() {
		return annualContribution;
	}

	public void setAnnualContribution(Double annualContribution) {
		this.annualContribution = annualContribution;
	}

	public Double getInvestmentIncrease() {
		return investmentIncrease;
	}

	public void setInvestmentIncrease(Double investmentIncrease) {
		this.investmentIncrease = investmentIncrease;
	}

	public Integer getInvestmentYears() {
		return investmentYears;
	}

	public void setInvestmentYears(Integer investmentYears) {
		this.investmentYears = investmentYears;
	}

	public Double getInvestmentReturn() {
		return investmentReturn;
	}

	public void setInvestmentReturn(Double investmentReturn) {
		this.investmentReturn = investmentReturn;
	}

	public ResumeInvestment getResume() {
		return resume;
	}

	public void setResume(ResumeInvestment resume) {
		this.resume = resume;
	}
	
	
	
	
}

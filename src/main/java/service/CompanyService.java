package service;

import dto.CompanyRequest;
import dto.CompanyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.springBootLesson.entity.Company;
import repository.CompanyRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<CompanyResponse> getAllCompanies(){
        List<CompanyResponse> companyResponses = new ArrayList<>();
        for(Company company: companyRepository.findAll()){
            companyResponses.add(mapToResponse(company));
        }
        return companyResponses;
    }
    public CompanyResponse getCompanyById(Long companyId){
        Company company = companyRepository.findById(companyId).get();
    return mapToResponse(company);
    }
    public CompanyResponse saveCompany(CompanyRequest request){
       Company company = mapToEntity(request);
        companyRepository.save(company);
        return mapToResponse(company);
    }
    public CompanyResponse updateCompany (Long id,CompanyRequest request){
        Company company = companyRepository.findById(id).get();
        Company company1= mapToEntity(request);
        company.setCompanyName(request.getCompanyName());
        company.setLocatedCountry(request.getLocatedCountry());
        company.setDirectorName(request.getDirectorName());
        companyRepository.save(company);
        return mapToResponse(company);
    }
    public void deleteCompany(Long companyId){
        companyRepository.deleteById(companyId);
    }
    public Company mapToEntity(CompanyRequest request){
        Company company = new Company();
                company.setCompanyName(request.getCompanyName());
                company.setLocatedCountry(request.getLocatedCountry());
                company.setDirectorName(request.getDirectorName());
                company.setLocalDate(LocalDate.now());
                return company;
    }

    public CompanyResponse mapToResponse(Company company) {
        CompanyResponse companyResponse = new CompanyResponse();
       companyResponse.setId(company.getId());
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        companyResponse.setDirectorName(company.getDirectorName());
        companyResponse.setLocalDate(company.getLocalDate());
        return companyResponse;

    }

}

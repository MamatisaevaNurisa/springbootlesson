package controller;

import dto.CompanyRequest;
import dto.CompanyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.CompanyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;
   @GetMapping
    public List<CompanyResponse> getAll(){
        return companyService.getAllCompanies();
    }
   @GetMapping("{id}")
    public CompanyResponse getCompany(@PathVariable("id")Long id){
       return companyService.getCompanyById(id);
    }
    public CompanyResponse save (@RequestBody CompanyRequest companyRequest){
       return companyService.saveCompany(companyRequest);
    }
    public CompanyResponse update (@PathVariable("id") Long id,@RequestBody CompanyRequest request){
       return companyService.updateCompany(id,request);
    }
    public String delete(@PathVariable("id") Long id){
       companyService.deleteCompany(id);
       return "Seccessfully deleted Company with id:"+id;
    }
}

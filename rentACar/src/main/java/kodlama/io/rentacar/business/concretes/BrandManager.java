package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.requests.CreateBrandRequest;
import kodlama.io.rentacar.business.requests.UpdateBrandRequest;
import kodlama.io.rentacar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentacar.business.responses.GetByIdBrandResponce;
import kodlama.io.rentacar.core.utilities.mappers.ModdelMappersService;
import kodlama.io.rentacar.dataAccess.abtracts.BrandRepository;
import kodlama.io.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModdelMappersService moddelMappersService;
// @AllArgsConstructor diyerek privatelerin constructorlerini otomatik hale gertirdik.


    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
/*
        for (Brand brand : brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);
        }
        yukaridaki kod yerine asagidaki kod yazilmali setler arttikca donusturme zorlasicak asagida
         5 satirda donusturme yapildi
        */
        List<GetAllBrandsResponse>brandsResponses=brands.stream()
                .map(brand -> this.moddelMappersService.forResponce()
                .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }



    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand =this.moddelMappersService.forRequest().map(createBrandRequest,Brand.class);
        //yukarida createbrandrequest in tum verilerini brand e dönusturduk


    }
    @Override
    public GetByIdBrandResponce getById(int id) {
       Brand brand= this.brandRepository.findById(id).orElseThrow();
       GetByIdBrandResponce getByIdBrandResponce=this.moddelMappersService.forResponce()
               .map(brand,GetByIdBrandResponce.class);
        return getByIdBrandResponce;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand =this.moddelMappersService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }
}

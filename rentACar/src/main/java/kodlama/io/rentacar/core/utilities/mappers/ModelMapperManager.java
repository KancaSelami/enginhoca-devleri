package kodlama.io.rentacar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements  ModdelMappersService{
    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponce() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        //yukarida strategy .loose dememiz gecsek mapleme yap yani hepsini istemedigimde kizma demek
        //Ambiguignored true demek alt alta siniflarda paketlerde ayni isimlendirmeler oldugunda
        //ben orayi duzenleyecegim sen karisma hata verme demek.
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
//strategy.standart demek bana tum bilgilerini ver demek
        return this.modelMapper;

    }
}

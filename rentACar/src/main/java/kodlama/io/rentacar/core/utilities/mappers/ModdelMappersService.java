package kodlama.io.rentacar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModdelMappersService {
    ModelMapper forResponce();
    ModelMapper forRequest();
}

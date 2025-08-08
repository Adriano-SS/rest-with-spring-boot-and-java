package github.com.Adriano_SS.mapper;

import github.com.Adriano_SS.data.dto.PersonDTOV2;
import github.com.Adriano_SS.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonV2Mapper {
    public PersonDTOV2 convertEntityToPersonDTOV2(Person entity) {
        PersonDTOV2 dto_v2 = new PersonDTOV2();
        dto_v2.setId(entity.getId());
        dto_v2.setFirstName(entity.getFirstName());
        dto_v2.setLastName(entity.getLastName());
        dto_v2.setAddress(entity.getAddress());
        dto_v2.setGender(entity.getGender());
        dto_v2.setBirthday(new Date());
        return dto_v2;
    }
    public Person convertPersonDTOV2ToEntity(PersonDTOV2 personDTOV2) {
        Person entity = new Person();
        entity.setId(personDTOV2.getId());
        entity.setFirstName(personDTOV2.getFirstName());
        entity.setLastName(personDTOV2.getLastName());
        entity.setAddress(personDTOV2.getAddress());
        entity.setGender(personDTOV2.getGender());
        //entity.setBirthday(new Date());
        return entity;
    }
}

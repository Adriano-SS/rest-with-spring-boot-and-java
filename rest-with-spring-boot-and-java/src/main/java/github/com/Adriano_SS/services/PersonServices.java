package github.com.Adriano_SS.services;

import github.com.Adriano_SS.data.dto.PersonDTO;
import github.com.Adriano_SS.data.dto.PersonDTOV2;
import github.com.Adriano_SS.exceptions.ResourceNotFoundException;
import github.com.Adriano_SS.mapper.PersonV2Mapper;
import github.com.Adriano_SS.model.Person;
import github.com.Adriano_SS.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static github.com.Adriano_SS.mapper.ObjectMapper.parseListObjects;
import static github.com.Adriano_SS.mapper.ObjectMapper.parseObject;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonV2Mapper personV2Mapper;

    public List<PersonDTO> findAll() {
        logger.info("Finding all people!");

        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for Id: " + id));
        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating one person!");
        var entity = parseObject(personDTO, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createv2(PersonDTOV2 personDTOV2) {
        logger.info("Creating one person in V2!");

        var entity = personV2Mapper.convertPersonDTOV2ToEntity(personDTOV2);
        return personV2Mapper.convertEntityToPersonDTOV2(repository.save(entity));
    }

    public PersonDTO update(PersonDTO personDTO) {
        logger.info("Updating one person!");
        Person entity = repository.findById(personDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for id: " + personDTO.getId()));

        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setAddress(personDTO.getAddress());
        entity.setGender(personDTO.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No records found for id: " + id);
        }
    }

}

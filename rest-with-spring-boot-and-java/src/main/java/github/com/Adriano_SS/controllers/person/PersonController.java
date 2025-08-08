package github.com.Adriano_SS.controllers.person;

import github.com.Adriano_SS.data.dto.PersonDTO;
import github.com.Adriano_SS.data.dto.PersonDTOV2;
import github.com.Adriano_SS.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices services;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findById(@PathVariable("id") Long id) {
        var person = services.findById(id);
        person.setBirthDay(new Date());
        //person.setPhoneNumber("+55 83 99965-7476");
        person.setPhoneNumber("");
        //person.setLastName(null);
        person.setSensitiveData("Senha");
        return person;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll() {
        return services.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE, //deve estar explícito para o Swagger
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return services.create(personDTO);
    }

    @PostMapping(
            value = "/v2",
            consumes = MediaType.APPLICATION_JSON_VALUE, //deve estar explícito para o Swagger
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 create(@RequestBody PersonDTOV2 personDTOV2) {
        return services.createv2(personDTOV2);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE, //deve estar explícito para o Swagger
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO update(@RequestBody PersonDTO personDTO) {
        return services.update(personDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
}

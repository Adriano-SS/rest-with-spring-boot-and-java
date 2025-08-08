package github.com.Adriano_SS.repositories;

import github.com.Adriano_SS.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { }

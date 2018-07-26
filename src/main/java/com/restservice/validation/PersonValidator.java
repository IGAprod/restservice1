package com.restservice.validation;

//import co.bbenson.apierror.ApiErrorCod
import com.restservice.model.Person;
import com.restservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
//public class PersonValidator implements Validator{
public class PersonValidator {

 //   private PersonRepository productRepository;

 //   @Autowired
 //   public PersonValidator(PersonRepository personRepository) {
 //       this.personRepository = personRepository;
  //  }

   // @Override
  //  public boolean supports(Class<?> clazz) {
 //       return Person.class.isAssignableFrom(clazz);
 //   }

  //  @Override
  //  public void validate(Object target, Errors errors) {
  //      Person personCreateRequest = (Person) target;
//
  //      if (personRepository.exists(personCreateRequest.toProduct())) {
  //          errors.reject(ApiErrorCode.ALREADY_EXISTS.getCode());
  //      }
 //   }

}

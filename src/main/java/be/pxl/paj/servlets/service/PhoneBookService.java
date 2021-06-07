package be.pxl.paj.servlets.service;

import be.pxl.paj.servlets.domain.Phonebook;
import be.pxl.paj.servlets.repository.PhonebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookService {
    @Autowired
    private PhonebookRepository phonebookRepository;

    public void addPhoneNumber(Phonebook phonebook){
        phonebookRepository.save(phonebook);
    }

    public List<Phonebook> getPhoneNumbers(){
        return phonebookRepository.findAll();
    }
}

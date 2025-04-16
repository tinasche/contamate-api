package com.madner.contamate_backend.contact;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Page<Contact> getContacts(int pageNumber, int pageSize) {
        return contactRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("name")));
    }

    public Contact getContact(String id) {
        return contactRepository.findById(id).orElseThrow();
    }

    public Contact addContact(CreateContactDto createContactDto) {
        var contact = new Contact();
        contact.setActive(true);
        contact.setAddress(createContactDto.address());
        contact.setName(createContactDto.name());
        contact.setEmail(createContactDto.email());
        contact.setPhone(createContactDto.phone());
        contact.setTitle(createContactDto.title());

        return contactRepository.save(contact);
    }

    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public boolean deleteContact(String id) {
        var contact = getContact(id);
        contactRepository.delete(contact);
        return true;
    }

    public void toggleActive(String id) {
        var contact = getContact(id);
        contact.setActive(!contact.getActive());
    }
}

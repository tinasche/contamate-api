package com.madner.contamate_backend.contact;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("contacts")
public class ContactResource {

    private final ContactService contactService;

    @GetMapping
    public ResponseEntity<?> getContacts(@RequestParam int pageNumber, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok().body(contactService.getContacts(pageNumber, pageSize));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getContact(@PathVariable(required = true) String id) {
        return ResponseEntity.ok().body(contactService.getContact(id));
    }

    @PostMapping
    public ResponseEntity<?> addContact(@RequestBody CreateContactDto createContactDto){
        return ResponseEntity.created(URI.create("/contactId")).body(contactService.addContact(createContactDto));
    }

    @PutMapping
    public ResponseEntity<?> updateContact(@RequestBody Contact contact){
        return ResponseEntity.ok().body(contactService.updateContact(contact));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteContact(@PathVariable(required = true) String id) {
        return ResponseEntity.ok().body(contactService.deleteContact(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> toggleActive(@PathVariable(required = true) String id) {
        contactService.toggleActive(id);
        return ResponseEntity.noContent().build();
    }



}

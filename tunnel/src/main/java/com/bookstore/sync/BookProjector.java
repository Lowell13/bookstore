package com.bookstore.sync;

import com.bookstore.entity.Book;
import com.bookstore.query.BookReadRepository;

public class BookProjector {

    BookReadRepository bookReadRepository = new BookReadRepository();

    public BookProjector(BookReadRepository bookReadRepository) {
        this.bookReadRepository = bookReadRepository;
    }

    public void project(Book book) {
        BookContact bookContact = Optional.ofNullable(
                readRepository.getBookContact(book.getBookid()))
                .orElse(new BookContact());
        Map<String, Set<Contact>> contactByType = new HashMap<>();
        for (Contact contact : book.getContacts()) {
            Set<Contact> contacts = Optional.ofNullable(
                    contactByType.get(contact.getType()))
                    .orElse(new HashSet<>());
            contacts.add(contact);
            contactByType.put(contact.getType(), contacts);
        }
        bookContact.setContactByType(contactByType);
        readRepository.addBookContact(book.getBookid(), bookContact);

        BookAddress bookAddress = Optional.ofNullable(
                readRepository.getBookAddress(book.getBookid()))
                .orElse(new BookAddress());
        Map<String, Set<Address>> addressByRegion = new HashMap<>();
        for (Address address : book.getAddresses()) {
            Set<Address> addresses = Optional.ofNullable(
                    addressByRegion.get(address.getState()))
                    .orElse(new HashSet<>());
            addresses.add(address);
            addressByRegion.put(address.getState(), addresses);
        }
        bookAddress.setAddressByRegion(addressByRegion);
        readRepository.addBookAddress(book.getBookid(), bookAddress);
    }
}

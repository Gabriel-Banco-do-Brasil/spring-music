package com.example.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.music.exception.NotFoundException;
import com.example.music.model.Customer;
import com.example.music.repository.CustomerRepository;
import com.example.music.repository.MusicPlaylistRepository;

@Repository
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MusicPlaylistRepository musicPlaylistRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) throws NotFoundException {
        Optional<Customer> findById = customerRepository.findById(id);

        if (findById.isEmpty()) {
            throw new NotFoundException();
        }

        return findById.get();

    }

    public void createByEntity(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateByEntity(Customer customer) throws NotFoundException {

        Optional<Customer> findById = customerRepository.findById(customer.getId());

        if (findById.isEmpty()) {
            throw new NotFoundException();
        }

        Customer customerToUpdate = findById.get();
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setAge(customer.getAge());
        customerToUpdate.setPlaylist(customer.getPlaylist());
        customerRepository.save(customerToUpdate);

    }

    public void deleteById(Long id) throws NotFoundException {
        Optional<Customer> findById = customerRepository.findById(id);

        if (findById.isEmpty()) {
            throw new NotFoundException();
        }

        // remove playlists from it's repository and remove customer from it's repository
        findById.get().getPlaylist().forEach(playlist -> musicPlaylistRepository.delete(playlist));
        customerRepository.delete(findById.get());

    }
    
}

package org.example.oenskesky.Services;

import org.example.oenskesky.Repositories.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishServices {

    @Autowired
    private WishRepository wishRepository;


}

package com.kirillsoklakov.app.services;

import com.kirillsoklakov.app.model.User;

public interface UserService {
    public User create(User user);
    public User getCurrentUser();
}

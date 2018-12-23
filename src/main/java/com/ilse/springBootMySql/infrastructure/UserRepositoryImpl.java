//package com.ilse.springBootMySql.infrastructure;
//
//import com.ilse.springBootMySql.domain.user.User;
//import com.ilse.springBootMySql.domain.user.UserRepository;
//
//public class UserRepositoryImpl implements UserRepository {
//
//   private UserCrudRepository userCrudRepository;
//
//    public UserRepositoryImpl(UserCrudRepository userCrudRepository) {
//        this.userCrudRepository = userCrudRepository;
//
//    }
//
//    public User updateUserByName(String name) {
//        Iterable<User> allUsers = this.userCrudRepository.findAll();
//        allUsers.forEach(user -> {
//            if (user.getName().equals(name)) {
//                user.setName(name);
//            }
//        });
//
//        return null;
//    }
//
//}

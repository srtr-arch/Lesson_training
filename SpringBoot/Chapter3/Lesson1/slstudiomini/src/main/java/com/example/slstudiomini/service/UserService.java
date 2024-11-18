package com.example.slstudiomini.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.slstudiomini.exception.MyUniqueContstraintViolationException;
import com.example.slstudiomini.model.Authority;
import com.example.slstudiomini.model.User;
import com.example.slstudiomini.repository.AuthorityRepository;
import com.example.slstudiomini.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAllUsers() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User>user = cq.from(User.class);

        cq.select(user);

        Join<User,Authority>authorities = user.join("authorities");
        cq.where(cb.and(cb.equal(authorities.get("authority"), "ROLE_USER"),cb.equal(user.get("enabled"),true)));
        

        return entityManager.createQuery(cq).getResultList();
    }
    // public List<User> findAllUsers() {
    //     return userRepository.findAll();
    // }

    public User findUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User Not Found With id = " + id));
    }

    public User addEnableStudentAndHashPassword(User user){


        User uniqueUser = userRepository.findByUsername(user.getUsername());
        try{if(uniqueUser!=null){
            throw new MyUniqueContstraintViolationException("既に存在するユーザーです");
        }
    }catch(MyUniqueContstraintViolationException ex){ex.getMessage();}

        user.setEnabled(true);
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String hashPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(hashPassword);

        Authority authority = authorityRepository.findByAuthority("ROLE_USER")
        .orElseThrow(()->new EntityNotFoundException());

            user.setAuthorities(Set.of(authority));

            return userRepository.save(user);
    }

    // @Transactional
    // public User save(User user) {
    //     if (user != null) {
    //         user.setCreatedAt(LocalDateTime.now());
    //         userRepository.save(user);
    //     }
    //     return user;
    // }

    // @Transactional
    // public User update(User updateUser) {
    //     User user = findUserById(updateUser.getId());
    //     user.setName(updateUser.getName());
    //     user.setDescription(updateUser.getDescription());
    //     user.setUpdatedAt(LocalDateTime.now());

    //     return userRepository.save(user);
    // }

    // @Transactional
    // public void delete(User deletedUser) {
    //     User user = findUserById(deletedUser.getId());
    //     // コースの削除はdeletedAtに日付を入れる
    //     user.setDeletedAt(LocalDateTime.now());
    //     user.getLessons().forEach(lesson -> lesson.setDeletedAt(LocalDateTime.now()));
    //     userRepository.save(user);
    // }
}
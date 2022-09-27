package com.example.yujublog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(nullable = false, length = 1000, unique = true)
    private String username;

//    @Column(nullable = false, length = 1000)
    private String password;

//    @Column(nullable = false, length = 500)
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleType role;

//    private String provider;
//
//    private String providerId;

    @CreationTimestamp
    private Timestamp createDate;


}
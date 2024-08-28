package com.sparta.schedulemanagement2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 100)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fixdate;

    @OneToMany(mappedBy = "user")
    private List<UserSchedule> user_schedules;
}

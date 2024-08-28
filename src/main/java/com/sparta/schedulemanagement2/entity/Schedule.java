package com.sparta.schedulemanagement2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", nullable = false, length = 20)
    private String username;

    @Column(name="title", nullable = false, length = 45)
    private String title;

    @Column(name="contents", nullable=true,length=500)
    private String contents;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable=false)
    private Date date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fix_date;

    @OneToMany(mappedBy="schedule")
    private List<Comment> comments;


}

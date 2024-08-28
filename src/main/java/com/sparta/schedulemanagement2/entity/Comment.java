package com.sparta.schedulemanagement2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name="comment")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="comment", length=500)
    private String comment;

    @Column(name="username", nullable=false, length=20)
    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fix_date;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;
}

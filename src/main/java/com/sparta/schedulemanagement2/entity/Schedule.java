package com.sparta.schedulemanagement2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name="fix_date")
    private Date fixdate;

    @OneToMany(mappedBy="schedule",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // 페이지 출력시 무한 순환문제를 해결하기 위함
    private List<Comment> comments;


}

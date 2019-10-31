package com.geekbrains.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    @SequenceGenerator(name = "comment_generator", sequenceName = "comment_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private LocalDate createDate;

    @Column(nullable = false)
    private LocalTime createTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "comment_author_FK"))
    private User author;

}

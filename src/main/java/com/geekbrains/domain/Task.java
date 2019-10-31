package com.geekbrains.domain;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_generator")
    @SequenceGenerator(name = "task_generator", sequenceName = "task_id_seq", allocationSize = 1)
    private Long   id;

    @Column(nullable = false)
    private String title;

    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "task_author_FK"))
    private User author;

    @ManyToMany
    @JoinTable(name = "task_inspector",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "task_inspector_task_FK"),
            inverseForeignKey = @ForeignKey(name = "task_inspector_inspector_FK"))
    private List<User> inspectors;

    @ManyToMany
    @JoinTable(name = "task_doer",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "task_doer_task_FK"),
            inverseForeignKey = @ForeignKey(name = "task_doer_doer_FK"))
    private List<User> doers;

    @Column(name = "create_date", nullable = false)
    private LocalDate createDate = LocalDate.now();

    @Column(name = "target_date")
    private LocalDate targetDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id", foreignKey = @ForeignKey(name = "task_project_FK"))
    private Project project;

    @ManyToMany
    @JoinTable(name = "task_comment",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"),
            foreignKey = @ForeignKey(name = "task_comment_task_FK"),
            inverseForeignKey = @ForeignKey(name = "task_comment_comment_FK"))
    private List<Comment> comments;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TaskStatus status = TaskStatus.CREATED;

}

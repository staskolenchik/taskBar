package com.geekbrains.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
    @SequenceGenerator(name = "project_generator", sequenceName = "project_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany
    @JoinTable(name = "project_user",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "project_user_project_FK"),
            inverseForeignKey = @ForeignKey(name = "project_user_user_FK"))
    private List<User> members;

    @ManyToOne(optional = false)
    @JoinColumn(name = "supervisor_id", foreignKey = @ForeignKey(name = "project_supervisor_FK"))
    private User supervisor;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

}

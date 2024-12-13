package com.zeabay.themovie.common.core.entity;

import com.zeabay.themovie.common.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7972048506823549678L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;


    //TODO eklenecek
    //@CreationTimestamp
    //@Column(name = "created_date")
    //private LocalDateTime createdDate;
    //@UpdateTimestamp
    //@Column(name = "last_modified_date")
    //private LocalDateTime lastModifiedDate;
    //@CreatedBy
    //@Column(name = "created_user")
    //private String createdUser;
    //@LastModifiedBy
    //@Column(name = "last_modified_user")
    //private String lastModifiedUser;
}
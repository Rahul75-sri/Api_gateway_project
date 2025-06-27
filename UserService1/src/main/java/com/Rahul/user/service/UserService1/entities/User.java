package com.Rahul.user.service.UserService1.entities;

import com.Rahul.user.service.UserService1.utils.UUIDValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.aggregation.VariableOperators;

@Entity
@Table(name = "micro_users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)", updatable = false, nullable = false)
    private String id;

    @Column(name = "name", nullable = false, length = 255)  // Changed to lowercase
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters")
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 255)  // Changed to lowercase
    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email is required")
    private String email;

    @Column(name = "about", columnDefinition = "TEXT")  // Changed to lowercase
    @Size(max = 1000, message = "About section cannot exceed 1000 characters")
    private String about;

    @Builder.Default
    @Transient
    private List<Rating> ratings = new ArrayList<>();
}

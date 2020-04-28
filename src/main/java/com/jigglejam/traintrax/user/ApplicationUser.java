package com.jigglejam.traintrax.user;

import com.jigglejam.traintrax.profile.TrainerProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "application_user")
public
class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String email;
    private String password;
    private String role;
    private Boolean isEnabled;
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "applicationUser", cascade = CascadeType.ALL)
    private TrainerProfile trainerProfile;
}

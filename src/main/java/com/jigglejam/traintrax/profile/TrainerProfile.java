package com.jigglejam.traintrax.profile;

import com.jigglejam.traintrax.user.ApplicationUser;
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
@Table(name = "trainer_profile")
public class TrainerProfile {

    @Id
    private Long id;

    private String aceNumber;

    @OneToOne
    @MapsId
    private ApplicationUser applicationUser;
}

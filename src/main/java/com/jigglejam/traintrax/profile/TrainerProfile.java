package com.jigglejam.traintrax.profile;

import com.jigglejam.traintrax.user.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trainer_profile")
public class TrainerProfile {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String aceNumber;
    private LocalDateTime certificationExpirationDate;
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<CleintProfile> clients;
    @OneToOne
    @MapsId
    private ApplicationUser applicationUser;
}

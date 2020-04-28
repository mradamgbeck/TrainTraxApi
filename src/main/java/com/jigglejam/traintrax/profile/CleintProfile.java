package com.jigglejam.traintrax.profile;

import com.jigglejam.traintrax.user.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client_profile")
public class CleintProfile {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sex;
    private LocalDateTime birthday;
    private int heightInCentimeters;
    private String history;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private TrainerProfile trainer;
    @OneToOne
    @MapsId
    private ApplicationUser applicationUser;
}

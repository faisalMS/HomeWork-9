package com.example.movieratingsoftware.Modle;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Movie {

    @Id
    @NotNull(message = "Cannot be null")
    @Size(min = 3, message = "Length more than 3")
    @Column(unique = true)
    private Integer id;
    @NotEmpty(message = "Cannot be null")
    @Size(min = 2, message = "Length more than 3")
    @Column(unique = true)
    private String name;
    @NotEmpty(message = "Cannot be null")
    @Pattern(regexp = "(Drama|Action|Comedy)")
    private String genre;
    @NotNull(message = "Cannot be null")
    @Positive(message = "Has to be a number")
    @Min(value = 1,message = "rating has to be between 1 and 5")
    @Max(value = 5,message = "rating can be a maximum of 5")
    private Integer rating;
    @NotNull(message = "Cannot be null")
    @Positive(message = "Has to be a number")
    @Size(min = 60, message = "I must be more than 60")
    private Integer duration;
    @NotEmpty(message = "Has to be date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDate launchDate;
}

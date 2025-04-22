package sesi.petvita.pet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import sesi.petvita.pet.breed.*;
import sesi.petvita.pet.gender.Gender;
import sesi.petvita.pet.species.Species;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PetRequestDTO(
        @NotBlank
        @Size(min = 3, max = 50)
        String name,

        @Min(0)
        int age,

        @Size(min = 3, max = 50)
        String personalizatedSpecies,

        @Size(min = 3, max = 50)
        String personalizedBreed,

        @NotNull
        Species speciespet,

        @NotNull
        Gender gender,

        BirdBreed birdBreed,
        CatBreed catBreed,
        DogBreed dogBreed,
        FishBreed fishBreed,
        RabbitBreed rabbitBreed,
        ReptileBreed reptileBreed,
        RodentBreed rodentBreed
) {}


package sesi.petvita.consultation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import sesi.petvita.consultation.consultation.ConsultationStatus;
import sesi.petvita.pet.model.PetModel;
import sesi.petvita.user.model.UserModel;
import sesi.petvita.veterinary.especiality.EspecialityEnum;
import sesi.petvita.veterinary.model.VeterinaryModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class ConsultationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataConsulta;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaConsulta;

    @Enumerated(EnumType.STRING)
    private EspecialityEnum especialidade;

    @Enumerated(EnumType.STRING)
    private ConsultationStatus status;

    private String motivo;

    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetModel pet;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserModel usuario;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private VeterinaryModel veterinario;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}

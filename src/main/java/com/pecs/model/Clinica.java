package com.pecs.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.pecs.utils.Enum.TipoClinica;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clinica", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Clinica extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "documento", length = 20, nullable = false, unique = true)
    private String documento;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(name = "email", columnDefinition = "VARCHAR(150) UNIQUE DEFAULT NULL")
    private String email;

    @Column(name = "tipo_clinica", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoClinica tipoClinica;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinica", fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<Telefone>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinica", fetch = FetchType.LAZY)
    private List<Consulta> consultas = new ArrayList<Consulta>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinica", fetch = FetchType.LAZY)
    private List<Diagnostico> diagnosticos = new ArrayList<Diagnostico>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinica", fetch = FetchType.LAZY)
    private List<Prescricao> prescricoes = new ArrayList<Prescricao>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinica", fetch = FetchType.LAZY)
    private List<AtividadePaciente> atividadePacientes = new ArrayList<AtividadePaciente>();

}

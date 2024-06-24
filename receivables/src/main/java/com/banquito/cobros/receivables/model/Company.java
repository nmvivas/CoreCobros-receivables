package com.banquito.cobros.receivables.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long id;

    @Column(name = "RUC", length = 20, nullable = false)
    private String ruc;

    @Column(name = "COMPANY_NAME", length = 100, nullable = false)
    private String companyName;

    @Column(name = "LEGAL_REPRESENTATIVE", length = 100, nullable = false)
    private String legalRepresentative;

    @Column(name = "SRI_AUTHORIZATION", nullable = false)
    private Boolean sriAuthorization;

    @Column(name = "CONTRACT_ACCEPTANCE", nullable = false)
    private Boolean contractAcceptance;

    @Column(name = "CLIENT_COMPANY", length = 50, nullable = false)
    private String clientEmail;

    public Company(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Company other = (Company) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}

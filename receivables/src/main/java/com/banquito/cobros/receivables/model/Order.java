package com.banquito.cobros.receivables.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"ORDER\"")
public class Order implements Serializable {

    @Id
    @Column(name = "ORDER_ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "RECEIVABLE_ID", nullable = false)
    private Receivables receivables;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "DUE_DATE", nullable = false)
    private LocalDate dueDate;

    @Column(name = "TOTAL_AMOUNT", precision = 17, scale = 2, nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "RECORDS", length = 100, nullable = false)
    private String records;

    @Column(name = "DESCRIPTION", length = 100, nullable = false)
    private String description;

    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;

    public Order(Long id) {
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
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}

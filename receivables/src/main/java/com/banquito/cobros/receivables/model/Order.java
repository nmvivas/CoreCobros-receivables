package com.banquito.cobros.receivables.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "\"ORDER\"")
public class Order implements Serializable {

    @Id
    @Column(name = "ORDER_ID", nullable = false)
    private Long id;

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

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "RECEIVABLE_ID", nullable = false)
    private Receivables receivables;

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

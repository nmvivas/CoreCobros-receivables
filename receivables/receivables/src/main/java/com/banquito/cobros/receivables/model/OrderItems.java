package com.banquito.cobros.receivables.model;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEMS_ID", nullable = false)
    private Long id;
    @Column(name = "ORDER_ID", nullable = false)
    private Long orderId;
    @Column(name = "DEBTOR_NAME", length = 100, nullable = false)
    private String debtorName;
    @Column(name = "IDENTIFICATION_TYPE", length = 3, nullable = false)
    private String identificationType;
    @Column(name = "IDENTIFICATION", length = 20, nullable = false)
    private String identification;
    @Column(name = "DEBIT_ACCOUNT", length = 20, nullable = false)
    private String debitAccount;
    @Column(name = "OWED_AMOUNT", precision = 17, scale = 2, nullable = false)
    private BigDecimal owedAmount;
    @Column(name = "COUNTERPART", length = 10, nullable = false)
    private String counterpart;
    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID", insertable = false, updatable = false)
    private Order order;

    @OneToMany(mappedBy = "orderItems")
    private List<PaymentRecord> paymentRecords;

    public OrderItems(Long id) {
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
        OrderItems other = (OrderItems) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}

package com.banquito.cobros.receivables.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "PAYMENT_RECORD")
public class PaymentRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_RECORD_ID", nullable = false)
    private Long id;

    @Column(name = "ORDER_ITEM_ID", nullable = false)
    private Long orderItemId;

    @Column(name = "PAYMENT_TYPE", length = 3, nullable = false)
    private String paymentType;

    @Column(name = "OWED_PAYMENT", precision = 17, scale = 2, nullable = false)
    private BigDecimal owedPayment;

    @Column(name = "PAYMENT_DATE", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "OUTSTANDING_BALANCE", precision = 17, scale = 2, nullable = false)
    private BigDecimal outstandingBalance;

    @Column(name = "CHANNEL", length = 3, nullable = false)
    private String channel;

    @ManyToOne
    @JoinColumn(name = "ORDER_ITEM_ID", referencedColumnName = "ORDER_ITEM_ID", insertable = false, updatable = false)
    private OrderItem orderItem;

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
        PaymentRecord other = (PaymentRecord) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}

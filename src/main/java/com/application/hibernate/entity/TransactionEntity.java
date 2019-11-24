package com.application.hibernate.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transaction", schema = "cachedb", catalog = "")
public class TransactionEntity {
    private int id;
    private int number;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NUMBER", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return id == that.id &&
                number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }
}

package com.example.autowerkstatt.autowerkstatt.dao.Impl;

import com.example.autowerkstatt.autowerkstatt.dao.CustomerDao;
import com.example.autowerkstatt.autowerkstatt.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final JdbcTemplate jdbc;

    public CustomerDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static final RowMapper<Customer> MAPPER = new RowMapper<>() {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Customer(
                    rs.getLong("customer_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address")
            );
        }
    };

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer ORDER BY customer_id";
        return jdbc.query(sql, MAPPER);
    }

    @Override
    public Optional<Customer> findById(int id) {
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        return jdbc.query(sql, MAPPER, id)
                .stream()
                .findFirst();
    }

    @Override
    public int save(Customer c) {
        String sql = """
            INSERT INTO customer (first_name, last_name, phone, email, address)
            VALUES (?, ?, ?, ?, ?)
            """;
        return jdbc.update(sql,
                c.getFirstName(),
                c.getLastName(),
                c.getPhone(),
                c.getEmail(),
                c.getAddress()
        );
    }

    @Override
    public int update(Customer c) {
        String sql = """
            UPDATE customer
               SET first_name = ?, last_name = ?, phone = ?, email = ?, address = ?
             WHERE customer_id = ?
            """;
        return jdbc.update(sql,
                c.getFirstName(),
                c.getLastName(),
                c.getPhone(),
                c.getEmail(),
                c.getAddress(),
                c.getCustomerId()
        );
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM customer WHERE customer_id = ?";
        return jdbc.update(sql, id);
    }
}
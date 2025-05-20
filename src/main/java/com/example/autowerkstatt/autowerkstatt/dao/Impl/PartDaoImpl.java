package com.example.autowerkstatt.autowerkstatt.dao.Impl;

import com.example.autowerkstatt.autowerkstatt.dao.PartDao;
import com.example.autowerkstatt.autowerkstatt.model.Part;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PartDaoImpl implements PartDao {

    private final JdbcTemplate jdbc;

    public PartDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static final RowMapper<Part> MAPPER = new RowMapper<>() {
        @Override
        public Part mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Part(
                    rs.getLong("part_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getBigDecimal("unit_cost"),
                    rs.getInt("stock_qty")
            );
        }
    };

    @Override
    public List<Part> findAll() {
        String sql = "SELECT * FROM part ORDER BY part_id";
        return jdbc.query(sql, MAPPER);
    }

    @Override
    public Optional<Part> findById(int id) {
        String sql = "SELECT * FROM part WHERE part_id = ?";
        return jdbc.query(sql, MAPPER, id)
                .stream()
                .findFirst();
    }

    @Override
    public int save(Part part) {
        String sql = """
            INSERT INTO part (name, description, unit_cost, stock_qty)
            VALUES (?, ?, ?, ?)
            """;
        return jdbc.update(sql,
                part.getName(),
                part.getDescription(),
                part.getUnitCost(),
                part.getStockQty()
        );
    }

    @Override
    public int update(int id, Part part) {
        String sql = """
            UPDATE part
               SET name = ?, description = ?, unit_cost = ?, stock_qty = ?
             WHERE part_id = ?
            """;
        return jdbc.update(sql,
                part.getName(),
                part.getDescription(),
                part.getUnitCost(),
                part.getStockQty(),
                id
        );
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM part WHERE customer_id = ?";
        return jdbc.update(sql, id);
    }
}

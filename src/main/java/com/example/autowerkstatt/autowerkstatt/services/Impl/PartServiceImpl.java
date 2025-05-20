package com.example.autowerkstatt.autowerkstatt.services.Impl;

import com.example.autowerkstatt.autowerkstatt.dao.Impl.PartDaoImpl;
import com.example.autowerkstatt.autowerkstatt.model.Part;
import com.example.autowerkstatt.autowerkstatt.services.PartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartServiceImpl implements PartService {

    private final PartDaoImpl partDao;

    public PartServiceImpl(PartDaoImpl partDao) {
        this.partDao = partDao;
    }

    @Override
    public List<Part> findAll() {
        return partDao.findAll();
    }

    @Override
    public Optional<Part> findById(int id) {
        return partDao.findById(id);
    }

    @Override
    public void save(Part part) {
        partDao.save(part);
    }

    @Override
    public void delete(int id) {
        partDao.deleteById(id);
    }

    @Override
    public void update(int id, Part part) {
        partDao.update(id, part);
    }
}

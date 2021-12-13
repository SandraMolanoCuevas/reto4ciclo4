package com.ciclo4.reto3.repository.crud;

import com.ciclo4.reto3.model.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LaptopCrudRepository extends MongoRepository<Laptop, String> {
    public static List<Laptop> findByPriceLessThanEqual(double precio) {
        return null;
    }

    // Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public static List<Laptop> findByDescriptionLike(String description) {
        return null;
    }

    public Optional<Laptop> findTopByOrderByIdDesc();

    public Optional<Laptop> findById(int id);

}

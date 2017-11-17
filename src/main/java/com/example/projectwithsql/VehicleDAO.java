package com.example.projectwithsql;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
/**
 * Data Access Object - provide some specific data operations without exposing details of the database
 * Access data for the Greeting entity.
 * Repository annotation allows Spring to find and configure the DAO.
 * Transactional annonation will cause Spring to call begin() and commit()
 * at the start/end of the method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class VehicleDAO {

        //PersistenceContext annotation used to specify there is a database source.
        // EntityManager is used to create and remove persistent entity instances,
        // to find entities by their primary key, and to query over entities.
        @PersistenceContext
        private EntityManager entityManager;
        //Insert greeting into the database.
        public void create(Vehicle vehicle) {
            entityManager.persist(vehicle);
            return;
        }
        //Return the greeting with the passed-in id.
        public Vehicle getById(int id) {
            return entityManager.find(Vehicle.class, id);
        }

        public Vehicle update(Vehicle vehicle){
            return entityManager.merge(vehicle);
        }

        public void delete(Vehicle vehicle){
            entityManager.remove(vehicle);
            return;
        }
    }

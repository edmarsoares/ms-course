package com.hrworker.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrworker.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}

package com.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrworker.model.Worker;
import com.hrworker.repositorys.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResources.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;

//	@GetMapping("configs")
//	public ResponseEntity<Void> getConfigs(){
//		logger.info("Config=" + testConfig);
//		
//		return ResponseEntity.noContent().build();
//	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		Worker worker = repository.findById(id).get();
		
		return ResponseEntity.ok(worker);
	}
}

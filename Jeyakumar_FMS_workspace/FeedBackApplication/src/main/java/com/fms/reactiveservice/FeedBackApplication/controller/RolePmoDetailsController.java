package com.fms.reactiveservice.FeedBackApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.reactiveservice.FeedBackApplication.Service.RolePmoDetailService;
import com.fms.reactiveservice.FeedBackApplication.entity.PmoDetails;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/admin/role")
public class RolePmoDetailsController {
	
	@Autowired
	private RolePmoDetailService rolePmoDetailService;
	
	@PostMapping("/createRole")
	public Mono<PmoDetails> createRoles(@RequestBody PmoDetails pmoDetail) {
		return rolePmoDetailService.createRoles(pmoDetail);
	}
	
	@GetMapping("/allRoles")
	public Flux<PmoDetails> getAllPmoDetails() {
		return rolePmoDetailService.getAllPmoDetails();
	}

	
	@GetMapping("/{employeeId}")
	public Mono<ResponseEntity<PmoDetails>> getEmployeeId(@PathVariable Integer employeeId) {
		return rolePmoDetailService.getEmployeeId(employeeId).map(fetchId -> ResponseEntity.ok(fetchId))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/updateRole/{employeeId}")
	public Mono<ResponseEntity<PmoDetails>> updatePmodetailByEmpId(@RequestBody PmoDetails pmoDetail,@PathVariable Integer employeeId) {
		return rolePmoDetailService.updatePmodetailByEmpId(pmoDetail,employeeId).map(updateRole -> new ResponseEntity<>(updateRole, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	
	@DeleteMapping("/deleteEmpId/{employeeId}")
	public Mono<ResponseEntity<Void>> deleteEmpId(@PathVariable Integer employeeId){
		return rolePmoDetailService.deleteEmpId(employeeId);
	}
	
}
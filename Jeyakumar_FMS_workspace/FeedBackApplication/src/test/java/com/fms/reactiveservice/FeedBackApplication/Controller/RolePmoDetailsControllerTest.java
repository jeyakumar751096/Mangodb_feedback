package com.fms.reactiveservice.FeedBackApplication.Controller;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.fms.reactiveservice.FeedBackApplication.Constant.FeedBackConstant;
import com.fms.reactiveservice.FeedBackApplication.Service.RolePmoDetailService;
import com.fms.reactiveservice.FeedBackApplication.entity.PmoDetails;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
//@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
public class RolePmoDetailsControllerTest {
	
	@Autowired
	WebTestClient webTestClient;


	@Autowired
	RolePmoDetailService adminEmpRoleRepo;
	
	@Test
	public void getAllRole_approach1() {
	webTestClient.get().uri(FeedBackConstant.ADMIN_ROLE_ENDPOINT.concat("/allRoles"))
	.exchange()
	.expectStatus().isOk()
	.expectHeader().contentType(MediaType.APPLICATION_JSON)
	.expectBodyList(PmoDetails.class)
	.hasSize(3).consumeWith((response) -> {
	List<PmoDetails> roles= response.getResponseBody();
	roles.forEach((r) -> {
	assertTrue(r.getEmployeeId() !=null);
	});
	});

}
	
	
	@Test
	public void getAllRoleTest() {
	Flux<PmoDetails> pmoRoleFlux=webTestClient.get().uri(FeedBackConstant.ADMIN_ROLE_ENDPOINT.concat("/allRoles"))
	.exchange()
	.expectStatus().isOk()
	.expectHeader().contentType(MediaType.APPLICATION_JSON)
	.returnResult(PmoDetails.class)
	.getResponseBody();

	StepVerifier.create(pmoRoleFlux.log("Value from pmo Employee Role :::"))
	.expectNextCount(3)
	.verifyComplete();
	}
	
	@Test
	public void getEmployeeIdTest() {
	webTestClient.get().uri(FeedBackConstant.ADMIN_ROLE_ENDPOINT.concat("/{employeeId}"),751096)
	.exchange()
	.expectStatus().isOk()
	.expectBody()
	.jsonPath("$.empEmailId", "jairadha007@gmail.cm");
	}
	
	@Test
	public void getCreateEmpRole() {
	PmoDetails role=new PmoDetails(4,7,"FifthEmployee","LastEmployee","kumar@gmail.com","POC");
	webTestClient.post().uri(FeedBackConstant.ADMIN_ROLE_ENDPOINT.concat("/createRole"))
	.contentType(MediaType.APPLICATION_JSON)
	.body(Mono.just(role), PmoDetails.class)
	.exchange()
	.expectStatus().isCreated()
	.expectBody()
	.jsonPath("$.employeeId").isNotEmpty()
	.jsonPath("$.empEmailId").isEqualTo("kumar@gmail.com");

	}
	
	@Test
	public void getDeleteEmpId() {
	webTestClient.delete().uri(FeedBackConstant.ADMIN_ROLE_ENDPOINT.concat("/deleteEmpId/{employeeId}"),7)
	.accept(MediaType.APPLICATION_JSON)
	.exchange()
	.expectStatus().isOk()
	.expectBody(Void.class);
	}
	
	@Test
	public void getUpdatePmodetailByEmpId() {
		PmoDetails role=new PmoDetails(2,5,"jeyakumar","radhakrishnan","751096@cognizant.com","ADMIN");

	webTestClient.put().uri(FeedBackConstant.ADMIN_ROLE_ENDPOINT.concat("/updateRole/{employeeId}"),5)
	.contentType(MediaType.APPLICATION_JSON)
	.accept(MediaType.APPLICATION_JSON)
	.body(Mono.just(role),PmoDetails.class)
	.exchange()
	.expectStatus().isOk()
	.expectBody()
	.jsonPath("$.empRole", "ADMIN");
	}

	@Test
	public void getUpdatePmodetailByEmpId_NOTFOUND() {
		PmoDetails role=new PmoDetails(2,5,"jeyakumar","radhakrishnan","751096@cognizant.com","ADMIN");

	webTestClient.put().uri(FeedBackConstant.ADMIN_ROLE_ENDPOINT.concat("/updateRole/{employeeId}"),16)
	.contentType(MediaType.APPLICATION_JSON)
	.accept(MediaType.APPLICATION_JSON)
	.body(Mono.just(role),PmoDetails.class)
	.exchange()
	.expectStatus().isNotFound();

	}
}

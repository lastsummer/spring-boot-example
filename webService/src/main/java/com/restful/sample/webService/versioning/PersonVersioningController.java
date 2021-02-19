package com.restful.sample.webService.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	@GetMapping(value="/v1/person", produces={ "application/json" })
	public Person1 personV1() {
		return new Person1("SummerWang");
	}
	
	@GetMapping(value="/v2/person", produces={ "application/json" })
	public Person2 personV2() {
		return new Person2(new Name("Summer","Name"));
	}
	
	@GetMapping(value="/person/param", params="version=1", produces={ "application/json" })
	public Person1 paramV1() {
		return new Person1("SummerWang");
	}
	
	@GetMapping(value="/person/param", params="version=2", produces={ "application/json" })
	public Person2 paramV2() {
		return new Person2(new Name("Summer","Name"));
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=1", produces={ "application/json" })
	public Person1 headerV1() {
		return new Person1("SummerWang");
	}
	
	@GetMapping(value="/person/header", params="X-API-VERSION=2", produces={ "application/json" })
	public Person2 headerV2() {
		return new Person2(new Name("Summer","Name"));
	}
	
	@GetMapping(value="/person/produce", produces={ "application/vnd.company.app-v1+json" })
	public Person1 produceV1() {
		return new Person1("SummerWang");
	}
	
	@GetMapping(value="/person/produce", produces={ "application/vnd.company.app-v2+json" })
	public Person2 produceV2() {
		return new Person2(new Name("Summer","Name"));
	}
}

package com.cts.budgettracker.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="profile-service", url="http://localhost:9100")
public interface ProfileServiceClient {
	
	@GetMapping("/profiles/{ahId}/exists")
	boolean existsByAccountHolderId(@PathVariable("ahId") Long achId);
}

package com.mds.shema.Feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("USERS-MANAGER")
public interface UserClientFeign {
      @GetMapping("/users/info")
      public User getUserDetails(@RequestParam("username") String username);
}

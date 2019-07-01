package com.mds.shema.Feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="COMPONENTS")
public interface AppClientFeign {
	@RequestMapping(method = RequestMethod.GET, value = "/applications")
    List<Apps> getApps();

	@RequestMapping(method = RequestMethod.GET, value = "/applications/History")
    List<AppsHistory> getAppsHistory(@RequestParam("username") String username);
	
	@RequestMapping(method = RequestMethod.GET, value = "/menus/{application}")
    List<Menu> getAppMenus(@PathVariable("application") String application);
}

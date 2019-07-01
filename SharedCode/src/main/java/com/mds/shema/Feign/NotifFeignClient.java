package com.mds.shema.Feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mds.shema.dto.NotificationDTO;

@FeignClient("Notification")
public interface NotifFeignClient {

	public static final String NOTIF = "notif";

	@GetMapping(NOTIF)
	List<NotificationDTO> getAll();
	
	@PutMapping(NOTIF)
	Boolean setNotif(@RequestBody NotificationDTO notif,@RequestParam String principal);
	
	@PostMapping(NOTIF)
	NotificationDTO createNotif(@RequestBody NotificationDTO notif,@RequestParam String principal);
	
	@DeleteMapping(NOTIF)
	Boolean deleteNotif(@RequestParam Long notifID,@RequestParam String principal);
	
}

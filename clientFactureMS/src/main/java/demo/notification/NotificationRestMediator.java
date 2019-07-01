package demo.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mds.shema.Feign.NotifFeignClient;
import com.mds.shema.dto.NotificationDTO;

@RestController
@RequestMapping(NotificationRestMediator.API)
public class NotificationRestMediator {
	public static final String API ="notif";
	
	@Autowired
	private NotifFeignClient notifFeignClient;
	
	@GetMapping
	List<NotificationDTO> getAllNotifications(){
		return notifFeignClient.getAll();
	}
}

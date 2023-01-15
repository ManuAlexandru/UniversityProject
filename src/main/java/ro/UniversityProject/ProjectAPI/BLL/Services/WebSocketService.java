package ro.UniversityProject.ProjectAPI.BLL.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class WebSocketService {
    @Autowired
    private final SimpMessagingTemplate simpMessage;


    public WebSocketService(final SimpMessagingTemplate productViewModel){
        this.simpMessage=productViewModel;
    }

    @PostMapping(value="api/Products")
    public void sendMessage(String topicSuffix){
        simpMessage.convertAndSend("/topic/"+topicSuffix,"Default message from our WS service");
    }
}

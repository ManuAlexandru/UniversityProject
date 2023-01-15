package ro.UniversityProject.ProjectAPI.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.ProductViewModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WebSocketController {
    @Autowired
    SimpMessagingTemplate template;

    @PostMapping(value = "/api/send")
    public void sendMessage(@RequestBody ProductViewModel productViewModel) {

        //Sending the message to kafka topic queue
        // kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
        template.convertAndSend("/topic/"+productViewModel.userId, productViewModel);
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/user")
    public ProductViewModel broadcastMessage(@Payload ProductViewModel product) {
        //Sending this message to all the subscribers
        return product;
    }
}
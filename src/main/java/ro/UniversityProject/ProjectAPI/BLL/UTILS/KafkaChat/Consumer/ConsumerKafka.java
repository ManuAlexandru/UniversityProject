package ro.UniversityProject.ProjectAPI.BLL.UTILS.KafkaChat.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.BLL.UTILS.KafkaChat.Constants.KafkaConstants;
import ro.UniversityProject.ProjectAPI.BLL.UTILS.KafkaChat.Model.KafkaModel;

@Service
public class ConsumerKafka {

    @Payload(required = false)
@KafkaListener(topics= KafkaConstants.KAFKA_TOPIC, groupId = KafkaConstants.GROUP_ID)
    public void listenToTopic(KafkaModel model){
        System.out.println("Message received is "+ model.toString());
    }
}

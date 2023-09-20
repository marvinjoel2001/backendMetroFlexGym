package com.api.metroflex_backend.services;


import com.api.metroflex_backend.models.NotificationModel;
import com.api.metroflex_backend.repositories.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class NotificationService {
    @Autowired
    INotificationRepository notificationRepository;
    public ArrayList<NotificationModel> getNotifications(){
        return (ArrayList<NotificationModel>) notificationRepository.findAll();
    }
    public NotificationModel saveNotification(NotificationModel notification){return notificationRepository.save(notification);}
    public Optional<NotificationModel> getById(Long id){return notificationRepository.findById(id);}
    public NotificationModel updateById(NotificationModel request, Long id){
        Optional<NotificationModel> optionalNotification = notificationRepository.findById(id);
        if (optionalNotification.isPresent()){
            NotificationModel notification = optionalNotification.get();
            if (request.getMessage() !=null){
                notification.setMessage(request.getMessage());
            }
            if(request.getSentDate() !=null){
                notification.setSentDate(request.getSentDate());
            }
            if(request.getUser() !=null){
                notification.setUser(request.getUser());
            }
            return notificationRepository.save(notification);
        }else {
            throw new IllegalArgumentException("Notification no encontrada");
        }
    }
    public Boolean deleteNotification(Long id){
        try {
            notificationRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

}

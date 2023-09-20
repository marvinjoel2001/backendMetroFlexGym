package com.api.metroflex_backend.controllers;


import com.api.metroflex_backend.models.NotificationModel;
import com.api.metroflex_backend.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @GetMapping
    public ArrayList<NotificationModel> getNotification(){return this.notificationService.getNotifications();}
    @PostMapping
    public NotificationModel setNotification(@RequestBody NotificationModel notification){return this.notificationService.saveNotification(notification);}
    @GetMapping(path = "/{id}")
    public Optional<NotificationModel> getNotificationById(@PathVariable("id") Long id){
        return this.notificationService.getById(id);
    }
    @PutMapping
    public NotificationModel updateNotificationById(@RequestBody NotificationModel request, @PathVariable("id") Long id){return this.notificationService.updateById(request,id);}
    @DeleteMapping(path = "/{id}")
    public String deleteNotification(@PathVariable Long id){
        boolean ok = this.notificationService.deleteNotification(id);
        if (ok){
            return "Notification with id "+id+" deleted ";
        }else{
            return "Ups we have a problem";
        }


    }
}

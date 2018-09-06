package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT="Tasks: Once a day e-mail";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

//    @Scheduled(fixedDelay = 30000)
    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail(){
        long size=taskRepository.count();

        simpleEmailService.sendScheduledMail(new Mail(adminConfig.getAdminMail(),SUBJECT,
                "Currently in database you got: "+size+" "+ taskOrTasks(size),null));
    }

    private String taskOrTasks(long size){
        if (size==1){
            return "task";
        }else {
            return "tasks";
        }
    }
}

package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message){

        List<String> functionality=new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context=new Context();
        context.setVariable("message",message);
        context.setVariable("tasks_url","https://lukaszrogacz.github.io/");
        context.setVariable("button","Visit website");
        context.setVariable("admin_config",adminConfig);
        context.setVariable("goodbye","Best Regards,\nElton John");
        context.setVariable("company",companyConfig.getCompanyName()+"\n" +
                "email: "+companyConfig.getCompanyEmail()+"\n" +
                "company phone: "+companyConfig.getCompanyPhone());
        context.setVariable("show_button",true);
        context.setVariable("is_friend",false);
        context.setVariable("application_functionality",functionality);
        return  templateEngine.process("mail/created-trello-card-mail",context);

    }

    public String buildScheduledEmail(String message){

        List<Task> tasksListRepository;
        tasksListRepository=taskRepository.findAll();

        List<String> tasksList;
        tasksList=tasksListRepository.stream()
        .map(n->n.getTitle()).collect(Collectors.toList());


        Context context=new Context();
        context.setVariable("preview","Task briefing");
        context.setVariable("message",message);
        context.setVariable("tasks_url","https://lukaszrogacz.github.io/");
        context.setVariable("button","Visit website");
        context.setVariable("admin_config",adminConfig);
        context.setVariable("goodbye","Best Regards," +
                "\nElton John");
        context.setVariable("company",companyConfig.getCompanyName()+"\n" +
                "email: "+companyConfig.getCompanyEmail()+"\n" +
                "company phone: "+companyConfig.getCompanyPhone());
        context.setVariable("show_button",true);
        context.setVariable("is_friend",false);
        context.setVariable("tasks_list",tasksList);
        return  templateEngine.process("mail/scheduled-mail",context);

    }
}

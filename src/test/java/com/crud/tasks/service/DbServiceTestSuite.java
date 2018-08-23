package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository repository;

    @Test
    public void shouldGetAllTasks() {
        //Given
        when(repository.findAll()).thenReturn(new ArrayList<>());
        //When
        List<Task> allTasks=dbService.getAllTasks();
        //Then
        Assert.assertNotNull(allTasks);
        Assert.assertEquals(0,allTasks.size());
    }

    @Test
    public void shouldSaveTask() {
        //Given
        Task task1=new Task(1L,"test1","desc1");
        Task task2=new Task(3L,"test2","desc2");
        List<Task> allTasks=new ArrayList<>();
        allTasks.add(task1);
        allTasks.add(task2);

        when(repository.save(task1)).thenReturn(task1);
        when(repository.save(task2)).thenReturn(task2);
        when(repository.findAll()).thenReturn(allTasks);
        //When
        List<Task> theTasks=dbService.getAllTasks();
        //Then
        Assert.assertEquals(2,theTasks.size());
    }

    @Test
    public void shouldGetTask() {
        //Given
        Task task=new Task(3L,"test","desc");
        when(repository.findOne(3L)).thenReturn(task);
        //When
        Task theTask=dbService.getTask(3L).orElse(null);
        //Then
        Assert.assertEquals(task,theTask);
    }

    @Test
    public void shouldDeleteTask() {
        //Given
        Task task1=new Task(1L,"test1","desc1");
        Task task2=new Task(3L,"test2","desc2");
        List<Task> allTasks=new ArrayList<>();
        allTasks.add(task2);

        when(repository.save(task1)).thenReturn(task1);
        when(repository.save(task2)).thenReturn(task2);
        when(repository.findAll()).thenReturn(allTasks);

        //When
        dbService.deleteTask(1L);
        List<Task> theTasks=dbService.getAllTasks();
        //Then
        Assert.assertEquals(1,theTasks.size());
    }
}
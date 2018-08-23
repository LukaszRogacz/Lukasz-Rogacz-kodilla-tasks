package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class TaskMapperTestSuite {

    TaskMapper taskMapper=new TaskMapper();

    @Test
    public void shouldMapToTaskDtoTest(){
        //Given
        Task task=new Task(2L,"task title","task content");
        TaskDto taskDtoExpected=new TaskDto(2L,"task title","task content");
        //When
        TaskDto taskDtoMapped=taskMapper.mapToTaskDto(task);
        //Then
        Assert.assertEquals(taskDtoExpected,taskDtoMapped);
    }
    @Test
    public void shouldMapToTaskTest(){
        //Given
        TaskDto taskDto=new TaskDto(2L,"task title","task content");
        Task taskExpected=new Task(2L,"task title","task content");

        //When
        Task taskMapped=taskMapper.mapToTask(taskDto);
        //Then
        Assert.assertEquals(taskExpected,taskMapped);
    }

    @Test
    public void shouldMapToTaskDtoListTest(){
        //Given
        List<Task> taskList=new ArrayList<>();
        //When
        List<TaskDto> taskDtoList=taskMapper.mapToTaskDtoList(taskList);
        //Then
        Assert.assertNotNull(taskDtoList);
        Assert.assertEquals(0,taskDtoList.size());
    }
}

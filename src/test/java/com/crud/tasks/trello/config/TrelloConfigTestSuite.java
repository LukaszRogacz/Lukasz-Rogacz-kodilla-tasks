package com.crud.tasks.trello.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void shouldGetTrelloApiEndpoint() {
        //Given && When
        String endpoint =trelloConfig.getTrelloApiEndpoint();

        //Then
        Assert.assertEquals("https://api.trello.com/1",endpoint);
    }

    @Test
    public void shouldGetTrelloAppKey() {
        //Given && When
        String appKey =trelloConfig.getTrelloAppKey();

        //Then
        Assert.assertEquals("13dcf7163e6a8a799b314589d63fb2fa",appKey);
    }

    @Test
    public void shouldGetTrelloToken() {
        //Given && When
        String appToken =trelloConfig.getTrelloToken();

        //Then
        Assert.assertEquals("f5aaf13a925c6568e51a1ebec6bd96bd4bf41330c050c8a8363c99363b316cd5",appToken);
    }

    @Test
    public void shouldGetTrelloUsername() {
        //Given && When
        String username =trelloConfig.getTrelloUsername();

        //Then
        Assert.assertEquals("lukaszrogacz",username);
    }
}
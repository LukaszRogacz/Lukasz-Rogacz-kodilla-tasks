package com.crud.tasks.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

public class TrelloTestSuite {

    @Test
    public void should(){
        //Given
        Trello trello=new Trello(3,4);
        Trello trello2=new Trello();
        //When
        int boardId=trello.getBoard();
        int boardId2=trello2.getBoard();
        int cardId=trello.getCard();
        int cardId2=trello2.getCard();
        //Then
        Assert.assertEquals(3,boardId);
        Assert.assertEquals(0,boardId2);
        Assert.assertEquals(4,cardId);
        Assert.assertEquals(0,cardId2);
    }
}

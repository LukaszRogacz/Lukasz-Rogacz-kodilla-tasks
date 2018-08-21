package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloMapperTestSuite {

    private TrelloMapper trelloMapper=new TrelloMapper();

    @Test
    public void TrelloMapperCardTest(){
        //Given
        TrelloCardDto trelloCardDto=new TrelloCardDto("test1","desc10","top","abcd");
        TrelloCard trelloCardExpected=new TrelloCard("test1","desc10","top","abcd");
        //When
        TrelloCard trelloCardMapped=trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals(trelloCardExpected,trelloCardMapped);
    }

    @Test
    public void TrelloMapperCardDtoTest(){
        //Given
        TrelloCard trelloCard=new TrelloCard("test1","desc10","top","abcd");
        TrelloCardDto trelloCardDtoExpected=new TrelloCardDto("test1","desc10","top","abcd");
        //When
        TrelloCardDto trelloCardDtoMapped=trelloMapper.mapToCardDto(trelloCard);
        //Then
        Assert.assertEquals(trelloCardDtoExpected,trelloCardDtoMapped);
    }

    @Test
    public void TrelloMapperListTest(){
        //Given
        TrelloListDto trelloListDto=new TrelloListDto("test2","desc2",false);
        List<TrelloListDto> trelloDtoList=new ArrayList<>();
        trelloDtoList.add(trelloListDto);
        TrelloList trelloList=new TrelloList("test2","desc2",false);
        List<TrelloList> trelloListExpected=new ArrayList<>();
        trelloListExpected.add(trelloList);
        //When
        List<TrelloList> trelloListMapped=trelloMapper.mapToList(trelloDtoList);
        //Then
        Assert.assertEquals(trelloListExpected,trelloListMapped);
    }

    @Test
    public void TrelloMapperListDtoTest(){
        //Given
        TrelloList trelloList=new TrelloList("test2","desc2",false);
        List<TrelloList> trelloListOfList=new ArrayList<>();
        trelloListOfList.add(trelloList);
        TrelloListDto trelloListDto=new TrelloListDto("test2","desc2",false);
        List<TrelloListDto> trelloListDtoExpected=new ArrayList<>();
        trelloListDtoExpected.add(trelloListDto);
        //When
        List<TrelloListDto> trelloListDtoMapped=trelloMapper.mapToListDto(trelloListOfList);
        //Then
        Assert.assertEquals(trelloListDtoExpected,trelloListDtoMapped);
    }


    @Test
    public void TrelloMapperBoardTest(){
        //Given
        TrelloListDto trelloListDto=new TrelloListDto("test2","desc2",false);
        List<TrelloListDto> trelloDtoList=new ArrayList<>();
        trelloDtoList.add(trelloListDto);
        TrelloBoardDto trelloBoardDto=new TrelloBoardDto("test2","desc2",trelloDtoList);
        List<TrelloBoardDto> trelloBoardDtoList=new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);
        TrelloList trelloList=new TrelloList("test2","desc2",false);
        List<TrelloList> trelloListExpected=new ArrayList<>();
        trelloListExpected.add(trelloList);
        TrelloBoard trelloBoardExpected=new TrelloBoard("test2","desc2",trelloListExpected);
        List<TrelloBoard> trelloBoardListExpected=new ArrayList<>();
        trelloBoardListExpected.add(trelloBoardExpected);
        //When
        List<TrelloBoard> trelloBoardsMapped=trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        Assert.assertEquals(trelloBoardListExpected,trelloBoardsMapped);
    }

    @Test
    public void TrelloMapperBoardDtoTest(){
        //Given
        TrelloList trelloList=new TrelloList("test2","desc2",false);
        List<TrelloList> trelloListOfList=new ArrayList<>();
        trelloListOfList.add(trelloList);
        TrelloBoard trelloBoard=new TrelloBoard("test2","desc2",trelloListOfList);
        List<TrelloBoard> trelloBoardList=new ArrayList<>();
        trelloBoardList.add(trelloBoard);
        TrelloListDto trelloListDto=new TrelloListDto("test2","desc2",false);
        List<TrelloListDto> trelloListDtoExpected=new ArrayList<>();
        trelloListDtoExpected.add(trelloListDto);
        TrelloBoardDto trelloBoardDtoExpected=new TrelloBoardDto("test2","desc2",trelloListDtoExpected);
        List<TrelloBoardDto> trelloBoardDtoListExpected=new ArrayList<>();
        trelloBoardDtoListExpected.add(trelloBoardDtoExpected);
        //When
        List<TrelloBoardDto> trelloBoardsDtoMapped=trelloMapper.mapToBoardsDto(trelloBoardList);
        //Then
        Assert.assertEquals(trelloBoardDtoListExpected,trelloBoardsDtoMapped);
    }

}

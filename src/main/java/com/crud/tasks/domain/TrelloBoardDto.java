package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloBoardDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lists")
    private List<TrelloListDto> lists;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrelloBoardDto)) return false;
        TrelloBoardDto that = (TrelloBoardDto) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getLists(), that.getLists());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getId(), getLists());
    }
}

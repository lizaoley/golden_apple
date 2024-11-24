package com.liza.golden_apple.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrdersDTO {

    private int customerId;
    @JsonProperty("items")
    private List<Integer> items;

}

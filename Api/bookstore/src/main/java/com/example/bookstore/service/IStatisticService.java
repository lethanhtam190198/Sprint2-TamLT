package com.example.bookstore.service;

import com.example.bookstore.dto.StatisticDto;

import java.util.List;

public interface IStatisticService {
    List<StatisticDto> getSellingBookTop10(String start_date, String end_date);
}

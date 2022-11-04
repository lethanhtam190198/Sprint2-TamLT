package com.example.bookstore.service.Impl;

import com.example.bookstore.dto.StatisticDto;
import com.example.bookstore.repository.StatisticRepository;
import com.example.bookstore.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService implements IStatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    public List<StatisticDto> getSellingBookTop10(String start_date, String end_date) {
        return statisticRepository.getSellingBookTop10(start_date,end_date);
    }
}

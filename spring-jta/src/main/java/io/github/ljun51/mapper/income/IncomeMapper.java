package io.github.ljun51.mapper.income;

import io.github.ljun51.model.Income;
import org.apache.ibatis.annotations.Insert;

public interface IncomeMapper {

    @Insert("INSERT INTO INCOME(userId,amount,operateDate) VALUES(#{userId},#{amount},#{operateDate})")
    void insert(Income income);
}

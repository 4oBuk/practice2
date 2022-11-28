package com.chornobuk.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.chornobuk.entities.Fine;
import com.chornobuk.entities.FineType;
public class FineXMLParserTest {

    @Test
    public void parseFine() throws IOException {
        String xml = """
                <Fine
                    date_time= "2020-05-05 15:39:03"
                    first_name="Ivan"
                    last_name="Ivanov"
                    type="SPEEDING"
                    fine_amount="340.0"
                />
                """;
        Fine fine = new Fine(
                LocalDateTime.of(2020, 5, 5, 15, 39, 3),
                "Ivan",
                "Ivanov",
                FineType.SPEEDING,
                new BigDecimal("340.0"));
        FineXMLParser xmlParser = new FineXMLParser();
        assertEquals(fine, xmlParser.parseFine(xml));
    }
}

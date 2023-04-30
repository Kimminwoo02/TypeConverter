package com.example.typeconverter.formatter;

import com.example.typeconverter.converter.IpPortToStringConverter;
import com.example.typeconverter.converter.StringToIpPortConverter;
import com.example.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

public class FormattingConversionServiceTest {
    @Test
    void formattingConversionService(){
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        conversionService.addFormatter(new MyNumberFormatter());

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1",8080));
        

    }
}

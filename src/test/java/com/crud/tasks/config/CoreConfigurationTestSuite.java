package com.crud.tasks.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreConfigurationTestSuite {

    @Autowired
    CoreConfiguration coreConfiguration;

    @Test
    public void shouldCoverCode(){
        coreConfiguration.addArgumentResolvers(null);
        coreConfiguration.addCorsMappings(null);
        coreConfiguration.addCorsMappings(null);
        coreConfiguration.addFormatters(null);
        coreConfiguration.addInterceptors(null);
        coreConfiguration.extendMessageConverters(null);
        coreConfiguration.extendHandlerExceptionResolvers(null);
        coreConfiguration.configureViewResolvers(null);
        coreConfiguration.configurePathMatch(null);
        coreConfiguration.configureMessageConverters(null);
        coreConfiguration.configureHandlerExceptionResolvers(null);
        coreConfiguration.configureDefaultServletHandling(null);
        coreConfiguration.configureContentNegotiation(null);
        coreConfiguration.configureAsyncSupport(null);
        coreConfiguration.addViewControllers(null);
        coreConfiguration.addReturnValueHandlers(null);

    }
}

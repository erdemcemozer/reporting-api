package com.example.reportingapi.util;

import com.example.reportingapi.constants.ReportingConstants;
import org.springframework.stereotype.Component;

/**
 * @Author Erdem Ozer
 * Date: 05/11/2023
 */
@Component
public class ParamBuilder {
    public String buildApiUrl(String endpoint) {
        return ReportingConstants.TEST_URL_STRING + "/" + endpoint;
    }
}

package com.lukas.appone.servicediscovery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class ServiceDiscoveryController {


    private static final String APP_TWO_NAME = "app-two";

    @Autowired
    private UnderTheHoodServiceUriProvider uriProvider;

    @RequestMapping(value = "/service-discovery")
    public String getConfigValues() {
        URI uri = uriProvider.discoverServerUri(APP_TWO_NAME);

        StringBuilder configValues = new StringBuilder();
        configValues.append("Found URI: ")
                    .append(uri)
                    .append("<br>");
        return configValues.toString();
    }
}

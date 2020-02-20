package com.mibelhe.mbjavajib;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.microsoft.azure.AzureEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.microsoft.azure.credentials.AppServiceMSICredentials;

import com.microsoft.azure.keyvault.KeyVaultClient;
import com.microsoft.azure.keyvault.models.KeyBundle;

import java.util.HashMap;

import java.util.Map;

import java.util.Optional;



import org.springframework.core.env.ConfigurableEnvironment;

import org.springframework.core.env.MutablePropertySources;

import org.springframework.core.env.StandardEnvironment;

import org.springframework.core.io.DefaultResourceLoader;

import org.springframework.core.io.Resource;

import org.springframework.util.Assert;

import org.springframework.util.ClassUtils;



import java.util.HashMap;

import java.util.Map;

import java.util.Optional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;





import java.io.IOException;

import java.net.URISyntaxException;

import java.nio.charset.Charset;

import java.time.Instant;

import java.util.concurrent.ExecutionException;

import java.util.concurrent.Executors;

import java.util.concurrent.ScheduledExecutorService;

import com.azure.messaging.eventhubs.*;
import static java.nio.charset.StandardCharsets.UTF_8;
import com.azure.messaging.eventhubs.models.CreateBatchOptions;
import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.PartitionEvent;
import com.microsoft.azure.eventhubs.ConnectionStringBuilder;

import com.azure.core.credential.TokenCredential;

import com.azure.identity.DefaultAzureCredentialBuilder;

@RestController
public class PublishController {

	@RequestMapping(value = "/publishMessage", method = RequestMethod.GET)

	public String message(@RequestBody String name){
            return name;
	}

        @RequestMapping(value="/hello")
        @ResponseBody

        public String method9(@RequestParam("text") String txt) throws Exception {

           String msiEndpoint =  System.getenv("MSI_ENDPOINT");
           String msiSecret =  System.getenv("MSI_SECRET");
           AppServiceMSICredentials msiCredentials = new AppServiceMSICredentials(AzureEnvironment.AZURE,msiEndpoint, msiSecret);
           KeyVaultClient keyVaultClient = new KeyVaultClient(msiCredentials);
           String secret = keyVaultClient.getSecret("https://mykey.vault.azure.net/","MY-TEST-SECRET").toString();
           String key = keyVaultClient.getKey("https://mykey.vault.azure.net/","myappkey").toString();
           return "my key : "+key;

        }

}


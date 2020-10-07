package com.example.googleAtiProyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class GoogleAtiProyectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleAtiProyectApplication.class, args);
	}

	@RestController
	class HelloController{
		@GetMapping("/")
		String hello(){
			return "Spring en Gcp PADDDDRE";
		}

		@GetMapping("/crearsala")
		public void infoSala() throws IOException, InterruptedException {
/*        URL url = new URL("https://www.googleapis.com/compute/v1/projects/arboreal-stage-288722/zones/southamerica-east1-a/instances");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");*/
			String inputJson = " {\n" +
					"  \"kind\": \"compute#instance\",\n" +
					"  \"name\": \"template-2\",\n" +
					"  \"zone\": \"projects/arboreal-stage-288722/zones/southamerica-east1-a\",\n" +
					"  \"machineType\": \"projects/arboreal-stage-288722/zones/southamerica-east1-a/machineTypes/e2-standard-2\",\n" +
					"  \"displayDevice\": {\n" +
					"    \"enableDisplay\": false\n" +
					"  },\n" +
					"  \"metadata\": {\n" +
					"    \"kind\": \"compute#metadata\",\n" +
					"    \"items\": []\n" +
					"  },\n" +
					"  \"tags\": {\n" +
					"    \"items\": [\n" +
					"      \"http-server\",\n" +
					"      \"https-server\"\n" +
					"    ]\n" +
					"  },\n" +
					"  \"disks\": [\n" +
					"    {\n" +
					"      \"kind\": \"compute#attachedDisk\",\n" +
					"      \"type\": \"PERSISTENT\",\n" +
					"      \"boot\": true,\n" +
					"      \"mode\": \"READ_WRITE\",\n" +
					"      \"autoDelete\": true,\n" +
					"      \"deviceName\": \"template-1\",\n" +
					"      \"initializeParams\": {\n" +
					"        \"sourceImage\": \"projects/debian-cloud/global/images/debian-10-buster-v20200910\",\n" +
					"        \"diskType\": \"projects/arboreal-stage-288722/zones/southamerica-east1-a/diskTypes/pd-standard\",\n" +
					"        \"diskSizeGb\": \"10\",\n" +
					"        \"labels\": {}\n" +
					"      },\n" +
					"      \"diskEncryptionKey\": {}\n" +
					"    }\n" +
					"  ],\n" +
					"  \"canIpForward\": false,\n" +
					"  \"networkInterfaces\": [\n" +
					"    {\n" +
					"      \"kind\": \"compute#networkInterface\",\n" +
					"      \"subnetwork\": \"projects/arboreal-stage-288722/regions/southamerica-east1/subnetworks/default\",\n" +
					"      \"accessConfigs\": [\n" +
					"        {\n" +
					"          \"kind\": \"compute#accessConfig\",\n" +
					"          \"name\": \"External NAT\",\n" +
					"          \"type\": \"ONE_TO_ONE_NAT\",\n" +
					"          \"networkTier\": \"PREMIUM\"\n" +
					"        }\n" +
					"      ],\n" +
					"      \"aliasIpRanges\": []\n" +
					"    }\n" +
					"  ],\n" +
					"  \"description\": \"\",\n" +
					"  \"labels\": {},\n" +
					"  \"scheduling\": {\n" +
					"    \"preemptible\": false,\n" +
					"    \"onHostMaintenance\": \"MIGRATE\",\n" +
					"    \"automaticRestart\": true,\n" +
					"    \"nodeAffinities\": []\n" +
					"  },\n" +
					"  \"deletionProtection\": false,\n" +
					"  \"reservationAffinity\": {\n" +
					"    \"consumeReservationType\": \"ANY_RESERVATION\"\n" +
					"  },\n" +
					"  \"serviceAccounts\": [\n" +
					"    {\n" +
					"      \"email\": \"688998148034-compute@developer.gserviceaccount.com\",\n" +
					"      \"scopes\": [\n" +
					"        \"https://www.googleapis.com/auth/devstorage.read_only\",\n" +
					"        \"https://www.googleapis.com/auth/logging.write\",\n" +
					"        \"https://www.googleapis.com/auth/monitoring.write\",\n" +
					"        \"https://www.googleapis.com/auth/servicecontrol\",\n" +
					"        \"https://www.googleapis.com/auth/service.management.readonly\",\n" +
					"        \"https://www.googleapis.com/auth/trace.append\"\n" +
					"      ]\n" +
					"    }\n" +
					"  ],\n" +
					"  \"shieldedInstanceConfig\": {\n" +
					"    \"enableSecureBoot\": false,\n" +
					"    \"enableVtpm\": true,\n" +
					"    \"enableIntegrityMonitoring\": true\n" +
					"  },\n" +
					"  \"confidentialInstanceConfig\": {\n" +
					"    \"enableConfidentialCompute\": false\n" +
					"  }\n" +
					"}" ;

			String postEndpoint = "https://www.googleapis.com/compute/v1/projects/arboreal-stage-288722/zones/southamerica-east1-a/instances";

			var request = HttpRequest.newBuilder()
					.uri(URI.create(postEndpoint))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(inputJson))
					.build();

			var client = HttpClient.newHttpClient();

			var response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());
			System.out.println(response.body());


		}




	}



}

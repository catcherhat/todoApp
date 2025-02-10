//package com.serpro.Masterdata;
//
//import java.util.Base64;
//
//
//
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import com.incture.compensationAdvisor.constant.IntegrationConstant;
//import com.incture.integration.service.TriggerSFService;
//
//import jakarta.transaction.Transactional;
//import lombok.extern.slf4j.Slf4j;
//import reactor.core.publisher.Flux;
//
//@Transactional
//@Service
//@Slf4j
//public class TriggerSFServiceImpl implements TriggerSFService {
//
//	@Override
//	public String triggerSFOdata(String endpoint) {
//		WebClient.Builder webClientBuilder = WebClient.builder();
//
//		String username = "sfadmin1@SFCPART000881";
//		String password = "$Incture@1";
//
//		String credentials = username + ":" + password;
//		String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());
//		String result = null;
//
//		try {
//
//			WebClient webClient = webClientBuilder.baseUrl(IntegrationConstant.SF).build();
//
//			Flux<byte[]> responseBody = webClient.get().uri(endpoint)
//					.header("Authorization", "Basic " + base64Credentials).accept(MediaType.APPLICATION_JSON).retrieve()
//					.bodyToFlux(byte[].class);
//
////		    LocalDateTime cD=LocalDateTime.now();
////		    DateTimeFormatter fm=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
////		    String fmd=cD.format(fm);
////		    System.out.println("1: "+fmd);
//
//			result = responseBody.collect(StringBuilder::new, (sb, bytes) -> {
//				for (byte b : bytes) {
//					sb.append((char) b);
//				}
//			}).map(StringBuilder::toString).block();
//
////		    LocalDateTime cD1=LocalDateTime.now();
////		    DateTimeFormatter fm1=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
////		    String fmd1=cD1.format(fm1);
////		    System.out.println("2: "+fmd1);
//
//		} catch (Exception e) {
//			log.error("[TriggerSFServiceImpl][ERROR]: {}",e.getMessage());
//		}
//
//		return result;
//	}
//
//}

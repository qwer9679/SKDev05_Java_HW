package P4_book.control;

import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormat;
import P4_book.entity.*;

public class StatisticsAnalyzer {
	
	public Map<String, Double> calculateAveragePriceByType(Publication[] pubs){
		Map<String, Integer> sum = new HashMap<>();
		Map<String, Integer> count = new HashMap<>();
		
		for(Publication p : pubs) {
			String type = getPublicationType(p);
			
			sum.put(type, sum.getOrDefault(type,  0) + p.getPrice());
			count.put(type, count.getOrDefault(type, 0) + 1);
		}
		
		Map<String, Double> result = new HashMap<>();
		
		for(String key : sum.keySet()) {
			result.put(key,  sum.get(key) / (double)count.get(key));
		}
		
		return result;
	}
	
	public Map<String, Double> calculatePublicationDistribution(Publication[] pubs)
	{
		Map<String, Integer> countMap = new HashMap<>();

	    for (Publication p : pubs) {
	        String type = getPublicationType(p);
	        countMap.put(type, countMap.getOrDefault(type, 0) + 1);
	    }

	    Map<String, Double> result = new HashMap<>();
	    int total = pubs.length;

	    for(String key : countMap.keySet()) {
	        double percent = (countMap.get(key) * 100.0) / total;
	        result.put(key, percent);
	    }

	    return result;
	}
	
	public double calculatePublicationRatioByYear(Publication[] pubs, String year) {
		
		int total = pubs.length;
	    int count = 0;

	    for(Publication p : pubs) {
	        if(p.getPublishDate().startsWith(year)){
	            count++;
	        }
	    }

	    if(total == 0) {
	        return 0;
	    }

	    return (count * 100.0) / total;
	}
	
	public String getPublicationType(Publication p) {
		if(p instanceof Novel) {
			return "Novel";
		}else if(p instanceof Magazine) {
			return "Magazine";
		}
		else if(p instanceof ReferenceBook) {
			return "ReferenceBook";
		}
		return "Unknown";
	}
	
	public void printStatistics(Publication[] pubs) {
		DecimalFormat df = new DecimalFormat("#,###");
		
		System.out.println("1. 타입별 통계 분석;");
		Map<String, Double> avg = calculateAveragePriceByType(pubs);
		
		for(String key: avg.keySet()) {
			String formatted = df.format(avg.get(key));
			System.out.println(key + " 평균 가격 : " + formatted + "원");
		}
		
		System.out.println("\n출판물 유형 분포");
		Map<String, Double> dist = calculatePublicationDistribution(pubs);
		
		for(String key : dist.keySet()) {
			System.out.printf("%s : %.2f%%\n", key, dist.get(key));
		}
		
		System.out.println("\n2007년에 출판된 출판물 비율 : ");
		double ratio = calculatePublicationRatioByYear(pubs, "2007");
		System.out.printf("2007년 비율 : %.2f%%\n", ratio);
	}
}
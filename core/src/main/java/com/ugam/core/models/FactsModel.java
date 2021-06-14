package com.ugam.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(
		adaptables = SlingHttpServletRequest.class,
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
		)
public class FactsModel {
	
	 @ChildResource
	 Resource factitems;
	 
	 public List<Map<String, String>> getFactList() {
	        List<Map<String, String>> factListMap = new ArrayList<>();
	        
	        if(factitems!=null){
	            for(Resource fact : factitems.getChildren()){
	                Map<String,String> factMap = new HashMap<>();
	                factMap.put("factcount",fact.getValueMap().get("factcount",String.class));
	                factMap.put("facttitle",fact.getValueMap().get("facttitle",String.class));
	                factListMap.add(factMap);
	            }
	        }
	        return factListMap;
	    }
	
}

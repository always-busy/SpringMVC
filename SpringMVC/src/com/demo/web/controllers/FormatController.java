package com.demo.web.controllers;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.web.models.FormatModel;

@Controller
@RequestMapping(value="/format")
public class FormatController {

	@RequestMapping(value="/test",method={RequestMethod.GET})
	public String test(Model model){
		
		if(!model.containsAttribute("contentModel")){
			FormatModel formatModel = new FormatModel();
			
			formatModel.setMoney(12345.678);
			formatModel.setDate(new Date());
			
//			CurrencyFormatter currencyFormatter = new CurrencyFormatter();
//			currencyFormatter.setFractionDigits(2);
//			currencyFormatter.setRoundingMode(RoundingMode.HALF_UP);
//			
//			DateFormatter dateFormatter = new DateFormatter();
//			
//			//学到了，月的M要大写区分和分的区别，不然就会是分的数字，时小写的h代表12小时，H代表24小时
//			dateFormatter.setPattern("yyyy-MM-dd HH:mm:ss");
			
			//使用  Locale
//			Locale locale = LocaleContextHolder.getLocale();		
//			formatModel.setMoney(currencyFormatter.print(12345.678, locale));
//			formatModel.setDate(dateFormatter.print(new Date(), locale));
			
			//使用  DefaultFormattingConversionService
//			DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
//			conversionService.addFormatter(currencyFormatter);
//			conversionService.addFormatter(dateFormatter);			
//			formatModel.setMoney(conversionService.convert(12345.678, String.class));
//			formatModel.setDate(conversionService.convert(new Date(), String.class));
			
			
			model.addAttribute("contentModel", formatModel);
		}
		return "formattest";
		
	}
}

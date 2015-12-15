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
//			//ѧ���ˣ��µ�MҪ��д���ֺͷֵ����𣬲�Ȼ�ͻ��Ƿֵ����֣�ʱСд��h����12Сʱ��H����24Сʱ
//			dateFormatter.setPattern("yyyy-MM-dd HH:mm:ss");
			
			//ʹ��  Locale
//			Locale locale = LocaleContextHolder.getLocale();		
//			formatModel.setMoney(currencyFormatter.print(12345.678, locale));
//			formatModel.setDate(dateFormatter.print(new Date(), locale));
			
			//ʹ��  DefaultFormattingConversionService
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

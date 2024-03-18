package com.example.es14.Interceptors;

import com.example.es14.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

        List<Month> monthList = new ArrayList<>();
    public MonthInterceptor(){
        monthList.add(new Month(1,"January","Gennaio","Januar"));
        monthList.add(new Month(2,"February","Febbraio","Februar"));
        monthList.add(new Month(3,"March","Marzo","März"));
        monthList.add(new Month(4,"April","Aprile","April"));
        monthList.add(new Month(5,"May","Maggio","Mai"));
        monthList.add(new Month(6,"June","Giugno","Juni"));
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumber = request.getHeader("monthNumber");
        if (monthNumber == null || monthNumber.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Il numero del mese è obbligatorio");
            return false;
        }
        for (Month month : monthList) {
            // Verifica se il numero del mese corrente corrisponde a quello ricevuto
            if (month.getMonthNumber() == Integer.parseInt(monthNumber)) {
                // Se il numero del mese corrisponde, impostalo come "selectedMonth" negli attributi della richiesta
                request.setAttribute("month", month);
                // Ritorna true per indicare che la richiesta è stata gestita correttamente
                return true;
            } else {
                Month empyMonth = new Month();
                empyMonth.setEnglishName("nope");
                empyMonth.setGermanName("nope");
                empyMonth.setGermanName("nope");
                request.setAttribute("month", empyMonth);
            }

        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }


}

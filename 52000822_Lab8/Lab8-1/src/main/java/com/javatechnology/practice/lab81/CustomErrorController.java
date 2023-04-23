package com.javatechnology.practice.lab81;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static jakarta.servlet.RequestDispatcher.ERROR_STATUS_CODE;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping(value="/error", method = RequestMethod.GET)
    public String errorMessage(HttpServletRequest httpServletRequest, Model model) {
        String errMsg;
        int httpErrorCode = getErrorCode(httpServletRequest);

        switch (httpErrorCode) {
            case 400 -> errMsg = "HTTP ERROR CODE: 400...Bad Request";
            case 401 -> errMsg = "HTTP ERROR CODE: 401...Unauthorized";
            case 403 -> errMsg = "HTTP ERROR CODE: 403...Forbidden";
            case 404 -> errMsg = "HTTP ERROR CODE: 404...Not found";
            case 500 -> errMsg = "HTTP ERROR CODE: 500...Internal Server Error";
            case 505 -> errMsg = "HTTP ERROR CODE: 505...HTTP Version Not Supported";
            default -> errMsg = "ERROR";
        }
        model.addAttribute("errorMsg",errMsg);
        return "errorPage";
    }

    private int getErrorCode(HttpServletRequest httpServletRequest) {
        Object errorCode = httpServletRequest.getAttribute(ERROR_STATUS_CODE);
        return errorCode == null ? 0 : (Integer)errorCode;
    }
}

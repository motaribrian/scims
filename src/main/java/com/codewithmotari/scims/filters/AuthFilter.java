/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.codewithmotari.scims.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zurion
 */
public class AuthFilter implements Filter {



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("username") != null);

        boolean isLoginRequest = uri.equals("/login") || uri.endsWith("login.jsp");
        boolean isStaticResource = uri.contains("/css/") || uri.contains("/js/") || uri.contains("/images/");

        if (!loggedIn && !isLoginRequest && !isStaticResource) {
            res.sendRedirect(contextPath + "/login");
            return;
        }

        // ✅ Only set cookie if session exists
        if (session != null) {
            String sessionId = session.getId();
            res.setHeader("Set-Cookie", "JSESSIONID=" + sessionId + "; Path=/; HttpOnly; SameSite=Lax");
            System.out.println("SessionId="+sessionId);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
    @Override
    public void init(FilterConfig filterConfig) {
    }

 
    
}

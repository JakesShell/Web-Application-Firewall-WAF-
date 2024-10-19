# Web Application Firewall (WAF)

## Overview

The **Web Application Firewall (WAF)** project is designed to filter and monitor HTTP traffic to protect web applications from common attacks, including SQL injection and cross-site scripting (XSS). This application uses Java and the Spring Boot framework to implement filtering logic that blocks malicious requests.

## Key Features

- **Request Filtering**: Monitors incoming HTTP requests for SQL injection and XSS attacks.
- **Response Filtering**: Optionally adds security headers to outgoing responses.
- **Customizable Rules**: Easily extendable to add more complex filtering rules and detection methods.

## Technologies Used

- **Java**: The primary programming language for developing the WAF.
- **Spring Boot**: Used for building the web application and managing HTTP requests and responses.

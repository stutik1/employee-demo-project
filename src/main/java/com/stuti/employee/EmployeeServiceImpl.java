package com.stuti.employee;


import com.stuti.employee.gen.Employee;
import com.stuti.employee.gen.EmployeeServiceRequest;
import com.stuti.employee.gen.EmployeeServiceResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.HashMap;
import java.util.Map;

@Endpoint
public class EmployeeServiceImpl {

    public static final String NAMESPACE_URI="http://stuti.com/employee/gen";
    // In-memory map to store employee data
    private static Map<String, Employee> employeeStorage = new HashMap<>();
    private static Integer counter=0;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "employeeServiceRequest")
    @ResponsePayload
    public EmployeeServiceResponse registerEmployeeData(@RequestPayload EmployeeServiceRequest employeeServiceRequest) {
        Employee employee=employeeServiceRequest.getEmployee();
        EmployeeServiceResponse employeeServiceResponse=new EmployeeServiceResponse();

        if (employee.getName() == null || employee.getId() == null || employee.getAddress() == null) {
            employeeServiceResponse.setStatus("Failed: Missing required employee details.");
            return employeeServiceResponse;
        }
        counter++;
        employee.setId(String.valueOf(counter));
        // Check if employee ID already exists
        if (employeeStorage.containsKey(employee.getId())) {
            employeeServiceResponse.setStatus("Failed: Employee with ID " + employee.getId() + " already exists.");
            return employeeServiceResponse;
        }

        // Store employee in local memory
        employeeStorage.put(employee.getId(), employee);
        employeeServiceResponse.setStatus("Employee " + employee.getName() + " with ID " + employee.getId() + " created successfully.");
        return employeeServiceResponse;
    }
}

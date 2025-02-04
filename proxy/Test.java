package DESIGNPATTERNS.proxy;

public class Test {
}


interface Employee{
    String getDetails();
}

class EmployeeImpl implements Employee{
    public String getDetails(){
        return "";
    }
}

class EmployeeProxy implements Employee{

    Employee employee;
    EmployeeProxy(Employee employee){
        this.employee =employee;
    }

    public String getDetails(){
        //Do more operations , check accesss , etc.
        return this.employee.getDetails();
    }
}
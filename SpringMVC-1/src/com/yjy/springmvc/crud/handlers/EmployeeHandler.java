package com.yjy.springmvc.crud.handlers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yjy.springmvc.crud.dao.DepartmentDao;
import com.yjy.springmvc.crud.dao.EmployeeDao;
import com.yjy.springmvc.crud.entities.Employee;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,
			Map<String, Object> map){
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String update(Employee e){
		employeeDao.save(e);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id,Map<String,Object> map
			,HttpServletRequest request){
		
		String _method = (String) request.getAttribute("_method");
		System.out.println("GET"+ "_method:"+_method);
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";  //重定向
	}	
	
	//删除
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		System.out.println("DELETE");
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String save(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";  //重定向
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String,Object> map){
		
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());  //响应input.jsp中的form标签modelAttribute属性值
		return "input";
	}
	
	@RequestMapping("/emps")
	public String list(Map<String,Object> map){
		map.put("employees", employeeDao.getAll());
		return "list";
	}
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Admin;
import com.example.demo.model.GrievanceEntry;
import com.example.demo.model.Student;
import com.example.demo.service.AdminService;
import com.example.demo.service.FeedbackService;
import com.example.demo.service.GrievanceEntryService;
import com.example.demo.service.ResponseService;
import com.example.demo.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController 
{
	
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private GrievanceEntryService grievanceEntryService;
	
	@Autowired
	private ResponseService responseService;
	
	
	@Autowired
    private FeedbackService  feedbackService;

	
	@GetMapping("/")
	public String main()
	{
		return  "index";
	}
	  @GetMapping("adminlogin")
	   public ModelAndView adminlogin()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("adminlogin");
	     return mv;
	   }
	  @GetMapping("handler")
	   public ModelAndView handler()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("handler");
	     return mv;
	   }
	 

	 
	  @GetMapping("contactus")
	   public ModelAndView contactus()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("contactus");
	     return mv;
	   }
	  
	  @GetMapping("category")
	   public ModelAndView category()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("category");
	     return mv;
	   }
	  
	  @GetMapping("aboutus")
	   public ModelAndView aboutus()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("aboutus");
	     return mv;
	   }
	  @GetMapping("studentdashboard")
	   public ModelAndView studentdashboard()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("studentdashboard");
	     return mv;
	   }
  
	  @GetMapping("dashboardcategories")
	   public ModelAndView dashboardcategories()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("dashboardcategories");
	     return mv;
	   }
	  @PostMapping("checkadminlogin")
	  public ModelAndView checkadminlogin(HttpServletRequest request)
	  {
		  
		  ModelAndView mv=new ModelAndView();
		  
		  String uname=request.getParameter("uname");
		  String pwd=request.getParameter("pwd");
		  
		  Admin a=adminService.checkadminlogin(uname,pwd);
		  
		  if(a!=null)
		  {
			  mv.setViewName("admindashboard");
			  
			  long usercount=adminService.usercount();
			  long grievancescount=adminService.grievancescount();
			  
			  mv.addObject("usercount", usercount);
			  mv.addObject("grievancescount", grievancescount);
		  }
		  else {
			  mv.setViewName("adminlogin");
			  mv.addObject("message","Login Failed");
		  }
		  return mv;
	  }
	
	  @GetMapping("adduser")
	   public ModelAndView adduser()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("adduser");
	     return mv;
	   }
	  @GetMapping("stdlogin")
	   public ModelAndView stdlogin()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("stdlogin");
	     return mv;
	   }
	  @GetMapping("admindashboard")
	   public ModelAndView admindashboard()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("admindashboard");
	     return mv;
	   }
	 
	  
	  @PostMapping("insertstd")
	  public ModelAndView insert(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView();
		  String msg=null;
		  
		  try
		  {
			  String name=request.getParameter("name");
			  String email=request.getParameter("email");
			  String dob=request.getParameter("dob");
			  String gender=request.getParameter("gender");
			  String department=request.getParameter("department");
			  String years=request.getParameter("year");
			  int year= Integer.parseInt(years);
			  String pwd = request.getParameter("password");
			  String section=request.getParameter("section");
			  String contactno=request.getParameter("contact");
			  String address=request.getParameter("address");
			  
			  Student s=new Student();
			  s.setName(name);
			  s.setEmail(email);
			  s.setDateofbirth(dob);
			  s.setGender(gender);
			  s.setDepartment(department);
			  s.setYear(year);
			  s.setSection(section);
			  s.setContact(contactno);
			  s.setAddress(address);
			  s.setPassword(pwd);
			 
			  msg=studentService.addstudent(s);
			  
			  mv.setViewName("displaymsg");
			  mv.addObject("message", msg);
			  
		  }
		  catch(Exception e)
		  {
			  msg=e.getMessage();
			  mv.setViewName("displayerror");
			  mv.addObject("message", msg);
		  }
		  return mv;
	  }
	  
	  @PostMapping("checkstdlogin")
	  public ModelAndView checkstdlogin(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView();
		  String email=request.getParameter("email");
		  String pwd=request.getParameter("pwd");
		  
		  Student std=studentService.checkstdlogin(email, pwd);
		  if(std!=null)
		  {
			  HttpSession  session=request.getSession();
			  
			  
			  session.setAttribute("sid", std.getId());

			  session.setAttribute("sname", std.getName());
			  
			  mv.setViewName("dashboardcategories");
		  }
		  else {
			  mv.setViewName("stdlogin");
			  mv.addObject("message", "STUDENT, LOGIN FAILED...!!!");
		  }
		  return mv;
	  }
	    
	  @GetMapping("greivanceentry")
	   public ModelAndView greivanceentry()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("greivanceentry");
	     return mv;
	   } 
	  
	  
	  @PostMapping("insertgreivance")
	  public ModelAndView insertgreivance(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView();
		  String msg=null;
		  
		  try
		  {
			  String name=request.getParameter("name");
			  String email=request.getParameter("email");
			  String entrydate=request.getParameter("entrydate");
			  String category=request.getParameter("category");
			  String title=request.getParameter("title");
			  String description=request.getParameter("description");
			  
			  GrievanceEntry g=new GrievanceEntry();
			  g.setName(name);
			  g.setEmail(email);
			  g.setEntrydate(entrydate);
			  g.setCategory(category);
			  g.setTitle(title);
			  g.setDescription(description);
			  
              msg=grievanceEntryService.addgreivance(g);
			  
			  mv.setViewName("displaymsg");
			  mv.addObject("message", msg);
			  
		  }
		  catch(Exception e)
		  {
			  msg=e.getMessage();
			  mv.setViewName("displayerror");
			  mv.addObject("message", msg);
		  }
		  return mv;
	  }
	  
	  @GetMapping("deletegrev")
	   public ModelAndView deleteemp()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("deletegrev");
	     
	     List<GrievanceEntry> grevlist =  grievanceEntryService.viewgrievances();
	     
	     mv.addObject("grevdata", grevlist);
	     
	     return mv;
	   }
	  @GetMapping("delete/{id}")
	    public String deleteaction(@PathVariable("id") int eid)
	    {
		  grievanceEntryService.deletegrev(eid);
	      return "redirect:/deletegrev";
	    }
	  
//	  @GetMapping("viewgrievancesuser")
//	  public ModelAndView viewcomplaintsbyuser(HttpServletRequest request) {
//		    
//		     ModelAndView mv = new ModelAndView();
//		     mv.setViewName("viewgrievances");
//		     Integer id = (Integer) request.getSession().getAttribute("id");
//		    List<GrievanceEntry> tlist = grievanceEntryService.viewgrievances();
//		    
//		    HttpSession session = request.getSession();
//		    //int id = (int)session.getAttribute("id");
//		    
//		    List<GrievanceEntry> list = new ArrayList<GrievanceEntry>();
//		    for(GrievanceEntry c: tlist) {
////		      if(c.getId()==id)
////		        list.add(c);
//		    	if (id != null && c.getId() == id.intValue()) {
//		    		  list.add(c);
//		    		}
//
//		    }
//		    
//		    mv.addObject("empdata", list);
//		     return mv;
//		    
//		  }
	 
	  
//	  @GetMapping("viewgrievancesuser")
//	  public ModelAndView viewcomplaintsbyuser(HttpServletRequest request) {
//
//	    ModelAndView mv = new ModelAndView();
//	    mv.setViewName("viewgrievances");
//
//	    String email = (String) request.getSession().getAttribute("email");
//	    List<GrievanceEntry> tlist = grievanceEntryService.viewgrievances();
//	    List<GrievanceEntry> list = new ArrayList<>();
//
//	    // Check if the user has at least one grievance
//	    boolean hasGrievance = false;
//	    for (GrievanceEntry c : tlist) {
//	      if (email != null && c.getEmail().equals(email)) {
//	        hasGrievance = true;
//	        list.add(c);
//	      }
//	    }
//
//	    // If the user has at least one grievance, add a message to the model
//	    if (hasGrievance) {
//	      mv.addObject("message", "You have " + list.size() + " grievances.");
//	    } else {
//	      // If the user has no grievances, add a different message to the model
//	      mv.addObject("message", "You have no grievances.");
//	    }
//
//	    mv.addObject("empdata", list);
//	    return mv;
//
//	  }

	  @GetMapping("adminstatus")
	   public ModelAndView adminstatus()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("adminstatus");
	     List<GrievanceEntry> glist=grievanceEntryService.viewgrievances();
	     mv.addObject("empdata", glist);
	     return mv;
	   }	  
	 
	  @GetMapping("grievancereport")
	   public ModelAndView grievancereport()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("grievancereport");
	     List<Student> stdlist=studentService.viewallstudents();
	     mv.addObject("empdata", stdlist);
	     return mv;
	   }
	  @GetMapping("popup")
	   public ModelAndView popup()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("popup");
	     return mv;
	   }
	 
	  
	  
	 
	  
	  
	  
	  @GetMapping("displaygrevbyemail")
	   public ModelAndView displaygrevbyemail() 
	   {
	     ModelAndView mv=new ModelAndView("seestudentbyid");
	     return mv;
	   }
	  
	
	  
	  
	  @GetMapping("grevbyid")
	  public ModelAndView  viewstudentbyiddemo()
	  {
	  	   List<GrievanceEntry> studentlist=grievanceEntryService.viewgrievances();
	  	   ModelAndView mv=new ModelAndView("seestudentbyid");
	  	   mv.addObject("studentlist",studentlist);
	  	   return mv;
	  }
//	  @PostMapping("displaystudent")
//	   public ModelAndView displaystudentdemo(HttpServletRequest request)
//	   {
//		   int sid=Integer.parseInt(request.getParameter("sid"));
//		   GrievanceEntry student=grievanceEntryService.ViewGrievanceByID(sid);
//		   ModelAndView mv=new ModelAndView("displaystudent");
//		   mv.addObject("student",student);
//		   return mv;
//	   }
	  
	  @PostMapping("displaystudent")
	   public ModelAndView displaystudentdemo(HttpServletRequest request)
	   {
		   int sid=Integer.parseInt(request.getParameter("sid"));
		   GrievanceEntry student=grievanceEntryService.ViewGrievanceByID(sid);
		   ModelAndView mv=new ModelAndView("displaystudent");
		   mv.addObject("student",student);
		   return mv;
	   }

	  
//	  
//	  
//	  @GetMapping("grevbyemail")
//	  public ModelAndView  viewgrevbyemaildemo()
//	  {
//	  	   List<GrievanceEntry> studentlist=grievanceEntryService.viewgrievances();
//	  	   ModelAndView mv=new ModelAndView("grevbyemail");
//	  	   mv.addObject("studentlist",studentlist);
//	  	   return mv;
//	  }
  
//	  @PostMapping("displaystudent")
//	  public ModelAndView  viewgrevbyemail(HttpServletRequest request)
//	  {
//		   String name = request.getParameter("name");
//	  	   List<GrievanceEntry> student=grievanceEntryService.ViewGrievanceByEmail(name);
//	  	   ModelAndView mv=new ModelAndView("displaygrevbyemail");
//	  	   mv.addObject("student",student);
//	  	   return mv;
//	  }
//	  @GetMapping("grevbyuser")
//	  public ModelAndView  viewstudentbyiddemo(HttpServletRequest request)
//	  {
//		   ModelAndView mv=new ModelAndView("displaystudent");
//	  	   List<GrievanceEntry> studentlist=grievanceEntryService.viewcomplaintsbyuser(request);
//	  	   System.out.println(studentlist);
//	  	   mv.addObject("studentlist",studentlist);
//	  	   return mv;
//	  }
//	  
//	 
//	 
//	  @PostMapping("displaystudent")
//	   public List<GrievanceEntry> displaystudentdemo(HttpServletRequest request)
//	   {
//		  
//		  
//		  List<GrievanceEntry> tlist = grievanceEntryService.viewgrievances();
//		    
//		    HttpSession session = request.getSession();
//		    int id = (int)session.getAttribute("id");
//		    
//		   List<GrievanceEntry> list = new ArrayList<GrievanceEntry>();
//		  
//		    for( GrievanceEntry c: tlist) {
//		      if(c.getId()==id)
//		        list.add(c);
//		    }
//		    
//		    return list;
//	   }
//
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
	  
	  
	  
	  
	 
	 
	  @PostMapping("viewbycategory")
	   public ModelAndView viewproductsbycategory(HttpServletRequest request)
	   {
	     String category = request.getParameter("category");
	     
	     List<GrievanceEntry> empdata = grievanceEntryService.viewbycategory(category);
	     
	     ModelAndView mv = new ModelAndView("viewgrehandler");
	     
	     mv.addObject("empdata",empdata );
	     
	     return mv;
	   }
	 
	  
	 
	  
	  
	  
	  
	 
	  
//	  @GetMapping("viewgrievancesuser")
//	  public ModelAndView viewcomplaintsbyuser(HttpServletRequest request) {
//		    
//		     ModelAndView mv = new ModelAndView();
//		     mv.setViewName("viewgrievances");
//		     int sid=Integer.parseInt(request.getParameter("sid"));
//		     List<GrievanceEntry> tlist = grievanceEntryService.viewgrievances();
//		    
//		 
//		    GrievanceEntry student=grievanceEntryService.ViewGrievanceByID(sid);
//		    List<GrievanceEntry> list = new ArrayList<GrievanceEntry>();
//		    for(GrievanceEntry c: tlist) {
//
//		    	if (sid != 0 && c.getId()==sid) {
//		    	    list.add(c);
//		    	  }
//
//		    }
//		    
//		    mv.addObject("student", student);
//		     return mv;
//		    
//		  }
//	 
	  
//	  @PostMapping("studentbasedid")
//	  public List<GrievanceEntry> complaintsbyuser(HttpServletRequest request) {
//		    
//		    List<GrievanceEntry> studentlist = grievanceEntryService.viewgrievances();
//		    
//		    HttpSession session = request.getSession();
//		    int id = (int)session.getAttribute("id");
//		    
//		    List<GrievanceEntry> list = new ArrayList<GrievanceEntry>();
//		    for(GrievanceEntry c: studentlist) {
//		      if(c.getId()==id)
//		        list.add(c);
//		    }
//		    
//		    return list;
//		    
//		  }
//	  
	  
	  
	  
	  

	  @GetMapping("view")
	   public ModelAndView viewempdemo(@RequestParam("id") int sid)
	   {
	     Student s = adminService.viewstudentbyid(sid);
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("viewstudentbyid");
	     mv.addObject("s", s);
	     return mv;
	   }
	 
	 
	  @GetMapping("displaycategory")
	   public ModelAndView displaycategory() 
	   {
	     ModelAndView mv=new ModelAndView("displaycategory");
	     return mv;
	   }
	  @GetMapping("displayhandlercategory")
	   public ModelAndView displayhandlercategory() 
	   {
	     ModelAndView mv=new ModelAndView("displayhandlercategory");
	     return mv;
	   }
	  
	  @GetMapping("feedback")
	   public ModelAndView feedback()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("feedback");
	     return mv;
	   }
	 
	  
	  @GetMapping("updateprofile")
	    public ModelAndView updateemp(HttpServletRequest request)
	    {
	      ModelAndView mv = new ModelAndView();
	      
	      HttpSession session = request.getSession();
	      
	      mv.setViewName("updateprofile");
	      
	      mv.addObject("sid", session.getAttribute("sid"));
	      mv.addObject("sname", session.getAttribute("sname"));
	      
	      int id = (int) session.getAttribute("sid");
	      
	      Student s = studentService.viewbyid(id);
	      
	      mv.addObject("s", s);
	      
	      return mv;
	    }
	  
	  
	  @PostMapping("update")
	    public ModelAndView updateaction(HttpServletRequest request)
	    {
	      String msg = null;
	      
	      ModelAndView mv = new ModelAndView();
	      
	      HttpSession session = request.getSession();
	      
	      mv.addObject("sid", session.getAttribute("sid"));
	      mv.addObject("sname", session.getAttribute("sname"));
	      
	      int id = (int) session.getAttribute("sid");
	      
	     try
	     {
	    	 String name=request.getParameter("name");
			  String email=request.getParameter("email");
			  String dob=request.getParameter("dob");
			  
			  String department=request.getParameter("department");
			  
			  String pwd = request.getParameter("password");
			 
			  String section=request.getParameter("section");
			  String contactno=request.getParameter("contact");
			  String address=request.getParameter("address");
			  
			  Student s=new Student();
			  s.setId(id);
			  s.setName(name);
			  s.setEmail(email);
			  s.setDateofbirth(dob);
			 
			  s.setDepartment(department);
			 
			  s.setSection(section);
			
			  s.setContact(contactno);
			  s.setAddress(address);
			  s.setPassword(pwd);
			 
	        
	        
	        msg = studentService.updatestudent(s);
	        
	        mv.setViewName("stdlogin");
	        mv.addObject("message",msg);
	       
	     }
	     catch(Exception e)
	     {
	       msg = e.getMessage();
	       
	       mv.setViewName("updateerror");
	        mv.addObject("message",msg);
	     }
	      
	     
	      return mv;

	    }
	    
	  
	
	  @GetMapping("responsehandler")
	   public ModelAndView responsehandler()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("responsehandler");
	     return mv;
	   }
	  @GetMapping("response")
	   public ModelAndView response()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("response");
	     return mv;
	   }
	 
	  
	  @GetMapping("viewgrievances")
	   public ModelAndView viewgrievances()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("viewgrievances");
	     List<GrievanceEntry> glist=grievanceEntryService.viewgrievances();
	     mv.addObject("empdata", glist);
	     return mv;
	   }
	  
	 

	  
	  
	  
}


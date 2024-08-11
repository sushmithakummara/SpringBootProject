package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.GrievanceEntry;
import com.example.demo.repository.GrievanceEntryRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class GrievanceEntryServiceImpl implements GrievanceEntryService
{
	@Autowired
	private GrievanceEntryRepository  grevEntryRepository;

	

	@Override
	public String addgreivance(GrievanceEntry grievanceEntry) {

		grevEntryRepository.save(grievanceEntry);
		return "grievance registered successfully";
	}



	@Override
	public List<GrievanceEntry> viewgrievances()
	{
		// TODO Auto-generated method stub
		return grevEntryRepository.findAll();
	}



	@Override
	public List<GrievanceEntry> viewbycategory(String category) 
	{
		
		return grevEntryRepository.viewbycategory(category);
	}



	@Override
	public GrievanceEntry ViewGrievanceByID(int gid)
	{
		
		return  grevEntryRepository.findById(gid).get();
	}



	@Override
	public List<GrievanceEntry> ViewGrievanceByEmail(String name) {
		
		return grevEntryRepository.viewbyEmail(name);
	}



	@Override
	public List<GrievanceEntry> viewcomplaintsbyuser(HttpServletRequest request) {
		HttpSession session = request.getSession();
	    int userId = (int) session.getAttribute("id");

	   
	    Optional<GrievanceEntry> userGrievancesOptional = grevEntryRepository.findById(userId);

	    // Extract the GrievanceEntry object from the Optional object
	    GrievanceEntry userGrievances = userGrievancesOptional.orElse(null);

	    
	    List<GrievanceEntry> list = new ArrayList<GrievanceEntry>();

	    // Add the GrievanceEntry object to the list
	    if (userGrievances != null) {
	        list.add(userGrievances);
	    }

	    // Return the list of grievances
	    return list;
	}



	@Override
	public String deletegrev(int id) {
   Optional<GrievanceEntry> obj =  grevEntryRepository.findById(id);
        
        String msg = null;
        
        if(obj.isPresent())
        {
        	GrievanceEntry    g = obj.get();
        	 grevEntryRepository.delete(g); 
          msg = "Grev Deleted Successfully";
        }
        else
        {
          msg = " Not Found";
        }
        
        return msg;
	}
	

	


}

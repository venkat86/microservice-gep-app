package com.pwc.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;


import com.pwc.domain.core.Answers;

import com.pwc.service.Answers_Default_ActivityService;



/**
 * 
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
   build:   </p> 
 *
 * code was generated by the Geppetto System </br>
 * Gepppetto system Copyright - Geppetto LLC 2014 - 2015</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/

@Api(value = "/Answers_Default_Activity", description = "Answers_Default_Activity of Answers_Default_Activity", 
produces = "application/json")

@Controller("Answers_Default_ActivityController")
@RequestMapping("/Answers_Default_Activity")
public class Answers_Default_ActivityController extends GpBaseController {


	Answers_Default_ActivityService Answers_Default_Activity_service;


	public Answers_Default_ActivityService get_Answers_Default_Activity_service() {
		return Answers_Default_Activity_service;
	}


	@Resource(name="Answers_Default_ActivityService")
	public void set_Answers_Default_Activity_service(Answers_Default_ActivityService Answers_Default_Activity_service) {
		this.Answers_Default_Activity_service = Answers_Default_Activity_service;
	}




	//auths not ready at this time


	@ApiOperation(value = "/create_Answers", httpMethod = "POST",
	notes = "creates a noun of Answers", 
	response = Answers.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.POST,value = "/create_Answers" ,headers="Accept=application/json")
    @ResponseBody
	public Answers create_Answers(@RequestBody Answers the_Answers) throws Exception {

		Answers a_Answers;

		a_Answers = Answers_Default_Activity_service.create_answers(the_Answers, super.getUser());

		return a_Answers;

	}

	//auths not ready at this time


	@ApiOperation(value = "/update_Answers", httpMethod = "PUT",
	notes = "updates a noun of Answers", 
	response = Answers.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.PUT,value = "/update_Answers" ,headers="Accept=application/json")
    @ResponseBody
	public Answers update_Answers(@RequestBody Answers the_Answers) throws Exception {

		Answers a_Answers;

		a_Answers = Answers_Default_Activity_service.update_answers(the_Answers, super.getUser());

		return a_Answers;

	}

	//auths not ready at this time


	@ApiOperation(value = "/search_for_update_Answers/{Answers_id}", httpMethod = "GET",
	notes = "updates a noun of Answers", 
	response = Answers.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET,value = "/search_for_update_Answers/{Answers_id}" ,headers="Accept=application/json")
    @ResponseBody
	public Answers search_for_update_Answers(@PathVariable("Answers_id")long Answers_id) throws Exception {

		Answers the_Answers = new Answers();

		the_Answers = Answers_Default_Activity_service.answers_search_for_update(Answers_id, super.getUser());

		return the_Answers;

	}

	//auths not ready at this time


	@ApiOperation(value = "/delete_Answers/{Answers_id}", httpMethod = "DELETE",
	notes = "deletes a noun of Answers", 
	response = Answers.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.DELETE,value = "/delete_Answers/{Answers_id}" ,headers="Accept=application/json")
    @ResponseBody
	public String  delete_Answers(@PathVariable("Answers_id")long Answers_id) throws Exception {

		String service_return_msg = "";

		service_return_msg = Answers_Default_Activity_service.delete_answers(Answers_id, super.getUser());

		return service_return_msg;

	}

	//auths not ready at this time


	@ApiOperation(value = "/get_all_Answers", httpMethod = "GET",
	notes = "special search that gets all values of Answers", 
	response = Answers.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET,value = "/get_all_Answers" ,headers="Accept=application/json")
    @ResponseBody
	public ArrayList<Answers> get_all_Answers() throws Exception {

		ArrayList<Answers> Answers_list = new ArrayList<Answers>();

		Answers_list = Answers_Default_Activity_service.get_all_answers();

		return Answers_list;

	}

	//auths not ready at this time


	@ApiOperation(value = "/get_Answers_by_parent_id", httpMethod = "GET",
	notes = "get by parent id of Answers", 
	response = Answers.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET,value = "/get_Answers_by_parent_id" )
    @ResponseBody
	public ArrayList<Answers> get_Answers_by_parent_id(@RequestParam(required = false, value = "Check_List_Maintenance_Master_id", defaultValue = "0") long Check_List_Maintenance_Master_id,@RequestParam(required = false, value = "Questions_id", defaultValue = "0") long Questions_id,@RequestParam(required = false, value = "In_flight_checklists_id", defaultValue = "0") long In_flight_checklists_id) throws Exception {

		ArrayList<Answers> Answers_list = new ArrayList<Answers>();

		Answers_list = Answers_Default_Activity_service.get_answers_by_parent_id(Check_List_Maintenance_Master_id, Questions_id, In_flight_checklists_id);

		return Answers_list;

	}

	//auths not ready at this time


	@ApiOperation(value = "/delete_Answers_by_parent_id", httpMethod = "DELETE",
	notes = "delete by parent of Answers", 
	response = Answers.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.DELETE,value = "/delete_Answers_by_parent_id" )
    @ResponseBody
	public String  delete_Answers_by_parent_id(@RequestParam(required = false, value = "Check_List_Maintenance_Master_id", defaultValue = "0") long Check_List_Maintenance_Master_id,@RequestParam(required = false, value = "Questions_id", defaultValue = "0") long Questions_id,@RequestParam(required = false, value = "In_flight_checklists_id", defaultValue = "0") long In_flight_checklists_id) throws Exception {

		String service_return_msg = "";

		service_return_msg = Answers_Default_Activity_service.delete_answers_by_parent_id(Check_List_Maintenance_Master_id, Questions_id, In_flight_checklists_id);

		return service_return_msg;

	}




}
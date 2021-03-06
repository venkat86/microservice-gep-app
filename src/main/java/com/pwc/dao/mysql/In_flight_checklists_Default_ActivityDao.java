package com.pwc.dao.mysql;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Query;
import javax.persistence.Transient;
import javax.sound.midi.SysexMessage;
import javax.sql.DataSource;
import javax.transaction.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;
import javax.transaction.Transactional;
import javax.persistence.Query;


import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;



import com.pwc.domain.core.In_flight_checklists;
import com.pwc.domain.core.GpUser;


/**
 *
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
 * build:   </p>
 *
 * code was generated by the Geppetto System </br>
 * Gepppetto system Copyright - Geppetto LLC 2014 - 2015</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/
@Transactional
@Repository("In_flight_checklists_Default_ActivityDao")
public class In_flight_checklists_Default_ActivityDao   {

	private Log log = LogFactory.getLog(getClass());

	@Value("${create_In_flight_checklists.sql}")
	private String create_In_flight_checklists;
	@Value("${search_for_update_In_flight_checklists.sql}")
	private String search_for_update_In_flight_checklists;
	@Value("${update_In_flight_checklists.sql}")
	private String update_In_flight_checklists;
	@Value("${delete_In_flight_checklists.sql}")
	private String delete_In_flight_checklists;
	@Value("${get_all_In_flight_checklists.sql}")
	private String get_all_In_flight_checklists;


    @PersistenceContext
	EntityManager entityManager;



	//auths not ready at this time
	public In_flight_checklists in_flight_checklists_search_for_update(long id, GpUser user) throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(search_for_update_In_flight_checklists,In_flight_checklists.class)

			.setParameter("id", id);;

			ArrayList<In_flight_checklists> In_flight_checklists_list =	(ArrayList<In_flight_checklists>)result.getResultList();

			if(In_flight_checklists_list  == null){
				throw new Exception("no In_flight_checklists found");
			}

			return (In_flight_checklists) In_flight_checklists_list.get(0);

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}

	//auths not ready at this time
	public ArrayList<In_flight_checklists> get_all_in_flight_checklists() throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(get_all_In_flight_checklists,In_flight_checklists.class)

;

			ArrayList<In_flight_checklists> In_flight_checklists_list =	(ArrayList<In_flight_checklists>)result.getResultList();

			if(In_flight_checklists_list .size() < 1){
				throw new Exception("no In_flight_checklists found");
			}

			return (ArrayList<In_flight_checklists>) In_flight_checklists_list;

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed

		}
		return null;


	}



	//auths not ready at this time
	@Transactional
	public In_flight_checklists create_in_flight_checklists(In_flight_checklists In_flight_checklists, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(create_In_flight_checklists)
			.setParameter("status", In_flight_checklists.getStatus())
			.setParameter("collaborators", In_flight_checklists.getCollaborators())
			.setParameter("created_by", user == null ? 0:user.getId())
			.setParameter("updated_by", user == null ? 0:user.getId())
;

			int insertedId = query.executeUpdate();
					String lastIndex="select last_insert_id()";
					Query sql = entityManager.createNativeQuery(lastIndex);
					BigInteger new_id = (BigInteger) sql.getSingleResult();
					In_flight_checklists.setId(new_id.longValue());
					System.out.println("create data---"+insertedId);

			return In_flight_checklists;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}

	//auths not ready at this time
	@Transactional
	public In_flight_checklists update_in_flight_checklists(In_flight_checklists In_flight_checklists, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(update_In_flight_checklists)
			.setParameter("id", In_flight_checklists.getId())
			.setParameter("status", In_flight_checklists.getStatus())
			.setParameter("collaborators", In_flight_checklists.getCollaborators())
			.setParameter("updated_by", user == null ? 0:user.getId())
;

			query.executeUpdate();

			return In_flight_checklists;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}

	//auths not ready at this time
	@Transactional
	public String  delete_in_flight_checklists(long id, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(delete_In_flight_checklists)
			.setParameter("id", id);

			query.executeUpdate();

			return "{\"status\":\"success\"}";

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString());

		}
		return null;



	}



}
package com.wm.ECartPGPTeamTen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;

import com.wm.ECartPGPTeamTen.model.UserModel;

/**
 * r0m09yu
 */

@Repository
public class UserDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	
	public List<UserModel> findById(Integer userId){
		BasicQuery query = new BasicQuery("{ id : { $eq : "+userId+" }}");
		return mongoTemplate.find(query, UserModel.class);
	}
	
}

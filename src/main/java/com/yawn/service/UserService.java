package com.yawn.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.stereotype.Service;

import com.yawn.entity.UserGroup;

/**
 * @author Created by yawn on 2018-01-08 13:55
 */
@Service
public class UserService {

	@Resource
	private IdentityService identityService;

	public boolean login(String userName, String password) {
		return identityService.checkPassword(userName, password);
	}

	public Object getAllUser() {
		List<User> userList = identityService.createUserQuery().list();
		return toMyUser(userList);
	}

	public Object getAllGroup() {
		List<Group> groupList = identityService.createGroupQuery().list();
		if (groupList == null || groupList.size() == 0) {
			// 创建角色
			// 创建用户组并保存
			// 填写申请
			// 调用newGroup方法创建Group实例
			Group group = identityService.newGroup("empGroup");
			group.setName("申请组");
			identityService.saveGroup(group);

			// 总监
			Group group1 = identityService.newGroup("manageGroup");
			group1.setName("总监组");
			identityService.saveGroup(group1);

			// 经理
			// 调用newGroup方法创建Group实例
			Group group2 = identityService.newGroup("dirGroup");
			group2.setName("经理组");
			// 保存Group到数据库
			identityService.saveGroup(group2);

			groupList = identityService.createGroupQuery().list();
		}
		List<UserGroup> userGroupList = new ArrayList<>();
		for (Group group : groupList) {
			UserGroup userGroup = new UserGroup();
			userGroup.setId(group.getId());
			userGroup.setName(group.getName());
			userGroupList.add(userGroup);
		}
		return userGroupList;
	}

	public Object getUserGroup(String groupId) {
		List<User> userList = identityService.createUserQuery().memberOfGroup(groupId).list();
		return toMyUser(userList);
	}

	private List<com.yawn.entity.User> toMyUser(List<User> userList) {
		List<com.yawn.entity.User> myUserList = new ArrayList<>();
		for (User user : userList) {
			com.yawn.entity.User myUser = new com.yawn.entity.User();
			myUser.setUserName(user.getId());
			myUser.setPassword(user.getPassword());
			myUserList.add(myUser);
		}
		return myUserList;
	}

	public Object addUser(com.yawn.entity.User user) {
		String userId = user.getUserName();
		String groupId = user.getGroupId();
		User actUser = identityService.newUser(userId);
		actUser.setPassword(user.getPassword());
		identityService.saveUser(actUser);
		identityService.createMembership(userId, groupId);
		return true;
	}
}

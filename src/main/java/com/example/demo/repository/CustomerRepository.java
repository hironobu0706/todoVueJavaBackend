package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CustomerInfoMapper;
import com.example.demo.model.CustomerInfo;
import com.example.demo.model.Login;

@Repository
@Transactional
public class CustomerRepository {
	@Autowired
	private CustomerInfoMapper mapper;

	//全件取得
	public List<CustomerInfo> selectAll(){
		List<CustomerInfo> s = new ArrayList<CustomerInfo>();
		s = mapper.selectAll();
		System.out.println("aaaaaaaaaaaaaaaa4");
		for (CustomerInfo item : s) {
		    System.out.println(item.getId());
		    System.out.println(item.getName());
		    System.out.println(item.getNameKana());
		    System.out.println(item.getPassword());
		    System.out.println(item.getMailAddress());
		}
		
		return s;
	}

	/**
	 * 顧客情報登録サービス
	 * @param todolist
	 * @return 処理件数(1のはず)
	 */
    public int createCustomer(CustomerInfo request) {
        return mapper.createCustomer(request);
    }

	public Login loginAuth(String mailAddress, String password) {
		return mapper.loginAuth(mailAddress, password);
	}
}

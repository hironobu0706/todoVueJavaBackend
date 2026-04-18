package com.example.demo.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.CustomerInfo;
import com.example.demo.model.Login;

@Mapper
public interface CustomerInfoMapper {
    // mapper xmlファイルのselectタグのidと同じ文字列を指定
    //    CustomerInfo selectById();
    List<CustomerInfo> selectAll();
	
	int createCustomer(CustomerInfo request);

	// ログイン機能
	Login loginAuth(String mailAddress, String password);
}

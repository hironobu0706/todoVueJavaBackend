package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerInfo;
import com.example.demo.repository.CustomerRepository;

import request.RequestCustomerForm;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * 全件取得
     * @return 顧客情報全件
     */
	public List<CustomerInfo> selectAll() {
		List<CustomerInfo> responseCustomer = new ArrayList<CustomerInfo>();
		responseCustomer = customerRepository.selectAll();
		if(responseCustomer == null) {
			return null;
		}
		return responseCustomer;
	}

	/**
	 * 顧客情報登録サービス
	 * @param todolist
	 * @return 処理件数(1)
	 */
    public int createCustomer(RequestCustomerForm request) {
    	CustomerInfo entity = toEntity(request);
        return customerRepository.createCustomer(entity);
    }
    
    /**
     * リクエストをエンティティに変換
     */
    private CustomerInfo toEntity(RequestCustomerForm req) {
        CustomerInfo entity = new CustomerInfo();

        // 基本項目コピー
        entity.setMailAddress(req.getMailAddress());
        entity.setPassword(req.getPassword()); // ※後でハッシュ化推奨
        entity.setName(req.getName());
        entity.setNameKana(req.getNameKana());
        entity.setGender(req.getGender());
        entity.setJushoPref(req.getJushoPref());
        entity.setJusho1(req.getJusho1());
        entity.setJusho2(req.getJusho2());

        // DB用の制御項目（業務ロジック）
        Date now = new Date();
        entity.setCreated_at(now);
        entity.setCreated_by("SYSTEM"); // ログインユーザーにするのが理想
        entity.setUpdate_at(now);
        entity.setUpdate_by("SYSTEM");
        entity.setDelete_flg(0); // 0: 未削除

        return entity;
    }
    
    // メールアドレス、パスワードを受け取り
    // ログインテーブルからパラメータのメールアドレス、パスワードに一致するレコード取得
	public CustomerInfo loginAuth(String mailAddress, String password) {
		CustomerInfo responseLogin = new CustomerInfo();
		responseLogin = customerRepository.loginAuth(mailAddress, password);
		if(responseLogin == null) {
			return null;
		}
		return responseLogin;
	}
}

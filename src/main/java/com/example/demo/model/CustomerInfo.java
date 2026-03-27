package com.example.demo.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerInfo {
	private int id;
	private String mailAddress;
	private String password;
	private String name;
	private String nameKana;
	private int gender;
	private String jushoPref;
	private String jusho1;
	private String jusho2;
	private Date created_at;
	private String created_by;
	private Date update_at;
	private String update_by;
	private int delete_flg;
}

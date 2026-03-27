package request;

//import java.io.Serializable;

import lombok.Data;

@Data
public class RequestCustomerForm {//  implements Serializable { // Serializableでsession管理ができる
	private String mailAddress;
	private String password;
	private String name;
	private String nameKana;
	private int gender;
	private String jushoPref;
	private String jusho1;
	private String jusho2;
}

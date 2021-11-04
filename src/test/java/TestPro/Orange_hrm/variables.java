package TestPro.Orange_hrm;

public class variables {
	
	static String url = "https://opensource-demo.orangehrmlive.com/"; 
	static String login_txt = "//*[@id='logInPanelHeading']";
	
	//login page 
	static String email = "//*[@id='txtUsername']";
	static String pass = "//*[@id='txtPassword']"; 
	static String login_btn = "//*[@id='btnLogin']"; 
	
	//Assert success login >>> Home page
	static String welcome = "//*[@id='welcome']"; 
	static String admin_btn = "//*[@id='menu_admin_viewAdminModule']";
	static String add_btn = "//*[@id='btnAdd']";
	
	//Add user
	static String add_header = "//*[@id='UserHeading']"; 
	static String privilege = "//*[@id='systemUser_userType']";
	static String employeeName = "//*[@id='systemUser_employeeName_empName']";
	static String userName = "//*[@id='systemUser_userName']";
	static String status = "//*[@id='systemUser_status']";
	static String userPass = "//*[@id='systemUser_password']";
	static String confPass = "//*[@id='systemUser_confirmPassword']";
	static String save = "//*[@id='btnSave']";
	
	//user module
	static String system_user = "//*[@class='head']";
	static String search_field = "//*[@id='searchSystemUser_userName']";
	static String search_btn = "//*[@id='searchBtn']";
	static String table = "//*[@id='resultTable']";
	static String tabledata_item = "/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr/td[2]/a";
	
	//Edit screen
	static String selectedPriv = "//*[@id='systemUser_userType']";
	static String selectedemployee = "//*[@id='systemUser_employeeName_empName']";
	static String selectedname = "//*[@id='systemUser_userName']";
	static String selectedstatus = "//*[@id='systemUser_status']";
	

	
}

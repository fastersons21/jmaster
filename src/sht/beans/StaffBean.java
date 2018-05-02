package sht.beans;

public class StaffBean {
	private String name;
	private int age;
	private String department;
//	private boolean contracted;

	//引数無しのコンストラクタ→ソース→セッターおよびセッターの生成
	public StaffBean() {//修飾子はpublicにする

	}
//	public boolean isContracted() {
//		return contracted;
//	}

	public String getName() {//戻り値がつく
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public StaffBean(String name,int age, String department) {
		this.name = name;
		this.age = age;
		this.department = department;
	}
	StaffBean bean1 = new StaffBean("山田太郎",30,"営業");//設定した引数に代入する
	StaffBean bean2 = new StaffBean("田中花子",20,"経理");


}

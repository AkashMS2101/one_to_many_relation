package one_to_many_uni2.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sclId;
	private String sclName;
	private String sclAddress;
	@OneToMany
	private List<Student> list ;
	@Override
	public String toString() {
		return "School [sclId=" + sclId + ", sclName=" + sclName + ", sclAddress=" + sclAddress + ", list=" + list
				+ "]";
	}
	public int getSclId() {
		return sclId;
	}
	public void setSclId(int sclId) {
		this.sclId = sclId;
	}
	public String getSclName() {
		return sclName;
	}
	public void setSclName(String sclName) {
		this.sclName = sclName;
	}
	public String getSclAddress() {
		return sclAddress;
	}
	public void setSclAddress(String sclAddress) {
		this.sclAddress = sclAddress;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
}

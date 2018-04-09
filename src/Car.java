import java.util.Date;

public class Car {
	
	private Integer id;
	private String manufacturer;
	private String model;
	private Integer modelYear;
	private String description;
	private Date expireDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public Integer getModelYear() {
		return modelYear;
	}
	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	
}

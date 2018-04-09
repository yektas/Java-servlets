import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {

	private static Connection getConnection() throws Exception{
		Class.forName(DbSettings.driver);
		String dbUrl = DbSettings.protocol + DbSettings.dbName + ";create=true";
		return DriverManager.getConnection(dbUrl, DbSettings.username, DbSettings.password);
	}
	
	public static boolean createDb() {
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String sql = "CREATE TABLE Car(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ " manufacturer VARCHAR(50), model VARCHAR(100), modelYear INTEGER,"
					+ " description VARCHAR(255), expire_date DATE)";
			statement.execute(sql);
			connection.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteCar(int id) {
			
		try {
			Connection connection = getConnection();
			String sql = "DELETE FROM Car WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			connection.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<Car> getCarsInOrder(String sortingColumn){
		List<Car> cars = new ArrayList<Car>();
		
		try {
			Connection connection = getConnection();
			String sql = String.format("SELECT * FROM Car ORDER BY %s ASC", sortingColumn);
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();						
			while(rs.next()){
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setManufacturer(rs.getString("manufacturer"));
				car.setModel(rs.getString("model"));
				car.setModelYear(rs.getInt("modelYear"));
				car.setDescription(rs.getString("description"));
				car.setExpireDate(rs.getDate("expire_date"));
				
				cars.add(car);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;	
	}
	
	public static List<Car> getCars(){
		List<Car> cars = new ArrayList<Car>();
		
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM Car";
			
			ResultSet rs = statement.executeQuery(sql);						
			while(rs.next()){
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setManufacturer(rs.getString("manufacturer"));
				car.setModel(rs.getString("model"));
				car.setModelYear(rs.getInt("modelYear"));
				car.setDescription(rs.getString("description"));
				car.setExpireDate(rs.getDate("expire_date"));
				
				cars.add(car);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;	
	}
	
	public static Car getCarById(int id) {
		Car car = new Car();
		try {
			Connection connection = getConnection();
			String sql = "SELECT * FROM Car WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();	
				
			if (rs.next()) {
				car.setId(rs.getInt("id"));
				car.setManufacturer(rs.getString("manufacturer"));
				car.setModel(rs.getString("model"));
				car.setModelYear(rs.getInt("modelYear"));
				car.setDescription(rs.getString("description"));
				car.setExpireDate(rs.getDate("expire_date"));
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}
	
	public static boolean updateCar(Car car) {
		
		try {
			Connection connection = getConnection();
			String sql = "UPDATE Car SET manufacturer=?, model=?, modelYear=?, description=?, expire_date=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, car.getManufacturer());
			statement.setString(2, car.getModel());
			statement.setInt(3, car.getModelYear());
			statement.setString(4, car.getDescription());
			statement.setDate(5, new Date(car.getExpireDate().getTime()));
			statement.setInt(6, car.getId());
			statement.executeUpdate();
			connection.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean saveCar(Car car){
		
		try {
			Connection connection = getConnection();
			String sql = "INSERT INTO Car(manufacturer, model, modelYear, description, expire_date) VALUES(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, car.getManufacturer());
			statement.setString(2, car.getModel());
			statement.setInt(3, car.getModelYear());
			statement.setString(4, car.getDescription());
			statement.setDate(5, new Date(car.getExpireDate().getTime()));			
			statement.executeUpdate(); 
			connection.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
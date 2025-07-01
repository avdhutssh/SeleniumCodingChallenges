package SeleniumAdvanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _07_DataBaseHandling {

	public final String query = "SELECT MAX(base_salary) AS secondHighestSalary FROM salary WHERE base_salary < (SELECT MAX(base_salary) FROM salary);";
	public final String url = "jdbc:mysql://localhost:3306/employee_management";
	public final String username = "root";
	public final String pwd = "12345678";
	long secondHighestDSalary;

	@Test
	public void test_DB() throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, pwd);
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery(query);
		while (result.next()) {
			secondHighestDSalary = result.getLong("secondHighestSalary");
		}
		System.out.println(secondHighestDSalary);
		Assert.assertEquals(secondHighestDSalary, 75000);
		conn.close();

	}
}

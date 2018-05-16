import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class ConnectionTest {

    private Statement statement;
    private Connection connection;


//3
    //Написать тесты для проверки корректности добавления, обновления и чтения записей.
    //Следует учесть, что в базе есть заранее добавленные записи, и после проведения тестов
    //они не должны быть удалены, изменены или добавлены вновь.

    @Before
    public void startTest(){
        statement = Main.getStatement();
        connection = Main.getConnection();
        Main.connect();
    }

    @After
    public void endTest(){
        Main.disconnect();
    }

//test not pass!
    @Test()
    public void testAdd(){
        try {
            statement = connection.createStatement();
            //PreparedStatement ps = connection.prepareStatement("INSERT INTO students (фамилия, балл) VALUES ('петручик', 55)");
            Assert.assertTrue(statement.execute("INSERT INTO students (фамилия, балл) VALUES ('петручик', 55)"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test()
    public void testUpdate(){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE students SET балл = ? WHERE фамилия = ?");
            ps.setInt(1, 100);
            ps.setString(2, "'петручик'");
            Assert.assertEquals(1,ps.executeUpdate());
            } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test()
    public void testRead(){

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM sudents WHERE фамилия = ? and балл = ?");
            ps.setString(1, "'петручик'");
            ps.setInt(2, 100);
            ResultSet rs = ps.executeQuery();
            String out = "петручик";
            Assert.assertEquals(out, rs.getString("фамилия"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static Connection connection;
    private static Statement statement;

    static Connection getConnection() {
        return connection;
    }

    static Statement getStatement() {
        return statement;
    }

    public static void main(String[] args) {


    }

    //1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив,
    // метод должен вернуть новый массив, который получен путем вытаскивания элементов из исходного массива,
    // идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, в противном
    // случае в методе необходимо выбросить RuntimeException.

    static <T> Object [] separateTo(T[] inputArr, T separator){

        ArrayList<T> data = new ArrayList<>(Arrays.asList(inputArr));

        if(data.contains(separator)) {
            data.subList(0, data.lastIndexOf(separator) + 1).clear();
        }else{
            throw new RuntimeException("Separator not found");
        }

        return data.toArray();
    }


    //2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной
    //четверки или единицы, то метод вернет false​; Написать набор тестов для этого метода (по 3-4
    //варианта входных данных).

    @SafeVarargs
    static <T> boolean  existsArgs(T[] inputArr, T... args){

        ArrayList<T> arguments = new ArrayList<>(Arrays.asList(args));
        ArrayList<T> data = new ArrayList<>(Arrays.asList(inputArr));
        return data.containsAll(arguments);
    }

    //3. Создать небольшую базу данных. Таблица «Студенты» с полями id, фамилия, балл​).
    //Написать тесты для проверки корректности добавления, обновления и чтения записей.
    //Следует учесть, что в базе есть заранее добавленные записи, и после проведения тестов
    //они не должны быть удалены, изменены или добавлены вновь.


    static void connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Database.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

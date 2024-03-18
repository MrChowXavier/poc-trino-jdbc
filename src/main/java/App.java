import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: App
 * @Description: App
 * @Author: xuezhouyi
 * @Version: V1.0
 **/
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        teradata();
        trino();
    }

    private static void teradata() throws ClassNotFoundException, SQLException {
        Class.forName("com.teradata.jdbc.TeraDriver");
        final Connection connection = DriverManager.getConnection("jdbc:teradata://", "", "");
        final DatabaseMetaData metaData = connection.getMetaData();
        final ResultSet resultSet= metaData.getColumns(null, "schema", "table", "column");
        while (resultSet.next()) {
            final String colmun = resultSet.getString("colmun");
            System.out.println("CoumnName:" + colmun);
        }

    }
    private static void trino() throws ClassNotFoundException, SQLException {
        Class.forName("io.trino.jdbc.TrinoDriver");
        final Connection connection = DriverManager.getConnection("jdbc:trino://", "", "");
        final DatabaseMetaData metaData = connection.getMetaData();
        final ResultSet resultSet= metaData.getColumns(null, "schema", "table", "column");
        while (resultSet.next()) {
            final String colmun = resultSet.getString("colmun");
            System.out.println("CoumnName:" + colmun);
        }
    }
}

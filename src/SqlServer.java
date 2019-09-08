import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class SqlServer {

    public static void main(String[] args)
    {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet result = null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=master";
            String user = "sa";
            String password = "milan";
            con = DriverManager.getConnection(url, user, password);

            String sql = "select * from  MSreplication_options";
            pre = con.prepareStatement(sql);
            result = pre.executeQuery();
            while (result.next()) {
                System.out.println(result.getString(1)+"\t"+result.getString(2)
                        +"\t"+result.getString(3)+"\t"+result.getString(4)
                        +"\t"+result.getString(5)
                );
            }
            if (result != null)
                result.close();
            if (pre != null)
                pre.close();



            if (con != null)
                con.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

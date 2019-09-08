import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Oracle {

    public static void main(String[] args)
    {
            Connection con = null;
            PreparedStatement pre = null;
            ResultSet result = null;
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
                String user = "system";
                String password = "milan";
                con = DriverManager.getConnection(url, user, password);

                String sql = "select owner,object_name,object_id, object_type , created from dba_objects where rownum <=11";
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

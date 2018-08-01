package sample;
import java.sql.*;
public class DatabaseHandler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws Exception {
        String connectionString= "jdbc:mysql://" + dbHost + ":" + dbPort +"/" +dbName + "?" +
                "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection=DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User user){
        String insert="INSERT INTO "+ Const.USER_TABLE+"("+Const.USERS_FIRSTNAME+","+Const.USERS_LASTNAME+","+
                Const.USERS_USERNAME+","+Const.USERS_PASSWORD+","+Const.USERS_LOCATION+","+Const.USERS_GENDER+")"+ "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement st = getDbConnection().prepareStatement(insert);
            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setString(3, user.getUserName());
            st.setString(4, user.getPassword());
            st.setString(5, user.getLocation());
            st.setString(6, user.getGender());
            st.executeUpdate();

        }
        catch(Exception ex){ex.printStackTrace();}
    }

    public ResultSet getUser(User user){
        ResultSet resSet= null;
        String select= "SELECT * FROM "+ Const.USER_TABLE+ " WHERE "+ Const.USERS_USERNAME+"=? AND "+Const.USERS_PASSWORD + "=? ";
try {
    PreparedStatement st= getDbConnection().prepareStatement(select);
    st.setString(1, user.getUserName());
    st.setString(2, user.getPassword());
    resSet=st.executeQuery();

}catch(Exception ex){ex.printStackTrace();}

        return resSet;
    }

}




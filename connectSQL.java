package conexionBDL;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class connectSQL {
    
   public Connection conexion;
   public Statement sentencia;
   public ResultSet resultado;
   
    
   public void ConectarBaseDeDatos (){
        
        try {
           final String Controlador = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
           Class.forName(Controlador);
           final String url_bd = "jdbc:sqlserver://localhost:1433;databaseName=login";
           conexion = DriverManager.getConnection(url_bd,"sa", "akina12");
           sentencia = conexion.createStatement();
         
       } catch (ClassNotFoundException | SQLException ex) {
           
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
           
       }
      
       }
   public void DesconectarBaseDeDatos (){
       
       try {
           if (conexion != null){
               if(sentencia !=null){
                   sentencia.close();
               }
               conexion.close();
           }
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
           
       }
   }
   
    public Connection getConnection (){
        return conexion;
    }

}






    
    


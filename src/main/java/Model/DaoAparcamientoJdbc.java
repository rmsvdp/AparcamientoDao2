package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.fasterxml.jackson.databind.DeserializationFeature;




public class DaoAparcamientoJdbc extends DaoJdbc implements DaoList<Aparcamiento>{

	public ArrayList<Aparcamiento> listaAparcamientos = new ArrayList<Aparcamiento>();
	public DaoAparcamientoJdbc() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Aparcamiento> findAll(){
		return listaAparcamientos;
	}
	public Aparcamiento findOne(String key) {
		// TODO implementar
		return null;
	}
	public boolean insertOne(Aparcamiento ap) {
		boolean result = false;
		listaAparcamientos.add(ap);             // Gestiona memoria
                Connection c = getConn();
                if (c!=null){
                
                    try {
                        
                        // Insertar objeto aparcamiento
                        String ssql = "INSERT INTO aparcamientos (nombre,numfilas,numcolumnas) ";
                        ssql = ssql + " VALUES (?,?,?)";
                        PreparedStatement pstm = c.prepareStatement(ssql);
                        pstm.setString(1,ap.getNombre());
                        pstm.setInt(2,ap.getNumFilas());
                        pstm.setInt(3,ap.getNumColumnas());
                        pstm.execute();
                    } catch (SQLException ex) {
                        Logger.getLogger(DaoAparcamientoJdbc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
		return result;					

	}
	public boolean deleteOne(String key) {
		// TODO implementar
		return true;
	}
	public boolean updateOne(String key,Aparcamiento t) {
		// TODO implementar
		return true;
	}

}

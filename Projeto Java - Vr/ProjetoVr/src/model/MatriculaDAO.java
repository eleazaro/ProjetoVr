/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class MatriculaDAO {
                
    public List<ClassMatricula> read(ClassAluno a){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null; 
        List<ClassMatricula> matriculas = new ArrayList<>();
        
        try {
            stmt = (PreparedStatement) con.prepareStatement(
                    "SELECT CA.CODIGO, CODIGO_CURSO, CODIGO_ALUNO, C.DESCRICAO, A.NOME, C.EMENTA "
                    + " FROM CURSO_ALUNO CA"
                    + " JOIN CURSO C ON C.CODIGO = CA.CODIGO_CURSO"
                    + " JOIN ALUNO A ON A.CODIGO = CA.CODIGO_ALUNO"
                    + " AND  A.CODIGO = ?");
            
            stmt.setInt(1, a.getCodigo());
            result = stmt.executeQuery();
            
            while (result.next()) {
                
                ClassMatricula matricula = new ClassMatricula();
                
                matricula.setCodigo(result.getInt("CODIGO"));
                matricula.setCodigo_curso(result.getInt("CODIGO_CURSO"));
                matricula.setDescricao(result.getString("DESCRICAO"));
                matricula.setEmenta(result.getString("EMENTA"));
                
                matriculas.add(matricula);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível listar os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return matriculas;
    }
    
    public void create(ClassCurso c, ClassAluno a){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            System.out.println(c.getCodigo());
            System.out.println(a.getCodigo());
            
            stmt =  (PreparedStatement) con.prepareStatement("INSERT INTO CURSO_ALUNO (CODIGO_CURSO,CODIGO_ALUNO)VALUES(?,?)");
            stmt.setInt(1, c.getCodigo());
            stmt.setInt(2, a.getCodigo());
            stmt.executeUpdate();
              
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível inserir os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
        public void delete(ClassMatricula m){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt =  (PreparedStatement) con.prepareStatement("DELETE FROM CURSO_ALUNO WHERE CODIGO = ?");
            stmt.setInt(1, m.getCodigo());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível excluir os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}



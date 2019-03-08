/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class CursoDAO {
    
    public void create(ClassCurso c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt =  (PreparedStatement) con.prepareStatement("INSERT INTO CURSO (DESCRICAO,EMENTA)VALUES(?,?)");
            stmt.setString(1, c.getDescricao());
            stmt.setString(2, c.getEmenta());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");   
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível inserir os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<ClassCurso> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        List<ClassCurso> cursos = new ArrayList<>();
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM CURSO");
            result = stmt.executeQuery();
            
            while (result.next()) {
                
                ClassCurso curso = new ClassCurso();
                
                curso.setCodigo(result.getInt("CODIGO"));
                curso.setDescricao(result.getString("DESCRICAO"));
                curso.setEmenta(result.getString("EMENTA"));
                
                cursos.add(curso);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível listar os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return cursos;
    }
    
    public List<ClassCurso> readDisp(ClassAluno a){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null; 
        List<ClassCurso> cursos = new ArrayList<>();
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM CURSO "
                    + "                                     WHERE CODIGO NOT IN (SELECT CODIGO_CURSO FROM CURSO_ALUNO "
                    + "                                                          WHERE CODIGO_ALUNO = ?)");
            stmt.setInt(1, a.getCodigo());
            result = stmt.executeQuery();
            
            while (result.next()) {
                
                ClassCurso curso = new ClassCurso();
                
                curso.setCodigo(result.getInt("CODIGO"));
                curso.setDescricao(result.getString("DESCRICAO"));
                curso.setEmenta(result.getString("EMENTA"));
                
                cursos.add(curso);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível listar os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return cursos;
    }
    
    public void update(ClassCurso c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt =  (PreparedStatement) con.prepareStatement("UPDATE CURSO SET DESCRICAO = ?, EMENTA = ? WHERE CODIGO = ?");
            stmt.setString(1, c.getDescricao());
            stmt.setString(2, c.getEmenta());
            stmt.setInt(3, c.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível alterar os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(ClassCurso c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt =  (PreparedStatement) con.prepareStatement("DELETE FROM CURSO WHERE CODIGO = ?");
            stmt.setInt(1, c.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível excluir os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
    }

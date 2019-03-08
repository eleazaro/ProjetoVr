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
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class AlunoDAO {
    
    public void create (ClassAluno a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt =  (PreparedStatement) con.prepareStatement("INSERT INTO ALUNO (NOME)VALUES(?)");
            stmt.setString(1, a.getNome());
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível inserir os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<ClassAluno> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        List<ClassAluno> alunos = new ArrayList<>();
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM ALUNO");
            result = stmt.executeQuery();
            
            while (result.next()) {
                
                ClassAluno aluno = new ClassAluno();
                
                aluno.setCodigo(result.getInt("CODIGO"));
                aluno.setNome(result.getString("NOME"));
                
                alunos.add(aluno);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível listar os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return alunos;
    }
    
    public void update(ClassAluno a){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt =  (PreparedStatement) con.prepareStatement("UPDATE ALUNO SET NOME = ? WHERE CODIGO = ?");
            stmt.setString(1, a.getNome());
            stmt.setInt(2, a.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível alterar os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(ClassAluno a){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt =  (PreparedStatement) con.prepareStatement("DELETE FROM ALUNO WHERE CODIGO = ?");
            stmt.setInt(1, a.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível excluir os dados: ", ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}

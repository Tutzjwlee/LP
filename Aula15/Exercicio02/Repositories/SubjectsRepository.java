package Exercicio02.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exercicio02.Models.SubjectModel;
import Exercicio02.DAL.ConnFactory;

import java.util.ArrayList;

public class SubjectsRepository {
    Connection conn;

    public SubjectsRepository() {
        this.conn = ConnFactory.getConn();
    }

    public void addSubject(String name) {
        String command = "INSERT INTO tb_subject(subject) VALUES(?)";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {

            stmt = conn.prepareStatement(command);
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao incluir os dados");
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }
    public ArrayList<SubjectModel> GetAllSubjects() {
        String command = "SELECT * FROM tb_subject";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        ArrayList<SubjectModel> subjects = new ArrayList<SubjectModel>();
        try {
            stmt = conn.prepareStatement(command);
            ResultSet result = stmt.executeQuery();
            subjects = this.getValues(result);
        } catch (SQLException e) {
            System.out.println("Erro ao incluir os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
        return subjects;
    }
    private ArrayList<SubjectModel> getValues(ResultSet resultSet) {
        ArrayList<SubjectModel> values = new ArrayList<SubjectModel>();
        try {
            while (resultSet.next()) {
                SubjectModel subject = new SubjectModel(resultSet.getInt(1),resultSet.getString(2));
                values.add(subject);
            }

        } catch (Exception e) {
            throw new RuntimeException("Deu tudo errado");
        }
        return values;
    }

}
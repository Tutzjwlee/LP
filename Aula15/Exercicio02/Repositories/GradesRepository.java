package Exercicio02.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exercicio02.DAL.ConnFactory;
import Exercicio02.Models.GradesModel;

public class GradesRepository {
    Connection conn;

    public GradesRepository() {
        this.conn = ConnFactory.getConn();
    }

    public void addGrade() {
        String command = "INSERT INTO tb_grades(ID_USER,ID_SUBJECT,EXAMTYPE,GRADE) VALUES(?,?,?,?)";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {

            stmt = conn.prepareStatement(command);
            // stmt.setString(1, TelaPrincipalNotas.materia1.getText());
            // stmt.setFloat(2, Float.parseFloat(panel.p1Text.getText()));
            // stmt.setFloat(3, Float.parseFloat(panel.p2Text.getText()));
            // stmt.setFloat(4, Float.parseFloat(panel.t1Text.getText()));
            // stmt.setFloat(5, Float.parseFloat(panel.p3Text.getText()));
            // stmt.setFloat(6, Float.parseFloat(panel.p4Text.getText()));
            // stmt.setFloat(7, Float.parseFloat(panel.t2Text.getText()));
            // stmt.setFloat(8, Float.parseFloat(panel.mediaProvaText.getText()));
            // stmt.setFloat(9, Float.parseFloat(panel.mediaTrabalhoText.getText()));
            // stmt.setFloat(10, Float.parseFloat(panel.mediaFinalText.getText()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao incluir os dados");
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public ArrayList<GradesModel> getUserGrades(int usernameID) {
        String command = "SELECT * FROM tb_exams WHERE ID_USER = '" + usernameID + "'" ;
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        ArrayList<GradesModel> grades = new ArrayList<GradesModel>();
        try {
            stmt = conn.prepareStatement(command);
            ResultSet result = stmt.executeQuery();
            grades = this.getValues(result);
        } catch (SQLException e) {
            System.out.println("Erro ao incluir os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
        return grades;
    }

    private ArrayList<GradesModel> getValues(ResultSet resultSet) {
        ArrayList<GradesModel> values = new ArrayList<GradesModel>();
        try {
            while (resultSet.next()) {
                GradesModel subject = new GradesModel(resultSet.getInt(2), resultSet.getInt(3), resultSet.getFloat(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getFloat(7)
                ,resultSet.getFloat(8), resultSet.getFloat(9), resultSet.getFloat(10), resultSet.getFloat(11));
                values.add(subject);
            }

        } catch (Exception e) {
            throw new RuntimeException("Deu tudo errado");
        }
        return values;
    }
}
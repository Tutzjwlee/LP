package Exercicio02.Visualization.Grades.Telas;

import Exercicio02.Models.GradesModel;
import Exercicio02.Services.ReportCardService;
import Exercicio02.Visualization.Grades.Panels.GradesScrollPanel;
import Exercicio02.Visualization.Login.Telas.TelaLogin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class TelaNotasUser extends JFrame {

    public TelaNotasUser() {
        super();
        this.setBounds(0, 0, 1280, 720);
        this.setLayout(null);

        ReportCardService reportCardService = new ReportCardService();
        reportCardService.setupCardReport();
        ArrayList<GradesModel> userGrades = reportCardService.gradesRepository.getUserGrades(TelaLogin.userName_ID);

        JPanel insidePanel = new JPanel();
        insidePanel.setPreferredSize(new Dimension(700, 300));
        insidePanel.setBackground(Color.GREEN);
        insidePanel.setLayout(new GridLayout(userGrades.size(),1));

        GradesScrollPanel scrollPanel = new GradesScrollPanel(insidePanel);
        scrollPanel.setLocation(100, 200);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Remodelar aqui!!!!
        int i = 0;
        for (GradesModel gradesModel : userGrades) {

            // JPanel subjectPanel = new JPanel();
            // subjectPanel.setBounds(20, 60 + (i * 30), 100, 40);
            // subjectPanel.setLayout(new GridLayout(1, 1));
            // subjectPanel.setBackground(Color.RED);
            // insidePanel.add(subjectPanel);

            // JLabel subject = new JLabel(reportCardService.subjectsMap.get(gradesModel.getSubjectID()));
            // subject.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
            // subjectPanel.add(subject);

            JPanel gradePanel = new JPanel();
            gradePanel.setLayout(new GridLayout(1, 9));
            gradePanel.setBounds(100, 60 + (i * 30), 500, 40);
            gradePanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
            // gradePanel.setBackground(Color.blue);
            insidePanel.add(gradePanel);

            JLabel subject = new JLabel(reportCardService.subjectsMap.get(gradesModel.getSubjectID()));
            subject.setHorizontalAlignment(SwingConstants.CENTER);
            subject.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            gradePanel.add(subject);

            JLabel P1 = new JLabel("" + gradesModel.getP1());
            P1.setHorizontalAlignment(SwingConstants.CENTER);
            P1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            gradePanel.add(P1);

            JLabel P2 = new JLabel("" + gradesModel.getP2());
            P2.setHorizontalAlignment(SwingConstants.CENTER);
            P2.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            gradePanel.add(P2);

            JLabel T1 = new JLabel("" + gradesModel.getT1());
            T1.setHorizontalAlignment(SwingConstants.CENTER);
            T1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            gradePanel.add(T1);

            JLabel T2 = new JLabel("" + gradesModel.getT2());
            T2.setHorizontalAlignment(SwingConstants.CENTER);
            T2.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            gradePanel.add(T2);

            JLabel P3 = new JLabel("" + gradesModel.getP3());
            P3.setHorizontalAlignment(SwingConstants.CENTER);
            P3.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            gradePanel.add(P3);

            JLabel P4 = new JLabel("" + gradesModel.getP4());
            P4.setHorizontalAlignment(SwingConstants.CENTER);
            P4.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            gradePanel.add(P4);

            JLabel T3 = new JLabel("" + gradesModel.getT3());
            T3.setHorizontalAlignment(SwingConstants.CENTER);
            T3.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            gradePanel.add(T3);

            JLabel T4 = new JLabel("" + gradesModel.getT4());
            T4.setHorizontalAlignment(SwingConstants.CENTER);
            T4.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            gradePanel.add(T4);
            i++;
        }

        this.add(scrollPanel);
        this.setVisible(true);
    }
}

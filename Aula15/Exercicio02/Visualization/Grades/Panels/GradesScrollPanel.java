package Exercicio02.Visualization.Grades.Panels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GradesScrollPanel extends JScrollPane {

    public GradesScrollPanel(JPanel insidePanel) {
        super(insidePanel);
        this.setBounds(0, 0, 1100, 400);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setBackground(Color.red);
        this.setVisible(true);
        this.setOpaque(true);
    }
}

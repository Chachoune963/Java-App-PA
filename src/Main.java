import Classes.Company;
import Classes.User;
import GraphicComponents.PieChart;
import Handlers.HttpCommunicator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(dim.width * 2/3, dim.height * 2/3);
        frame.setLocation((dim.width - frame.getWidth())/2, (dim.height - frame.getHeight())/2);
        frame.setLayout(null);

        List<Company> companies = HttpCommunicator.getAllCompanies();

        for (int i = 0; i < companies.size(); ++i)
        {
            JLabel name = new JLabel(companies.get(i).getName());
            name.setBounds(
                    (i * frame.getWidth()/5) % frame.getWidth(),
                    Math.round(i/5) * frame.getHeight()/3,
                    frame.getWidth()/5,
                    (frame.getHeight()/5) * 1/5);

            HashMap<Integer, Integer> teamsMap = new HashMap<Integer, Integer>();
            List<User> curUsers = companies.get(i).getEmployees();
            for (int j = 0; j < curUsers.size(); ++j)
            {
                int id_team = curUsers.get(j).getId_team();
                if (teamsMap.containsKey(id_team))
                {
                    teamsMap.put(id_team, teamsMap.get(id_team) + 1);
                } else {
                    teamsMap.put(id_team, 1);
                }
            }

            List<Double> teamsData = new ArrayList<>();
            teamsMap.forEach(new BiConsumer<Integer, Integer>() {
                @Override
                public void accept(Integer integer, Integer integer2) {
                    teamsData.add((double)integer2);
                }
            });

            List<Color> teamsColors = new ArrayList<>();
            teamsColors.add(Color.BLUE);
            teamsColors.add(Color.RED);
            teamsColors.add(Color.GREEN);
            teamsColors.add(Color.YELLOW);

            PieChart pieChart = new PieChart(teamsData, teamsColors);
            pieChart.setBounds(
                    (i * frame.getWidth()/5) % frame.getWidth(),
                    (Math.round(i/5) * frame.getHeight()/3) + (frame.getHeight()/5) * 1/5,
                    frame.getWidth()/5,
                    (frame.getHeight()/5) * 4/5
            );

            frame.add(name);
            frame.add(pieChart);
        }

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
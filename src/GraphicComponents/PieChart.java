package GraphicComponents;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PieChart extends JPanel {
    private List<Double> data;
    private List<Color> colors;

    public PieChart(List<Double> data, List<Color> colors) {
        this.data = data;
        this.colors = colors;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        double total = 0;
        for (int i = 0; i < data.size(); ++i)
        {
            total += data.get(i);
        }

        double startAngle = 0;
        for (int i = 0; i < data.size(); ++i)
        {
            double arcAngle = data.get(i) / total * 360;
            g.setColor(colors.get(i % colors.size()));
            g.fillArc(0, 0, getHeight(), getHeight(), (int)Math.round(startAngle), (int)Math.round(arcAngle));
            startAngle += arcAngle;
        }
    }
}

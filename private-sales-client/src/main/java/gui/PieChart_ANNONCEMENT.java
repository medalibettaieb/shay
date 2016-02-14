package gui;

import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import delegate.AnnoncementDelegate;
import entities.Annoncement;

public class PieChart_ANNONCEMENT extends ApplicationFrame {
	static List<Annoncement> annoncements = AnnoncementDelegate.doFindAllAnnoncements();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PieChart_ANNONCEMENT(String title) {
		super(title);
		setContentPane(createDemoPanel());
	}

	private static PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("annoncement 1", new Double(20));
		dataset.setValue("annoncement 2", new Double(40));
		dataset.setValue("annoncement 3", new Double(10));
		for (Annoncement a : annoncements) {
			dataset.setValue(a.getName(), a.getCommentaires().size());
		}
		return dataset;
	}

	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("Annoucement Sales", // chart
				// title
				dataset, // data
				true, // include legend
				true, false);

		return chart;
	}

	public static JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}

	public static void main(String[] args) {
		PieChart_ANNONCEMENT demo = new PieChart_ANNONCEMENT("annoncement commentaires");
		demo.setSize(560, 367);
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}
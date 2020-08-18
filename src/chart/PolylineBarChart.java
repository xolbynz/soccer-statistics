package chart;

import java.awt.BasicStroke;

import java.awt.Color;

import java.awt.Font;

import java.awt.GradientPaint;

import java.awt.Paint;

import org.jfree.chart.ChartFrame;

import org.jfree.chart.JFreeChart;

import org.jfree.chart.axis.CategoryAxis;

import org.jfree.chart.axis.CategoryLabelPositions;

import org.jfree.chart.axis.NumberAxis;

import org.jfree.chart.labels.CategoryItemLabelGenerator;

import org.jfree.chart.labels.ItemLabelAnchor;

import org.jfree.chart.labels.ItemLabelPosition;

import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;

import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.DatasetRenderingOrder;

import org.jfree.chart.plot.PlotOrientation;

import org.jfree.chart.renderer.category.BarRenderer;

import org.jfree.chart.renderer.category.CategoryItemRenderer;

import org.jfree.chart.renderer.category.LineAndShapeRenderer;

import org.jfree.chart.renderer.category.StandardBarPainter;

import org.jfree.chart.title.TextTitle;

import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.ui.GradientPaintTransformType;

import org.jfree.ui.HorizontalAlignment;

import org.jfree.ui.StandardGradientPaintTransformer;

import org.jfree.ui.TextAnchor;

/**
 * 
 * A simple demonstration application showing how to create a bar chart overlaid
 * 
 * with a line chart.
 * 
 */

public class PolylineBarChart {

	// Run As > Java Application ���� �����ϸ� �ٷ� Ȯ���� �� ����.

	public static void main(final String[] args) {

		PolylineBarChart demo = new PolylineBarChart();

		JFreeChart chart = demo.getChart();

		ChartFrame frame1 = new ChartFrame("Bar Chart", chart);

		frame1.setSize(800, 400);

		frame1.setVisible(true);

	}

	public JFreeChart getChart() {

		// ������ ����

		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); // bar chart 1

//		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset(); // line chart 1

		// ������ �Է� ( ��, ����, ī�װ� )

		// �� �׷��� 

		dataset1.addValue(1.0, "S1", "1��");

		dataset1.addValue(4.0, "S1", "2��");

		dataset1.addValue(3.0, "S1", "3��");

		dataset1.addValue(5.0, "S1", "4��");

		dataset1.addValue(5.0, "S1", "5��");

		dataset1.addValue(7.0, "S1", "6��");

		dataset1.addValue(7.0, "S1", "7��");

		dataset1.addValue(8.0, "S1", "8��");

		dataset1.addValue(0, "S1", "9��");

		dataset1.addValue(0, "S1", "10��");

		dataset1.addValue(0, "S1", "11��");

		dataset1.addValue(0, "S1", "12��");

		
		// ���α׷���

//		dataset2.addValue(9.0, "T1", "1��");
//
//		dataset2.addValue(7.0, "T1", "2��");
//
//		dataset2.addValue(2.0, "T1", "3��");
//
//		dataset2.addValue(6.0, "T1", "4��");
//
//		dataset2.addValue(6.0, "T1", "5��");
//
//		dataset2.addValue(9.0, "T1", "6��");
//
//		dataset2.addValue(5.0, "T1", "7��");
//
//		dataset2.addValue(4.0, "T1", "8��");
//
//		dataset2.addValue(8.0, "T1", "9��");
//
//		dataset2.addValue(8.0, "T1", "10��");
//
//		dataset2.addValue(8.0, "T1", "11��");
//
//		dataset2.addValue(8.0, "T1", "12��");

		// ������ ���� �� ����

		// ������ ����	

		final BarRenderer renderer = new BarRenderer();

//		final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();

		// ���� �ɼ� ����

		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();

		final ItemLabelPosition p_center = new ItemLabelPosition(

				ItemLabelAnchor.CENTER, TextAnchor.CENTER

		);

		final ItemLabelPosition p_below = new ItemLabelPosition(

				ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT

		);

		Font f = new Font("KBIZ�Ѹ������ H", Font.BOLD, 14);

		Font axisF = new Font("KBIZ�Ѹ������ H", Font.PLAIN, 14);

		// ������ ����

		// �׷��� 1

		renderer.setBaseItemLabelGenerator(generator);

		renderer.setBaseItemLabelsVisible(true);

		renderer.setBasePositiveItemLabelPosition(p_center);

		renderer.setBaseItemLabelFont(f);

//        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//                GradientPaintTransformType.VERTICAL));

//        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));

		renderer.setSeriesPaint(0, new Color(0, 162, 255));

		// ���� �׷��� 

//		renderer2.setBaseItemLabelGenerator(generator);
//
//		renderer2.setBaseItemLabelsVisible(true);
//
//		renderer2.setBaseShapesVisible(true);
//
//		renderer2.setDrawOutlines(true);
//
//		renderer2.setUseFillPaint(true);
//
//		renderer2.setBaseFillPaint(Color.WHITE);
//
//		renderer2.setBaseItemLabelFont(f);
//
//		renderer2.setBasePositiveItemLabelPosition(p_below);
//
//		renderer2.setSeriesPaint(0, new Color(219, 121, 22));
//
//		renderer2.setSeriesStroke(0, new BasicStroke(
//
//				2.0f,
//
//				BasicStroke.CAP_ROUND,
//
//				BasicStroke.JOIN_ROUND,
//
//				3.0f)
//
//		);

		// plot ����

		final CategoryPlot plot = new CategoryPlot();

		// plot �� ������ ����

		plot.setDataset(dataset1);

		plot.setRenderer(renderer);


//		plot.setDataset(2, dataset2);
//
//		plot.setRenderer(2, renderer2);

		// plot �⺻ ����

		plot.setOrientation(PlotOrientation.VERTICAL); // �׷��� ǥ�� ����

		plot.setRangeGridlinesVisible(true); // X�� ���̵� ���� ǥ�ÿ���

		plot.setDomainGridlinesVisible(true); // Y�� ���̵� ���� ǥ�ÿ���

		// ������ ���� ���� : dataset ��� ������� ������ ( ��, ���� ����Ѱ� �Ʒ��� �� )

		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

		// X�� ����

		plot.setDomainAxis(new CategoryAxis()); // X�� ���� ����

		plot.getDomainAxis().setTickLabelFont(axisF); // X�� ���ݶ� ��Ʈ ����

		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // ī�װ� �� ��ġ ����

		// Y�� ����

		plot.setRangeAxis(new NumberAxis()); // Y�� ���� ����

		plot.getRangeAxis().setTickLabelFont(axisF); // Y�� ���ݶ� ��Ʈ ����

		// ���õ� plot�� �������� chart ����

		final JFreeChart chart = new JFreeChart(plot);

//        chart.setTitle("Overlaid Bar Chart"); // ��Ʈ Ÿ��Ʋ

//        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));

//        copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);

//        chart.addSubtitle(copyright);  // ��Ʈ ���� Ÿ��Ʋ

		return chart;

	}

}

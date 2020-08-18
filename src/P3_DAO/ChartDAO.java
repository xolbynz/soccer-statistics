package P3_DAO;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
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
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.TextAnchor;

import P4_DTO.PlayerContestDTO;
import P4_DTO.Player_FootballDTO;

public class ChartDAO {
	String[] PlayerFootball = { "���ǵ�", "��", "�н�", "�帮��", "����" };
	ArrayList<Player_FootballDTO> arrFootball_Recent = new ArrayList<Player_FootballDTO>();
	String[] num = { "4����", "3����", "2����", "1����", "�̹���" };
	

	public JFreeChart getChart_Football(ArrayList<Player_FootballDTO> arr) {
		// ������ ����
		int data[] = new int[5];
		data[0] = arr.get(0).getPlayer_Football_Speed();
		data[1] = arr.get(0).getPlayer_Football_Shoot();
		data[2] = arr.get(0).getPlayer_Football_Pass();
		data[3] = arr.get(0).getPlayer_Football_Dribol();
		data[4] = arr.get(0).getPlayer_Football_Defense();

		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); // bar chart 1
		for (int i = 0; i < PlayerFootball.length; i++) {
			dataset1.addValue(data[i], "�౸ �ɷ�", PlayerFootball[i]);
		}
		final BarRenderer renderer = new BarRenderer();
		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
		final ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
		final ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);
		Font f = new Font("KBIZ�Ѹ������ H", Font.BOLD, 14);
		Font axisF = new Font("KBIZ�Ѹ������ H", Font.PLAIN, 14);
		renderer.setBaseItemLabelGenerator(generator);
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBasePositiveItemLabelPosition(p_center);
		renderer.setBaseItemLabelFont(f);
		renderer.setSeriesPaint(0, new Color(0, 162, 255));
		final CategoryPlot plot = new CategoryPlot();
		plot.setDataset(dataset1);
		plot.setRenderer(renderer);
		plot.setOrientation(PlotOrientation.VERTICAL); // �׷��� ǥ�� ����
		plot.setRangeGridlinesVisible(true); // X�� ���̵� ���� ǥ�ÿ���
		plot.setDomainGridlinesVisible(true); // Y�� ���̵� ���� ǥ�ÿ���
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
		plot.setDomainAxis(new CategoryAxis()); // X�� ���� ����
		plot.getDomainAxis().setTickLabelFont(axisF); // X�� ���ݶ� ��Ʈ ����
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // ī�װ� �� ��ġ ����
		plot.setRangeAxis(new NumberAxis()); // Y�� ���� ����
		plot.getRangeAxis().setTickLabelFont(axisF); // Y�� ���ݶ� ��Ʈ ����
		plot.getRangeAxis().setRange(30, 100);
		plot.setDomainGridlinesVisible(false);
		plot.setDomainGridlinesVisible(false);
		plot.setOutlineVisible(false);
		plot.setRangeGridlinesVisible(false);
		plot.clearRangeMarkers();
		plot.clearAnnotations();
		final JFreeChart chart = new JFreeChart(plot);
		chart.setBackgroundPaint(Color.WHITE);
		TextTitle copyright = new TextTitle("�౸�ɷ�", new Font("KBIZ�Ѹ������ B", Font.PLAIN, 25));
		copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		chart.addSubtitle(copyright); // ��Ʈ ���� Ÿ��Ʋ
		chart.getLegend().setItemFont(new Font("KBIZ�Ѹ������ H", Font.PLAIN, 14));
		return chart;

	}

	public JFreeChart getChart_Overall(ArrayList<Player_FootballDTO> arr) {
		// ������ ����
		int data[][] = new int[5][5];
		
		int size = 0;
		
		if(arr.size() < 5) {
			size = arr.size();
		} else {
			size = 5;
		}

		for (int i = 0; i < size; i++) {
			data[i][0] = arr.get(i).getPlayer_Football_Speed();
			data[i][1] = arr.get(i).getPlayer_Football_Shoot();
			data[i][2] = arr.get(i).getPlayer_Football_Pass();
			data[i][3] = arr.get(i).getPlayer_Football_Dribol();
			data[i][4] = arr.get(i).getPlayer_Football_Defense();
		}

		int[] sum = new int[5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				sum[i] += data[i][j];
			}
		}

		int[] overall = new int[5];
		for (int i = 0; i < overall.length; i++) {
			overall[i] = sum[i] / 5;
		}
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset(); // line chart 1
		for (int i = 0; i < 5; i++) {
			dataset2.addValue(overall[4 - i], "������", num[i]);
		}
		final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
		final ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
		final ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);

		Font f = new Font("KBIZ�Ѹ������ H", Font.BOLD, 14);
		Font axisF = new Font("KBIZ�Ѹ������ H", Font.PLAIN, 14);
		renderer2.setBaseItemLabelGenerator(generator);
		renderer2.setBaseItemLabelsVisible(true);
		renderer2.setBaseShapesVisible(true);
		renderer2.setDrawOutlines(true);
		renderer2.setUseFillPaint(true);
		renderer2.setBaseFillPaint(Color.WHITE);
		renderer2.setBaseItemLabelFont(f);
		renderer2.setBasePositiveItemLabelPosition(p_below);
		renderer2.setSeriesPaint(0, new Color(215, 46, 47));
		renderer2.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3.0f));
		final CategoryPlot plot = new CategoryPlot();
		plot.setDataset(1, dataset2);
		plot.setRenderer(1, renderer2);
		plot.setOrientation(PlotOrientation.VERTICAL); // �׷��� ǥ�� ����
		plot.setRangeGridlinesVisible(true); // X�� ���̵� ���� ǥ�ÿ���
		plot.setDomainGridlinesVisible(true); // Y�� ���̵� ���� ǥ�ÿ���
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
		plot.setDomainAxis(new CategoryAxis()); // X�� ���� ����
		plot.getDomainAxis().setTickLabelFont(axisF); // X�� ���ݶ� ��Ʈ ����
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // ī�װ� �� ��ġ ����
		// Y�� ����
		plot.setRangeAxis(new NumberAxis()); // Y�� ���� ����
		plot.getRangeAxis().setRange(60, 100);
		plot.getRangeAxis().setTickLabelFont(axisF); // Y�� ���ݶ� ��Ʈ ����
		plot.setOutlineVisible(false);
		plot.setRangeGridlinesVisible(false);
		final JFreeChart chart = new JFreeChart(plot);
		chart.setBackgroundPaint(Color.WHITE);
		TextTitle copyright = new TextTitle("������", new Font("KBIZ�Ѹ������ B", Font.PLAIN, 25));
		copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		chart.addSubtitle(copyright); // ��Ʈ ���� Ÿ��Ʋ
		chart.getLegend().setItemFont(new Font("KBIZ�Ѹ������ H", Font.PLAIN, 14));
		return chart;

	}

	public JFreeChart getChart_Recent(ArrayList<Player_FootballDTO> arrFootball_Recent) {
		// ������ ����
		int data[][] = new int[5][5];
		
		int size = 0;
		
		if(arrFootball_Recent.size() < 5) {
			size = arrFootball_Recent.size();
		} else {
			size = 5;
		}

		for (int i = 0; i < size; i++) {
			data[i][0] = arrFootball_Recent.get(i).getPlayer_Football_Speed();
			data[i][1] = arrFootball_Recent.get(i).getPlayer_Football_Shoot();
			data[i][2] = arrFootball_Recent.get(i).getPlayer_Football_Pass();
			data[i][3] = arrFootball_Recent.get(i).getPlayer_Football_Dribol();
			data[i][4] = arrFootball_Recent.get(i).getPlayer_Football_Defense();
		}

		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); // line chart 1
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset(); // line chart 1
		DefaultCategoryDataset dataset3 = new DefaultCategoryDataset(); // line chart 1
		DefaultCategoryDataset dataset4 = new DefaultCategoryDataset(); // line chart 1
		DefaultCategoryDataset dataset5 = new DefaultCategoryDataset(); // line chart 1

		for (int i = 0; i < data.length; i++) {
			dataset1.addValue(data[4 - i][0], "���ǵ�", num[i]);
		}

		for (int i = 0; i < data.length; i++) {
			dataset2.addValue(data[4 - i][1], "��", num[i]);
		}
		for (int i = 0; i < data.length; i++) {
			dataset3.addValue(data[4 - i][2], "�н�", num[i]);
		}
		for (int i = 0; i < data.length; i++) {
			dataset4.addValue(data[4 - i][3], "�帮��", num[i]);
		}
		for (int i = 0; i < data.length; i++) {
			dataset5.addValue(data[4 - i][4], "����", num[i]);
		}

		final LineAndShapeRenderer renderer1 = new LineAndShapeRenderer();
		final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
		final LineAndShapeRenderer renderer3 = new LineAndShapeRenderer();
		final LineAndShapeRenderer renderer4 = new LineAndShapeRenderer();
		final LineAndShapeRenderer renderer5 = new LineAndShapeRenderer();
		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
		final ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
		final ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);

		Font f = new Font("KBIZ�Ѹ������ H", Font.BOLD, 14);
		Font axisF = new Font("KBIZ�Ѹ������ H", Font.PLAIN, 14);
		renderer1.setBaseItemLabelGenerator(generator);
		renderer1.setBaseItemLabelsVisible(true);
		renderer1.setBaseShapesVisible(true);
		renderer1.setDrawOutlines(true);
		renderer1.setUseFillPaint(true);
		renderer1.setBaseFillPaint(Color.WHITE);
		renderer1.setBaseItemLabelFont(f);
		renderer1.setBasePositiveItemLabelPosition(p_below);
		renderer1.setSeriesPaint(0, new Color(215, 46, 47));
		renderer1.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3.0f));
		renderer2.setBaseItemLabelGenerator(generator);
		renderer2.setBaseItemLabelsVisible(true);
		renderer2.setBaseShapesVisible(true);
		renderer2.setDrawOutlines(true);
		renderer2.setUseFillPaint(true);
		renderer2.setBaseFillPaint(Color.WHITE);
		renderer2.setBaseItemLabelFont(f);
		renderer2.setBasePositiveItemLabelPosition(p_below);
		renderer2.setSeriesPaint(0, new Color(31, 119, 180));
		renderer2.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3.0f));
		renderer3.setBaseItemLabelGenerator(generator);
		renderer3.setBaseItemLabelsVisible(true);
		renderer3.setBaseShapesVisible(true);
		renderer3.setDrawOutlines(true);
		renderer3.setUseFillPaint(true);
		renderer3.setBaseFillPaint(Color.WHITE);
		renderer3.setBaseItemLabelFont(f);
		renderer3.setBasePositiveItemLabelPosition(p_below);
		renderer3.setSeriesPaint(0, new Color(46, 138, 117));
		renderer3.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3.0f));
		renderer4.setBaseItemLabelGenerator(generator);
		renderer4.setBaseItemLabelsVisible(true);
		renderer4.setBaseShapesVisible(true);
		renderer4.setDrawOutlines(true);
		renderer4.setUseFillPaint(true);
		renderer4.setBaseFillPaint(Color.WHITE);
		renderer4.setBaseItemLabelFont(f);
		renderer4.setBasePositiveItemLabelPosition(p_below);
		renderer4.setSeriesPaint(0, new Color(250, 127, 18));
		renderer4.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3.0f));
		renderer5.setBaseItemLabelGenerator(generator);
		renderer5.setBaseItemLabelsVisible(true);
		renderer5.setBaseShapesVisible(true);
		renderer5.setDrawOutlines(true);
		renderer5.setUseFillPaint(true);
		renderer5.setBaseFillPaint(Color.WHITE);
		renderer5.setBaseItemLabelFont(f);
		renderer5.setBasePositiveItemLabelPosition(p_below);
		renderer5.setSeriesPaint(0, new Color(149, 105, 190));
		renderer5.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3.0f));
		final CategoryPlot plot = new CategoryPlot();
		plot.setDataset(1, dataset1);
		plot.setRenderer(1, renderer1);
		plot.setDataset(2, dataset2);
		plot.setRenderer(2, renderer2);
		plot.setDataset(3, dataset3);
		plot.setRenderer(3, renderer3);
		plot.setDataset(4, dataset4);
		plot.setRenderer(4, renderer4);
		plot.setDataset(5, dataset5);
		plot.setRenderer(5, renderer5);
		plot.setOrientation(PlotOrientation.VERTICAL); // �׷��� ǥ�� ����
		plot.setRangeGridlinesVisible(true); // X�� ���̵� ���� ǥ�ÿ���
		plot.setDomainGridlinesVisible(true); // Y�� ���̵� ���� ǥ�ÿ���
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
		plot.setDomainAxis(new CategoryAxis()); // X�� ���� ����
		plot.getDomainAxis().setTickLabelFont(axisF); // X�� ���ݶ� ��Ʈ ����
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // ī�װ� �� ��ġ ����
		// Y�� ����
		plot.setRangeAxis(new NumberAxis()); // Y�� ���� ����
		plot.getRangeAxis().setRange(30, 100);
		plot.getRangeAxis().setTickLabelFont(axisF); // Y�� ���ݶ� ��Ʈ ����
		plot.setOutlineVisible(false);
		plot.setRangeGridlinesVisible(false);
		final JFreeChart chart = new JFreeChart(plot);
		chart.setBackgroundPaint(Color.WHITE);
		TextTitle copyright = new TextTitle("�౸�ɷº�ȭ", new Font("KBIZ�Ѹ������ B", Font.PLAIN, 25));
		copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		chart.addSubtitle(copyright); // ��Ʈ ���� Ÿ��Ʋ
		chart.getLegend().setItemFont(new Font("KBIZ�Ѹ������ H", Font.PLAIN, 14));

		return chart;
	}

	public JFreeChart getRadorChart(ArrayList<Player_FootballDTO> arrFootball) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int data[] = new int[5];
		data[0] = arrFootball.get(0).getPlayer_Football_Speed();
		data[1] = arrFootball.get(0).getPlayer_Football_Shoot();
		data[2] = arrFootball.get(0).getPlayer_Football_Pass();
		data[3] = arrFootball.get(0).getPlayer_Football_Dribol();
		data[4] = arrFootball.get(0).getPlayer_Football_Defense();

		for (int i = 0; i < PlayerFootball.length; i++) {
			dataset.addValue(data[i], "�౸ �ɷ�", PlayerFootball[i]);
		}
		SpiderWebPlot plot = new SpiderWebPlot(dataset);
		plot.setOutlineVisible(false);
		plot.setAxisLinePaint(new Color(220, 220, 220));
		plot.setSeriesPaint(new Color(215, 46, 47));
		plot.setSeriesOutlinePaint(0, new Color(255, 255, 255));
		plot.setSeriesOutlineStroke(0, new BasicStroke(2.0f, BasicStroke.JOIN_BEVEL, BasicStroke.JOIN_ROUND, 3.0f));
		plot.setLabelFont(new Font("KBIZ�Ѹ������ H", Font.PLAIN, 16));
		JFreeChart chart = new JFreeChart(plot);
		TextTitle copyright = new TextTitle("�౸�ɷ�", new Font("KBIZ�Ѹ������ B", Font.PLAIN, 25));
		copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		chart.addSubtitle(copyright);
		chart.setBackgroundPaint(Color.WHITE);
		chart.getLegend().setItemFont(new Font("KBIZ�Ѹ������ H", Font.PLAIN, 14));

		return chart;
	}

	public JFreeChart getChart_Contest(ArrayList<PlayerContestDTO> arr) {
		// ������ ����
		int data[][] = new int[arr.size()][5];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = arr.get(i).getPlayer_Contest_Shot();
			data[i][1] = arr.get(i).getPlayer_Contest_EffectiveShot();
			data[i][2] = arr.get(i).getPlayer_Contest_Goal();
			data[i][3] = arr.get(i).getPlayer_Contest_Assist();
			data[i][4] = arr.get(i).getPlayer_Contest_RunningTime();
		}
		
		int[] sum = new int[5];
		
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < arr.size(); j++) {
				sum[i] += data[j][i];
			}
		}
		String[] contest = {"��","��ȿ��","��","��ý�Ʈ","����Ÿ��"};
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < sum.length; i++) {
			dataset.addValue(sum[i], "��ȸ����", contest[i]);
		}
		
		final BarRenderer renderer = new BarRenderer();
		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
		final ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
		final ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);
		Font f = new Font("KBIZ�Ѹ������ H", Font.BOLD, 14);
		Font axisF = new Font("KBIZ�Ѹ������ H", Font.PLAIN, 14);
		renderer.setBaseItemLabelGenerator(generator);
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBasePositiveItemLabelPosition(p_center);
		renderer.setBaseItemLabelFont(f);
		renderer.setSeriesPaint(0, new Color(0, 162, 255));
		final CategoryPlot plot = new CategoryPlot();
		plot.setDataset(dataset);
		plot.setRenderer(renderer);
		plot.setOrientation(PlotOrientation.VERTICAL); // �׷��� ǥ�� ����
		plot.setRangeGridlinesVisible(true); // X�� ���̵� ���� ǥ�ÿ���
		plot.setDomainGridlinesVisible(true); // Y�� ���̵� ���� ǥ�ÿ���
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
		plot.setDomainAxis(new CategoryAxis()); // X�� ���� ����
		plot.getDomainAxis().setTickLabelFont(axisF); // X�� ���ݶ� ��Ʈ ����
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // ī�װ� �� ��ġ ����
		plot.setRangeAxis(new NumberAxis()); // Y�� ���� ����
		plot.getRangeAxis().setTickLabelFont(axisF); // Y�� ���ݶ� ��Ʈ ����
		plot.getRangeAxis().setAutoRange(true);;
		plot.setDomainGridlinesVisible(false);
		plot.setDomainGridlinesVisible(false);
		plot.setOutlineVisible(false);
		plot.setRangeGridlinesVisible(false);
		plot.clearRangeMarkers();
		plot.clearAnnotations();
		final JFreeChart chart = new JFreeChart(plot);
		chart.setBackgroundPaint(Color.WHITE);
		TextTitle copyright = new TextTitle("��ȸ����", new Font("KBIZ�Ѹ������ B", Font.PLAIN, 25));
		copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		chart.addSubtitle(copyright); // ��Ʈ ���� Ÿ��Ʋ
		chart.getLegend().setItemFont(new Font("KBIZ�Ѹ������ H", Font.PLAIN, 14));
		return chart;
	}

}

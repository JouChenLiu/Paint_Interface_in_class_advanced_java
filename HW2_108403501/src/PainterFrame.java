//劉柔辰 108403501 資管三A
import java.awt.*;	//使用BorderLayout必須載入awt套件
import java.awt.event.*;	//使用事件必須載入event套件
import javax.swing.*;	//載入swing套件

public class PainterFrame extends JFrame {
	private final JPanel toolPanel;
	private final JLabel statusBar;
	private final JPanel mousePanel;
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	private final JPanel PanelComboBox;
	private final JPanel PanelRadioButton;
	private final JPanel PanelCheckBox;
	private final JPanel PanelButton;
	
	private final String[] brushes = {"筆刷", "直線", "橢圓形", "矩形"};
	private final JComboBox<String> brushComboBox;
	private final JRadioButton sButton;
	private final JRadioButton mButton;
	private final JRadioButton lButton;
	private final ButtonGroup bGroup;
	private final JCheckBox fillCheckBox;
	private final JButton brushColorButton;
	private final JButton cleanButton;
	
	public PainterFrame() {
		super("小畫家");
		
		//工作區toolPanel
		toolPanel = new JPanel();
		toolPanel.setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		
		//繪圖工具Label1 ComboBox
		PanelComboBox = new JPanel();
		PanelComboBox.setLayout(new BorderLayout());
		label1 = new JLabel("繪圖工具");
		PanelComboBox.add(label1, BorderLayout.NORTH);
		
		brushComboBox = new JComboBox<String>(brushes);
		PanelComboBox.add(brushComboBox, BorderLayout.SOUTH);
		
		brushComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				// TODO Auto-generated method stub
				if(event.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("選擇 " + brushes[brushComboBox.getSelectedIndex()]);
				}
			}
		});
		
		toolPanel.add(PanelComboBox);	//加入工具區
		
		//筆刷大小Label2 RadioButton
		PanelRadioButton = new JPanel();
		PanelRadioButton.setLayout(new BorderLayout());
		label2 = new JLabel("筆刷大小");
		PanelRadioButton.add(label2, BorderLayout.NORTH);
		
		sButton = new JRadioButton("小", false);
		mButton = new JRadioButton("中", false);
		lButton = new JRadioButton("大", false);
		bGroup = new ButtonGroup();
		
		bGroup.add(sButton);
		bGroup.add(mButton);
		bGroup.add(lButton);
		PanelRadioButton.add(sButton, BorderLayout.WEST);
		PanelRadioButton.add(mButton, BorderLayout.CENTER);
		PanelRadioButton.add(lButton, BorderLayout.EAST);
		
		sButton.addItemListener(new RadioButtonHandler("小"));
		mButton.addItemListener(new RadioButtonHandler("中"));
		lButton.addItemListener(new RadioButtonHandler("大"));
		
		toolPanel.add(PanelRadioButton);	//加入工具區
		
		//填滿label3 CheckBox
		PanelCheckBox = new JPanel();
		PanelCheckBox.setLayout(new BorderLayout());
		label3 = new JLabel("填滿");
		fillCheckBox = new JCheckBox();
		fillCheckBox.addItemListener(new CheckBoxHandler());
		PanelCheckBox.add(label3, BorderLayout.NORTH);
		PanelCheckBox.add(fillCheckBox, BorderLayout.SOUTH);
		
		toolPanel.add(PanelCheckBox);	//加入工具區
		
		//筆刷顏色、清除畫面 Button
		PanelButton = new JPanel();
		PanelButton.setLayout(new FlowLayout());
		brushColorButton = new JButton("筆刷顏色");
		cleanButton = new JButton("清除畫面");
		PanelButton.add(brushColorButton);
		PanelButton.add(cleanButton);
		
		brushColorButton.addActionListener(new ButtonHandler());
		cleanButton.addActionListener(new ButtonHandler());
		
		toolPanel.add(PanelButton);	//加入工具區
		
		//狀態列statusBar
		statusBar = new JLabel("指標位置:(0,0)");
		statusBar.setBackground(Color.BLACK);
		statusBar.setForeground(Color.WHITE);
		statusBar.setOpaque(true);	//let label background painted
		
		//畫布區mousePanel
		mousePanel = new JPanel();
		MouseHandler mouseHandler = new MouseHandler();
		mousePanel.addMouseListener(mouseHandler);
		mousePanel.addMouseMotionListener(mouseHandler);
		mousePanel.setBackground(Color.WHITE);
		
		//加進Frame
		add(toolPanel, BorderLayout.NORTH);
		add(statusBar, BorderLayout.SOUTH);
		add(mousePanel, BorderLayout.CENTER);
	}
	
	private class RadioButtonHandler implements ItemListener {
		private String size;
		
		public RadioButtonHandler(String s) {
			size = s;
		}
		@Override
		public void itemStateChanged(ItemEvent event) {
			// TODO Auto-generated method stub
			if(event.getStateChange() == ItemEvent.SELECTED) {
				System.out.println("選擇 " + size + " 筆刷");
			}
		}
	}
	
	private class CheckBoxHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			// TODO Auto-generated method stub
			if(fillCheckBox.isSelected()) {
				System.out.println("選擇 填滿");
			}
			else {
				System.out.println("取消 填滿");
			}
		}
	}
	
	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			System.out.println("點選 " + event.getActionCommand());
		}
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener {
		public void mouseMoved(MouseEvent event) {
			statusBar.setText(String.format("指標位置:(%d,%d)", event.getX(), event.getY()));
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
}

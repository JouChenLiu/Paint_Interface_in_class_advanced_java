//�B�X�� 108403501 ��ޤTA
import java.awt.*;	//�ϥ�BorderLayout�������Jawt�M��
import java.awt.event.*;	//�ϥΨƥ󥲶����Jevent�M��
import javax.swing.*;	//���Jswing�M��

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
	
	private final String[] brushes = {"����", "���u", "����", "�x��"};
	private final JComboBox<String> brushComboBox;
	private final JRadioButton sButton;
	private final JRadioButton mButton;
	private final JRadioButton lButton;
	private final ButtonGroup bGroup;
	private final JCheckBox fillCheckBox;
	private final JButton brushColorButton;
	private final JButton cleanButton;
	
	public PainterFrame() {
		super("�p�e�a");
		
		//�u�@��toolPanel
		toolPanel = new JPanel();
		toolPanel.setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		
		//ø�Ϥu��Label1 ComboBox
		PanelComboBox = new JPanel();
		PanelComboBox.setLayout(new BorderLayout());
		label1 = new JLabel("ø�Ϥu��");
		PanelComboBox.add(label1, BorderLayout.NORTH);
		
		brushComboBox = new JComboBox<String>(brushes);
		PanelComboBox.add(brushComboBox, BorderLayout.SOUTH);
		
		brushComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				// TODO Auto-generated method stub
				if(event.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("��� " + brushes[brushComboBox.getSelectedIndex()]);
				}
			}
		});
		
		toolPanel.add(PanelComboBox);	//�[�J�u���
		
		//����j�pLabel2 RadioButton
		PanelRadioButton = new JPanel();
		PanelRadioButton.setLayout(new BorderLayout());
		label2 = new JLabel("����j�p");
		PanelRadioButton.add(label2, BorderLayout.NORTH);
		
		sButton = new JRadioButton("�p", false);
		mButton = new JRadioButton("��", false);
		lButton = new JRadioButton("�j", false);
		bGroup = new ButtonGroup();
		
		bGroup.add(sButton);
		bGroup.add(mButton);
		bGroup.add(lButton);
		PanelRadioButton.add(sButton, BorderLayout.WEST);
		PanelRadioButton.add(mButton, BorderLayout.CENTER);
		PanelRadioButton.add(lButton, BorderLayout.EAST);
		
		sButton.addItemListener(new RadioButtonHandler("�p"));
		mButton.addItemListener(new RadioButtonHandler("��"));
		lButton.addItemListener(new RadioButtonHandler("�j"));
		
		toolPanel.add(PanelRadioButton);	//�[�J�u���
		
		//��label3 CheckBox
		PanelCheckBox = new JPanel();
		PanelCheckBox.setLayout(new BorderLayout());
		label3 = new JLabel("��");
		fillCheckBox = new JCheckBox();
		fillCheckBox.addItemListener(new CheckBoxHandler());
		PanelCheckBox.add(label3, BorderLayout.NORTH);
		PanelCheckBox.add(fillCheckBox, BorderLayout.SOUTH);
		
		toolPanel.add(PanelCheckBox);	//�[�J�u���
		
		//�����C��B�M���e�� Button
		PanelButton = new JPanel();
		PanelButton.setLayout(new FlowLayout());
		brushColorButton = new JButton("�����C��");
		cleanButton = new JButton("�M���e��");
		PanelButton.add(brushColorButton);
		PanelButton.add(cleanButton);
		
		brushColorButton.addActionListener(new ButtonHandler());
		cleanButton.addActionListener(new ButtonHandler());
		
		toolPanel.add(PanelButton);	//�[�J�u���
		
		//���A�CstatusBar
		statusBar = new JLabel("���Ц�m:(0,0)");
		statusBar.setBackground(Color.BLACK);
		statusBar.setForeground(Color.WHITE);
		statusBar.setOpaque(true);	//let label background painted
		
		//�e����mousePanel
		mousePanel = new JPanel();
		MouseHandler mouseHandler = new MouseHandler();
		mousePanel.addMouseListener(mouseHandler);
		mousePanel.addMouseMotionListener(mouseHandler);
		mousePanel.setBackground(Color.WHITE);
		
		//�[�iFrame
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
				System.out.println("��� " + size + " ����");
			}
		}
	}
	
	private class CheckBoxHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			// TODO Auto-generated method stub
			if(fillCheckBox.isSelected()) {
				System.out.println("��� ��");
			}
			else {
				System.out.println("���� ��");
			}
		}
	}
	
	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			System.out.println("�I�� " + event.getActionCommand());
		}
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener {
		public void mouseMoved(MouseEvent event) {
			statusBar.setText(String.format("���Ц�m:(%d,%d)", event.getX(), event.getY()));
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

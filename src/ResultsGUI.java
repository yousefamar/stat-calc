import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ResultsGUI extends JPanel implements ActionListener {

	private JFrame frame;
	private JButton OKButton;
	
	public ResultsGUI(String msg) {
		super(new GridBagLayout());
		
		JEditorPane textPane = new JEditorPane();
		textPane.setText(msg);
		textPane.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(new Dimension(500,400));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//This should bring the scroll bar to the top, but for some reason it doesn't. Meh.
		//scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMinimum());
        
		this.add(scrollPane);
		
		addOKButton();
		
		makeNewFrame();
	}

	private void addOKButton() {
		OKButton = new JButton("OK");
        OKButton.addActionListener(this);

        //For layout purposes, the button is in a separate panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(OKButton);
        GridBagConstraints cons = new GridBagConstraints();
//        cons.gridheight = 30;
        cons.gridy = 1;
        
        this.add(buttonPanel, cons);
	}
	
	private void makeNewFrame() {
		frame = new JFrame("Results");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.setSize(new Dimension(450,200));
		frame.setResizable(false);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void closeWindow() {
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == OKButton)
			closeWindow();
	}
	
}

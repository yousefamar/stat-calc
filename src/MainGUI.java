import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.text.NumberFormat;
import javax.swing.*;

public class MainGUI extends JPanel 
				implements PropertyChangeListener, ActionListener {

	private int birthYear;
	private String selectedElements[] = {"---", "---", "---", "---", "---"};
	private JComboBox elementMenus[] = new JComboBox[5];
	private JFormattedTextField birthYearField;
	private JButton calcButton;
	private JFrame frame;
	
	public MainGUI(JFrame frame){
		super(new GridLayout(0,1));
		this.frame = frame;
		
		addBirthYearField();
		addElementPane();
		addCalculateButton();
	}

	private void addBirthYearField() {
		JPanel subPane = new JPanel(new GridBagLayout());
		JLabel birthYearLabel = new JLabel("Birth Year: ");
	    birthYearLabel.setOpaque(true);
	    birthYearLabel.setLabelFor(birthYearField);
		
	    birthYearField = new JFormattedTextField(NumberFormat.getIntegerInstance());
	    birthYearField.setColumns(4);
	    //birthYearField.setPreferredSize(new Dimension(50, 10));
	    birthYearField.addPropertyChangeListener("value", this);
		
	    subPane.add(birthYearLabel);
	    subPane.add(birthYearField);
	    //subPane.setMaximumSize(new Dimension(20,20));
	    //subPane.setBorder(BorderFactory.createTitledBorder("Input Info:"));
	    
	    this.add(subPane, BorderLayout.WEST);
	}

	private void addElementPane() {
		String elementNames[] = {"---", "fire", "ice", "water", "wind", "earth",
				"poison", "gravity", "shadow", "light", "elec", "holy", "anti",
				"void", "time" };

		JLabel elementsLabel = new JLabel("Elements: ");
		elementsLabel.setOpaque(true);

		JPanel subPane = new JPanel(new GridBagLayout());
		subPane.add(elementsLabel);
		
		for (int i=0;i<5;i++) {
			subPane.add(this.elementMenus[i] = new JComboBox(elementNames));
			this.elementMenus[i].addActionListener(this);
		}
        subPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
	    this.add(subPane, BorderLayout.WEST);
	}
	
	private void addCalculateButton() {
		calcButton = new JButton("Calculate");
        calcButton.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(calcButton);
        this.add(buttonPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == calcButton){
			if(areElementsSelected()&&isBirthYearGiven())
				new Calc(frame, birthYear, selectedElements);
			else if(!areElementsSelected()&&isBirthYearGiven())
				JOptionPane.showMessageDialog(frame,
						"You must select at least one element.", "Error",
						JOptionPane.ERROR_MESSAGE);
			else if(areElementsSelected()&&!isBirthYearGiven())
				JOptionPane.showMessageDialog(frame,
						"Please enter your year of birth.", "Error",
						JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(frame,
						"Please enter the prompted information.", "Error",
						JOptionPane.ERROR_MESSAGE);
		} else {
			for(int i=0;i<5;i++)
				if (source == elementMenus[i])
					selectedElements[i] = elementMenus[i].getSelectedItem().toString();
		}
	}

	private boolean areElementsSelected() {
		for (String element : selectedElements)
			if(!element.equals("---"))
				return true;
		return false;
	}
	
	private boolean isBirthYearGiven() {
		return birthYear>0;
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		Object source = e.getSource();
        if (source == birthYearField) {
        	birthYear = ((Number)birthYearField.getValue())!=null?((Number)birthYearField.getValue()).intValue():0;
        }
	}
	
	
}

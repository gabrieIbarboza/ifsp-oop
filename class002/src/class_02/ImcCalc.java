package class_02;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ImcCalc {

	protected Shell shell;
	private Text textWeight;
	private Text textHeight;
	private Text textIMC;
	private Double vWeight;
	private Double vHeight;
	private Double vImc;
	private Text textStatus;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ImcCalc window = new ImcCalc();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 327);
		shell.setText("SWT Application");
		
		Label lblPeso = new Label(shell, SWT.NONE);
		lblPeso.setBounds(23, 29, 55, 15);
		lblPeso.setText("Weight");
		
		Label lblHeight = new Label(shell, SWT.NONE);
		lblHeight.setBounds(23, 57, 55, 15);
		lblHeight.setText("Height");
		
		textWeight = new Text(shell, SWT.BORDER);
		textWeight.setBounds(84, 23, 314, 21);
		
		textHeight = new Text(shell, SWT.BORDER);
		textHeight.setBounds(84, 51, 314, 21);
		
		//MessageBox
		MessageBox warningAlert = new MessageBox(shell, SWT.ICON_WARNING);
		MessageBox questionAlert = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
		
		Button btnCalcularImc = new Button(shell, SWT.NONE);
		btnCalcularImc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String strWeight = textWeight.getText();
				String strHeight = textHeight.getText();
				if(strWeight == "" || strHeight == "")
				{
					warningAlert.setMessage("Preencha todos os campos!");
					warningAlert.open();
				}
				else if(isNumber(strWeight) && isNumber(strHeight))
				{
					vWeight = Double.valueOf(textWeight.getText());
					vHeight = Double.parseDouble(textHeight.getText());
					vImc = calcIMC(vWeight, vHeight);
					textIMC.setText(String.format("%.2f", vImc));
					
					if(vImc < 16.9)
					{
						textStatus.setText("Muito abaixo do peso!");
					}
					else if(vImc < 18.5)
					{
						textStatus.setText("Abaixo do peso!");
					}
					else if(vImc < 25)
					{
						textStatus.setText("Peso normal!");
					}
					else if(vImc < 30)
					{
						textStatus.setText("Acima do peso!");
					}
					else if(vImc < 35)
					{
						textStatus.setText("Obesidade I");
					}
					else if(vImc < 41)
					{
						textStatus.setText("Obesidade II");
					}
					else
					{
						textStatus.setText("Obesidade III");
					}
				}
				else
				{
					warningAlert.setMessage("A altura e peso devem ser numero!");
					warningAlert.open();
				}
				
			}
		});
		btnCalcularImc.setBounds(23, 94, 176, 25);
		btnCalcularImc.setText("Calc IMC");
		
		Button btnLimparDados = new Button(shell, SWT.NONE);
		btnLimparDados.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				questionAlert.setMessage("Realmente deseja limpar todos os campos?");
				int buttonID = questionAlert.open();
		        switch(buttonID) {
		          case SWT.YES:
		        	  clearFields();
		        	  break;
		          case SWT.NO:
		            break;
		          default:
		        	  break;
		        }
				
			}
		});
		btnLimparDados.setText("Clear Fields");
		btnLimparDados.setBounds(222, 94, 176, 25);
		
		Label lblSeuImcE = new Label(shell, SWT.NONE);
		lblSeuImcE.setBounds(45, 150, 55, 15);
		lblSeuImcE.setText("Seu IMC e:");
		
		textIMC = new Text(shell, SWT.BORDER);
		textIMC.setEditable(false);
		textIMC.setBounds(119, 144, 279, 21);
		
		textStatus = new Text(shell, SWT.BORDER);
		textStatus.setEditable(false);
		textStatus.setBounds(23, 188, 375, 90);

	}
	
	private void clearFields() {
		textHeight.setText("");
		textWeight.setText("");
		textIMC.setText("");
	}
	
	private Double calcIMC(Double weight, Double height) {
		return weight / (height * height);
	}
	
	private boolean isNumber(String str)
	{
		return str.matches("[+-]?\\d*(\\.\\d+)?");
	}
}

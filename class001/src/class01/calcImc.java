package class01;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class calcImc {

	protected Shell shell;
	private Text textPeso;
	private Text textAltura;
	private Text textImc;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			calcImc window = new calcImc();
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
		shell.setSize(463, 458);
		shell.setText("SWT Application");
		
		Label lblPeso = new Label(shell, SWT.NONE);
		lblPeso.setBounds(41, 35, 55, 15);
		lblPeso.setText("Peso");
		
		Label lblAltura = new Label(shell, SWT.NONE);
		lblAltura.setBounds(216, 35, 55, 15);
		lblAltura.setText("Altura");
		
		textPeso = new Text(shell, SWT.BORDER);
		textPeso.setBounds(82, 29, 76, 21);
		
		textAltura = new Text(shell, SWT.BORDER);
		textAltura.setBounds(252, 35, 76, 21);
		
		Button btnCalcularImc = new Button(shell, SWT.NONE);
		btnCalcularImc.setBounds(82, 78, 105, 25);
		btnCalcularImc.setText("Calcular IMC");
		
		Button btnLimparCampos = new Button(shell, SWT.NONE);
		btnLimparCampos.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLimparCampos.setText("Limpar Campos");
		btnLimparCampos.setBounds(216, 78, 105, 25);
		
		Label lblSeuImc = new Label(shell, SWT.NONE);
		lblSeuImc.setBounds(92, 149, 55, 15);
		lblSeuImc.setText("Seu IMC é");
		
		textImc = new Text(shell, SWT.BORDER);
		textImc.setBounds(82, 170, 76, 21);

	}

}

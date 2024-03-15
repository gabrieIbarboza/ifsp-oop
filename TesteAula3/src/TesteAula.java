import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TesteAula {

	protected Shell shell;
	private Text textN;
	private Text textC;
	private Text textD;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TesteAula window = new TesteAula();
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
		shell.setSize(450, 558);
		shell.setText("SWT Application");
		
		MessageBox caixa = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
		
		Label lblInteiro = new Label(shell, SWT.NONE);
		lblInteiro.setBounds(84, 57, 55, 15);
		lblInteiro.setText("Inteiro:");
		
		textN = new Text(shell, SWT.BORDER);
		textN.setBounds(163, 51, 76, 21);
		
		Button btnConcat = new Button(shell, SWT.NONE);
		btnConcat.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(isInteiro(textN.getText()))
				{
					Integer inteiro = Integer.parseInt(textN.getText());
					if(inteiro > 0)
					{
						String crescente = "";
						String decrescente = "";
						
						for(int i = 0; i < inteiro; i++)
						{
							
						}
						
						textC.setText(crescente);
						textD.setText(decrescente);
					}
					else
					{
						caixa.setText("Numero invalido!");
						caixa.setMessage("Digite um valor inteiro! (>0)");
						caixa.open();
					}
				}
				else
				{
					caixa.setText("Numero invalido!");
					caixa.setMessage("Digite um valor inteiro! (>0)");
					caixa.open();
				}
			}
		});
		btnConcat.setBounds(124, 91, 115, 25);
		btnConcat.setText("Exibir Ordens");
		
		Label lblCrescente = new Label(shell, SWT.NONE);
		lblCrescente.setBounds(84, 128, 55, 15);
		lblCrescente.setText("Crescente");
		
		Label lblDecrescente = new Label(shell, SWT.NONE);
		lblDecrescente.setText("Decrescente");
		lblDecrescente.setBounds(84, 312, 55, 15);
		
		textC = new Text(shell, SWT.BORDER);
		textC.setEditable(false);
		textC.setBounds(35, 159, 389, 125);
		
		textD = new Text(shell, SWT.BORDER);
		textD.setEditable(false);
		textD.setBounds(35, 345, 389, 125);

	}
	
	private boolean isInteiro(String num)
	{
		try {
			Integer.parseInt(num);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

}

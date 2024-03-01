package class01;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Class001 {

	protected Shell shell;
	private LocalResourceManager localResourceManager;
	private Text textNome;
	private Text textEndereco;
	private Text textNomeFound;
	private Text textEndFound;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class001 window = new Class001();
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
		createResourceManager();
		shell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_MAGENTA));
		shell.setSize(655, 300);
		shell.setText("SWT Application");
		
		Label lblDigiteSeuNome = new Label(shell, SWT.NONE);
		lblDigiteSeuNome.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));
		lblDigiteSeuNome.setBounds(25, 21, 110, 15);
		lblDigiteSeuNome.setText("Digite seu nome");
		
		textNome = new Text(shell, SWT.BORDER);
		textNome.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		textNome.setBounds(141, 21, 449, 21);
		
		Label lblDigiteSeuEndereco = new Label(shell, SWT.NONE);
		lblDigiteSeuEndereco.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));
		lblDigiteSeuEndereco.setText("Digite seu endereco");
		lblDigiteSeuEndereco.setBounds(25, 48, 110, 15);
		
		textEndereco = new Text(shell, SWT.BORDER);
		textEndereco.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		textEndereco.setBounds(141, 48, 449, 21);
		
		Button btnNext = new Button(shell, SWT.NONE);
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textNomeFound.setText(textNome.getText());
				textEndFound.setText(textEndereco.getText());
			}
		});
		btnNext.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
		btnNext.setGrayed(true);
		btnNext.setBounds(141, 75, 210, 25);
		btnNext.setText("Next");
		
		Button btnClear = new Button(shell, SWT.NONE);
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textNomeFound.setText("");
				textEndFound.setText("");
				textNome.setText("");
				textEndereco.setText("");
			}
		});
		btnClear.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
		btnClear.setGrayed(true);
		btnClear.setBounds(380, 75, 210, 25);
		btnClear.setText("Clear");
		
		Label lblSejaBemvinde = new Label(shell, SWT.NONE);
		lblSejaBemvinde.setAlignment(SWT.CENTER);
		lblSejaBemvinde.setBounds(141, 123, 449, 15);
		lblSejaBemvinde.setText("Boas-vindas!");
		
		textNomeFound = new Text(shell, SWT.BORDER);
		textNomeFound.setEnabled(false);
		textNomeFound.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		textNomeFound.setBounds(141, 144, 449, 21);
		
		Label lblHabitanteDe = new Label(shell, SWT.NONE);
		lblHabitanteDe.setAlignment(SWT.CENTER);
		lblHabitanteDe.setText("Habitante de:");
		lblHabitanteDe.setBounds(141, 182, 449, 15);
		
		textEndFound = new Text(shell, SWT.BORDER);
		textEndFound.setEnabled(false);
		textEndFound.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(255, 255, 255))));
		textEndFound.setBounds(141, 203, 449, 21);

	}
	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(),shell);
	}
}

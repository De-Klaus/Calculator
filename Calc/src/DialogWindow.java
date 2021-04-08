import javax.swing.JDialog;
import javax.swing.JEditorPane;

public class DialogWindow extends JDialog {

	
	public DialogWindow() {
		super();
		init();
		setTitle("Пару слов о программе");
		setResizable(false);
	}

	private void init() {
		var pane = new JEditorPane("text/html", "<center><h1>Данная программа создана в учебных целях, <br>"
				+ "для приобретения навыков программирования!</h1><br><h3 style='color: red'>"
				+ "©Akazhemiya Skhorukov's company and student Nikolay</h3></center>");
		pane.setEditable(false);
		pane.setOpaque(false);
		
		add(pane);
		pack();
		setLocationRelativeTo(null);
	}
}

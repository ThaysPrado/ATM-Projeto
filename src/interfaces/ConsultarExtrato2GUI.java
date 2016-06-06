package interfaces;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import idioma.Idioma;
import negocio.Conta;
import negocio.Extrato;

@SuppressWarnings("serial")
public class ConsultarExtrato2GUI extends JDialog implements ActionListener {
	private JLabel lNome;
	private Container c;
	private JPanel pai;
	private JButton cancelar, imprimir;
	private Object[][] dados;
	private JTable tabela;
	private JScrollPane bar;

	public ConsultarExtrato2GUI(JDialog f) {
		super(f, Idioma.getRb().getString("consExtrato2.super"), true);
		c = getContentPane();
		c.setLayout(new BorderLayout());

		lNome = new JLabel(Conta.getPao().getCliente().getNome());
		lNome.setHorizontalAlignment(JLabel.CENTER);
		cancelar = new JButton(Idioma.getRb().getString("consExtrato.button.cancelar"));
		cancelar.addActionListener(this);
		imprimir = new JButton(Idioma.getRb().getString("consExtrato2.button.imprimir"));
		imprimir.addActionListener(this);

		pai = new JPanel();
		pai.setLayout(new FlowLayout());

		pai.add(cancelar);
		pai.add(imprimir);

		String cln[] = { Idioma.getRb().getString("consExtrato2.cln.data"), Idioma.getRb().getString("consExtrato2.cln.op"),
				Idioma.getRb().getString("consExtrato2.cln.valor") };
		
		dados = Extrato.getPao().getMatriz(); 

		tabela = new JTable(dados, cln) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tabela.getTableHeader().setReorderingAllowed(false);
		tabela.getTableHeader().setResizingAllowed(false);
		tabela.setCellSelectionEnabled(false);

		bar = new JScrollPane(tabela);

		c.add(lNome, BorderLayout.NORTH);
		c.add(bar, BorderLayout.CENTER);
		c.add(pai, BorderLayout.SOUTH);

		setResizable(false);
		setSize(300, 160);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == imprimir) {

			}

			if (e.getSource() == cancelar) {
				dispose();
			}
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}
}

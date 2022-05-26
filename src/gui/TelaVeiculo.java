package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import dao.Persistencia;
import entidade.Veiculo;
import util.TableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.awt.event.MouseEvent;
import java.awt.Panel;
import java.awt.Font;

public class TelaVeiculo extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblModelo;
	private JLabel lblMarca;
	private JLabel lblPlaca;
	private JTextField campoModelo;
	private JTextField campoMarca;
	private JTextField campoAno;
	private JTextField campoPlaca;
	private JPanel painelImagem;
	private JPanel panel_1;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnExcluir; 
	private JScrollPane scrollPane;
	private JTable table;
	private TableModel model;
	Persistencia conexao = new Persistencia();
	private JLabel image;
	private JLabel lblCor;
	private JTextField campoCor;
	private JLabel lblPreco;
	private JTextField campoPreco;
	private JLabel lblComb;
	private JTextField campoKm;
	private JLabel lblLogo;
	private JTextField campoCambio;
	private JLabel lblAno;
	private JLabel lblCambio;
	private JLabel lvlVersao;
	private JTextField campoVersao;
	private JLabel lblPortas;
	private JTextField campoPortas;
	private JTextField campoComb;
	private JLabel lblKm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVeiculo frame = new TelaVeiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 779);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoModelo = new JTextField();
		campoModelo.setEditable(false);
		campoModelo.setColumns(10);
		
		campoMarca = new JTextField();
		campoMarca.setEditable(false);
		campoMarca.setColumns(10);
		
		campoAno = new JTextField();
		campoAno.setEditable(false);
		campoAno.setColumns(10);
		
		campoPlaca = new JTextField();
		campoPlaca.setEditable(false);
		campoPlaca.setColumns(10);
		
		painelImagem = new JPanel();
		painelImagem.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(10);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(this);
		
		lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoCor = new JTextField();
		campoCor.setEditable(false);
		campoCor.setColumns(10);
		
		lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoPreco = new JTextField();
		campoPreco.setEditable(false);
		campoPreco.setColumns(10);
		
		lblComb = new JLabel("Combust\u00EDvel:");
		lblComb.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoKm = new JTextField();
		campoKm.setEditable(false);
		campoKm.setColumns(10);
		
		lblLogo = new JLabel("AUTO MOTORS DO Z\u00C9");
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		campoCambio = new JTextField();
		campoCambio.setEditable(false);
		campoCambio.setColumns(10);
		
		lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblCambio = new JLabel("C\u00E2mbio:");
		lblCambio.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lvlVersao = new JLabel("Vers\u00E3o:");
		lvlVersao.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoVersao = new JTextField();
		campoVersao.setEditable(false);
		campoVersao.setColumns(10);
		
		lblPortas = new JLabel("Portas:");
		lblPortas.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoPortas = new JTextField();
		campoPortas.setEditable(false);
		campoPortas.setColumns(10);
		
		campoComb = new JTextField();
		campoComb.setEditable(false);
		campoComb.setColumns(10);
		
		lblKm = new JLabel("Quilometragem:");
		lblKm.setFont(new Font("SansSerif", Font.BOLD, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(59, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblModelo, Alignment.TRAILING)
						.addComponent(lblPlaca, Alignment.TRAILING)
						.addComponent(lblCor, Alignment.TRAILING)
						.addComponent(lblPreco, Alignment.TRAILING)
						.addComponent(lblCambio, Alignment.TRAILING))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(campoCor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(campoPreco, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(campoCambio, Alignment.LEADING))
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblKm, Alignment.TRAILING)
								.addComponent(lblComb, Alignment.TRAILING)
								.addComponent(lblPortas, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(campoComb, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(campoPortas, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(campoKm)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(campoPlaca, 0, 0, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lvlVersao, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(campoVersao, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(campoAno, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(campoModelo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMarca)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(campoMarca, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
					.addGap(53)
					.addComponent(painelImagem, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(289, Short.MAX_VALUE)
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
					.addGap(372))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(campoMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMarca)
								.addComponent(campoModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblModelo))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPlaca)
								.addComponent(lvlVersao)
								.addComponent(campoVersao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAno)
								.addComponent(campoAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(campoPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(campoCor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCor))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(campoPortas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPortas)))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPreco)
								.addComponent(campoPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblComb)
								.addComponent(campoComb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblKm)
									.addComponent(campoKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblCambio)
									.addComponent(campoCambio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(painelImagem, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		image = new JLabel("");
		painelImagem.add(image);
		
		
		conexao.conectar();
		model = new TableModel(conexao.listar());
		table = new JTable(model);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(this);
		panel_1.add(btnNovo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(this);
		panel_1.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(this);
		panel_1.add(btnExcluir);
		contentPane.setLayout(gl_contentPane);
		carregarInfo(0);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnExcluir) {
			do_btnExcluir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAlterar) {
			do_btnAlterar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnNovo) {
			do_btnNovo_actionPerformed(arg0);
		}
	}
	protected void do_btnNovo_actionPerformed(ActionEvent arg0) {
		CadastroVeiculo cadastro = new CadastroVeiculo(model);
		cadastro.setVisible(true);
		cadastro.setLocationRelativeTo(this);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == table) {
			do_table_mouseClicked(arg0);
		}
		if (arg0.getSource() == scrollPane) {
			do_scrollPane_mouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void do_scrollPane_mouseClicked(MouseEvent arg0) {
	}
	protected void do_table_mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount() == 1){
			carregarInfo(table.getSelectedRow());
		}
	}
	
	private void carregarInfo(int index){
		Veiculo carro = (Veiculo) model.getSelecionado(index);
		if(carro != null){
			campoModelo.setText(carro.getModelo());
			campoMarca.setText(carro.getMarca());
			campoAno.setText(String.valueOf(carro.getAno()));
			campoPlaca.setText(carro.getPlaca());
			campoCor.setText(carro.getCor());
			campoPreco.setText(String.valueOf(carro.getPreco()));
			campoComb.setText(carro.getCombustivel());
			campoCambio.setText(carro.getCambio());
			campoPortas.setText(String.valueOf(carro.getPortas()));
			campoKm.setText(String.valueOf(carro.getKm()));
			campoVersao.setText(carro.getVersao());
			
			ImageIcon icone = new ImageIcon(carro.getImagem());
			icone.setImage(icone.getImage().getScaledInstance(painelImagem.getWidth() -5, painelImagem.getHeight() -10, 100));
			image.setIcon(icone);
			
		}
		
	}
	protected void do_btnAlterar_actionPerformed(ActionEvent arg0) {
		int indice = table.getSelectedRow();
		if(indice >= 0){
			Veiculo  veiculoEdicao = (Veiculo) model.getSelecionado(indice);
			CadastroVeiculo guiEdicao = new CadastroVeiculo(veiculoEdicao, model);
			guiEdicao.setVisible(true);
			guiEdicao.setLocationRelativeTo(this);
		}else{
			JOptionPane.showMessageDialog(this, "Selecione um registro!");
		}
	}
	protected void do_btnExcluir_actionPerformed(ActionEvent arg0) {
		int indice = table.getSelectedRow();
		if(indice >= 0){
			Veiculo veiculoExclusao = (Veiculo) model.getSelecionado(indice);
			if(JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro?") == JOptionPane.YES_OPTION){
				conexao.excluir(veiculoExclusao);
				model.refreshData(conexao.listar());
				JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!");
				int novoIndice = indice - 1;
				if(novoIndice >= 0){
					carregarInfo(novoIndice);
				}else{
					carregarInfo(novoIndice + 1);
				}
			}
		}else{
			JOptionPane.showMessageDialog(this, "Selecione um registro!");
		}
	}
}

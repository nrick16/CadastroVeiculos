package gui;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.Persistencia;
import entidade.Veiculo;
import util.TableModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;

public class CadastroVeiculo extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField campoModelo;
	private JTextField campoMarca;
	private JTextField campoAno;
	private JTextField campoPlaca;
	private JPanel painelImagem;
	private File imagem;
	private boolean edicao = false;
	private Veiculo veiculo;
	private Persistencia conexao = new Persistencia();
	private JButton btnSalvar;
	private TableModel model;
	private JButton btnAbrir;
	private JLabel image;
	private JButton btnCancelar;
	private JLabel lblCor;
	private JTextField campoCor;
	private JTextField campoPreco;
	private JLabel lblPreco;
	private JLabel lblComb;
	private JTextField campoComb;
	private JLabel lblKm;
	private JTextField campoVersao;
	private JLabel lblVersao;
	private JTextField campoKm;
	private JLabel lblCambio;
	private JTextField campoCambio;
	private JLabel lblPortas;
	private JTextField campoPortas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, TableModel model) {
		try {
			CadastroVeiculo dialog = new CadastroVeiculo(model);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CadastroVeiculo(Veiculo veiculo, TableModel model) {
		this(model);
		this.model = model;
		this.edicao = true;
		this.veiculo = veiculo;
		setDados();
	}

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public CadastroVeiculo(TableModel model) {
		this.model = model;
		setBounds(100, 100, 806, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("SansSerif", Font.BOLD, 12));
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("SansSerif", Font.BOLD, 12));
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("SansSerif", Font.BOLD, 12));
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("SansSerif", Font.BOLD, 12));
		campoModelo = new JTextField();
		campoModelo.setColumns(10);
		campoMarca = new JTextField();
		campoMarca.setColumns(10);
		campoAno = new JTextField();
		campoAno.setColumns(10);
		campoPlaca = new JTextField();
		campoPlaca.setColumns(10);
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		painelImagem = new JPanel();
		painelImagem.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAbrir = new JButton("Adicionar Imagem");
		btnAbrir.addActionListener(this);
		
		lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoCor = new JTextField();
		campoCor.setColumns(10);
		
		campoPreco = new JTextField();
		campoPreco.setColumns(10);
		
		lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblComb = new JLabel("Combustivel:");
		lblComb.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoComb = new JTextField();
		campoComb.setColumns(10);
		
		lblKm = new JLabel("Quilometragem:");
		lblKm.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoVersao = new JTextField();
		campoVersao.setColumns(10);
		
		lblVersao = new JLabel("Vers\u00E3o:");
		lblVersao.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoKm = new JTextField();
		campoKm.setColumns(10);
		
		lblCambio = new JLabel("C\u00E2mbio:");
		lblCambio.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoCambio = new JTextField();
		campoCambio.setColumns(10);
		
		lblPortas = new JLabel("Portas:");
		lblPortas.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		campoPortas = new JTextField();
		campoPortas.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCambio, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPreco, Alignment.TRAILING)
								.addComponent(lblCor, Alignment.TRAILING)
								.addComponent(lblPlaca, Alignment.TRAILING)
								.addComponent(lblMarca, Alignment.TRAILING)
								.addComponent(lblModelo, Alignment.TRAILING))
							.addGap(27)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(campoPreco)
										.addComponent(campoMarca)
										.addComponent(campoCor)
										.addComponent(campoCambio)
										.addComponent(campoPlaca))
									.addGap(6)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblKm)
										.addComponent(lblComb)
										.addComponent(lblVersao)
										.addComponent(lblAno)
										.addComponent(lblPortas))
									.addGap(18)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(campoKm)
										.addComponent(campoComb)
										.addComponent(campoPortas)
										.addComponent(campoVersao)
										.addComponent(campoAno)))
								.addComponent(campoModelo, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAbrir)
								.addComponent(painelImagem, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblModelo)
								.addComponent(campoModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(campoMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblMarca))
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(campoAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblAno)))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(campoPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPlaca))
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(campoVersao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblVersao)))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(campoCor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCor))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(campoPortas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPortas))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(campoComb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblComb)))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(campoPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPreco))))
							.addGap(12)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(campoKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(campoCambio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCambio)
									.addComponent(lblKm))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(painelImagem, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAbrir)))
					.addGap(36)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(95))
		);
		gl_contentPanel.linkSize(SwingConstants.VERTICAL, new Component[] {campoModelo, campoMarca});
		{
			image = new JLabel("");
			painelImagem.add(image);
		}
		{
			btnSalvar = new JButton("Salvar");
			btnSalvar.addActionListener(this);
			panel.add(btnSalvar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			panel.add(btnCancelar);
		}
		contentPanel.setLayout(gl_contentPanel);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAbrir) {
			do_btnAbrir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalvar) {
			do_btnSalvar_actionPerformed(arg0);
		}
	}
	protected void do_btnSalvar_actionPerformed(ActionEvent arg0) {
		conexao.conectar();
		if(edicao){
			veiculo.setModelo(campoModelo.getText());
			veiculo.setMarca(campoMarca.getText());
			veiculo.setAno(Integer.parseInt(campoAno.getText()));
			veiculo.setPlaca(campoPlaca.getText());
			veiculo.setCor(campoCor.getText());
			veiculo.setPreco(Double.parseDouble(campoPreco.getText()));
			veiculo.setCombustivel(campoComb.getText());
			veiculo.setCambio(campoCambio.getText());
			veiculo.setPortas(Integer.parseInt(campoPortas.getText()));
			veiculo.setKm(Integer.parseInt(campoKm.getText()));
			veiculo.setVersao(campoVersao.getText());
			
			if(imagem != null){
				veiculo.setImagem(getImagem());
			}
			conexao.alterar(veiculo);
			model.refreshData(conexao.listar());
			JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
			conexao.fecharCon();
			dispose();
			
		}else{
			Veiculo veiculo = new Veiculo();
			veiculo.setModelo(campoModelo.getText());
			veiculo.setMarca(campoMarca.getText());
			veiculo.setAno(Integer.parseInt(campoAno.getText()));
			veiculo.setPlaca(campoPlaca.getText());
			veiculo.setCor(campoCor.getText());
			veiculo.setPreco(Double.parseDouble(campoPreco.getText()));
			veiculo.setCombustivel(campoComb.getText());
			veiculo.setCambio(campoCambio.getText());
			veiculo.setPortas(Integer.parseInt(campoPortas.getText()));
			veiculo.setKm(Integer.parseInt(campoKm.getText()));
			veiculo.setVersao(campoVersao.getText());
			
			veiculo.setImagem(getImagem());
			conexao.inserir(veiculo);
			model.refreshData(conexao.listar());
			JOptionPane.showMessageDialog(this, "O registro foi salvo com sucesso!");
			conexao.fecharCon();
			dispose();			
		}
	}
	
	public File selecionarImagem(){
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens em JPEG e PNG", "jpg","png");
		fileChooser.addChoosableFileFilter(filtro);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		fileChooser.setCurrentDirectory(new File("/"));
		fileChooser.showOpenDialog(this);
		
		return fileChooser.getSelectedFile();
	}
	
	private byte[] getImagem(){
		boolean isPng = false;
		
		if(imagem != null){
			isPng = imagem.getName().endsWith("png");
			
			try {
				
				BufferedImage image = ImageIO.read(imagem);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				int type = BufferedImage.TYPE_INT_RGB;
				
				if(isPng){
					type = BufferedImage.BITMASK;
				}
				
				BufferedImage novaImagem = new BufferedImage(painelImagem.getWidth() - 5, painelImagem.getHeight() - 10, type);
				Graphics2D g = novaImagem.createGraphics();
				g.setComposite(AlphaComposite.Src);
				g.drawImage(image, 0,0, painelImagem.getWidth() -5, painelImagem.getHeight() -10, null);
				
				if(isPng){
					ImageIO.write(novaImagem, "png", out);
				}else{
					ImageIO.write(novaImagem, "jpg", out);
				}
				
				out.flush();
				byte[] byteArray = out.toByteArray();
				out.close();
				
				return byteArray;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	protected void do_btnAbrir_actionPerformed(ActionEvent arg0) {
		imagem = selecionarImagem();
		abrirImagem(imagem);
	}
	
	private void setDados(){
		campoModelo.setText(veiculo.getModelo());
		campoMarca.setText(veiculo.getMarca());
		campoAno.setText(String.valueOf(veiculo.getAno()));
		campoPlaca.setText(veiculo.getPlaca());
		campoCor.setText(veiculo.getCor());
		campoPreco.setText(String.valueOf(veiculo.getPreco()));
		campoComb.setText(veiculo.getCombustivel());
		campoCambio.setText(veiculo.getCambio());
		campoPortas.setText(String.valueOf(veiculo.getPortas()));
		campoKm.setText(String.valueOf(veiculo.getKm()));
		campoVersao.setText(veiculo.getVersao());
		abrirImagem(veiculo.getImagem());
	}
	
	private void abrirImagem(Object source){
		if(source instanceof File){
			ImageIcon icon = new ImageIcon(imagem.getAbsolutePath());
			icon.setImage(icon.getImage().getScaledInstance(painelImagem.getWidth()-5, painelImagem.getHeight() -10, 100));
			image.setIcon(icon);
		}else if(source instanceof byte[]){
			ImageIcon icon = new ImageIcon(veiculo.getImagem());
			icon.setImage(icon.getImage().getScaledInstance(painelImagem.getWidth()-5, painelImagem.getHeight() -10, 100));
			image.setIcon(icon);
		}
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}

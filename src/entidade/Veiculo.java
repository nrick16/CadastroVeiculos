package entidade;

public class Veiculo {
	
	private Long idveiculo;
	private String modelo;
	private String marca;
	private Integer ano;
	private String placa;
	private byte[] imagem;
	private String cor;
	private Double preco;
	private String combustivel;
	private String cambio;
	private Integer portas;
	private Integer km;
	private String versao;
	
	public Long getIdveiculo() {
		return idveiculo;
	}
	public void setIdveiculo(Long idveiculo) {
		this.idveiculo = idveiculo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public int getPortas() {
		return portas;
	}
	public void setPortas(Integer portas) {
		this.portas = portas;
	}
	public int getKm() {
		return km;
	}
	public void setKm(Integer km) {
		this.km = km;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	
}

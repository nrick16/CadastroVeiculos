package util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidade.Veiculo;

public class TableModel extends AbstractTableModel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2564788613864602172L;

	private List<Veiculo> lista;
	
	private String[] colunas = {"Código","Modelo","Marca","Ano","Placa","Cor","Preço", "Combustível","Câmbio", "Portas", "Quilometragem", ""};
	
	
	public TableModel(List<Veiculo> lista) {
		this.lista = lista;
	}


	@Override
	public int getColumnCount() {
		return colunas.length;
	}


	@Override
	public int getRowCount() {
		return lista.size();
	}
	
	@Override
	public String getColumnName(int columnIndex){
		return colunas[columnIndex];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		return String.class;
	}
	
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex){
		Veiculo veiculo = lista.get(rowIndex);
		
		switch(columnIndex){
		case 0:
			veiculo.setIdveiculo(Long.parseLong(aValue.toString()));
		case 1:
			veiculo.setModelo(aValue.toString());
		case 2:
			veiculo.setMarca(aValue.toString());
		case 3:
			veiculo.setAno(Integer.parseInt(aValue.toString()));
		case 4:
			veiculo.setPlaca(aValue.toString());
		case 5:
			veiculo.setCor(aValue.toString());
		case 6:
			veiculo.setPreco(Double.parseDouble(aValue.toString()));
		case 7:
			veiculo.setCombustivel(aValue.toString());
		case 8:
			veiculo.setCambio(aValue.toString());
		case 9:
			veiculo.setPortas(Integer.parseInt(aValue.toString()));
		case 10:
			veiculo.setKm(Integer.parseInt(aValue.toString()));
		case 11:
			veiculo.setVersao(aValue.toString());
		default:
			System.err.println("Indice da coluna Ã© invalido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Veiculo veiculoSelecionado = lista.get(rowIndex);
		Object valueObject = null;
		
		switch(columnIndex){
		case 0:
			valueObject = veiculoSelecionado.getIdveiculo();
			break;
		case 1:
			valueObject = veiculoSelecionado.getModelo();
			break;
		case 2:
			valueObject = veiculoSelecionado.getMarca();
			break;
		case 3:
			valueObject = veiculoSelecionado.getAno();
			break;
		case 4:
			valueObject = veiculoSelecionado.getPlaca();
			break;
		case 5:
			valueObject = veiculoSelecionado.getCor();
			break;
		case 6:
			valueObject = veiculoSelecionado.getPreco();
			break;
		case 7:
			valueObject = veiculoSelecionado.getCombustivel();
			break;
		case 8:
			valueObject = veiculoSelecionado.getCambio();
			break;
		case 9:
			valueObject = veiculoSelecionado.getPortas();
			break;
		case 10:
			valueObject = veiculoSelecionado.getKm();
			break;
		case 11:
			valueObject = veiculoSelecionado.getVersao();
			break;
			default:
		}
		
		return valueObject;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){
		return false;
	}
	
	
	public Object getSelecionado(int rowIndex){
		return lista.get(rowIndex);
	}
	
	public void refreshData(List<Veiculo> novosVeiculos){
		this.lista = novosVeiculos;
		fireTableDataChanged();
	}
	
	public void limpar(){
		lista.clear();
		fireTableDataChanged();
	}
	
	public boolean isEmpity(){
		return lista.isEmpty();
	}

}

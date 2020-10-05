package br.com.eltonpignatel.model;

import br.com.eltonpignatel.exceptions.EspecificacaoSemSufixoException;

public class NotaCorretagemLancto {
	private String negociacao;
	private String C_V;
	private String tipoMercado;
	private String especificacaoTitulo;
	private Integer quantidade;
	private Double precoAjuste;
	private Double valorOperacaoAjuste;
	private String D_C;
	private Integer folha;
	private Integer sufixoTicker;
	
	public String getNegociacao() {
		return negociacao;
	}
	public void setNegociacao(String negociacao) {
		this.negociacao = negociacao;
	}
	public String getC_V() {
		return C_V;
	}
	public void setC_V(String c_V) {
		C_V = c_V;
	}
	public String getTipoMercado() {
		return tipoMercado;
	}
	public void setTipoMercado(String tipoMercado) {
		this.tipoMercado = tipoMercado;
	}
	public String getEspecificacaoTitulo() {
		return especificacaoTitulo;
	}
	public void setEspecificacaoTitulo(String especificacaoTitulo) {
		this.especificacaoTitulo = especificacaoTitulo;
		
		try {
			this.sufixoTicker = extrairSufixoTitulo(especificacaoTitulo);
		} catch (Exception e) {
			
		}
		
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPrecoAjuste() {
		return precoAjuste;
	}
	public void setPrecoAjuste(Double precoAjuste) {
		this.precoAjuste = precoAjuste;
	}
	public Double getValorOperacaoAjuste() {
		return valorOperacaoAjuste;
	}
	public void setValorOperacaoAjuste(Double valorOperacaoAjuste) {
		this.valorOperacaoAjuste = valorOperacaoAjuste;
	}
	public String getD_C() {
		return D_C;
	}
	public void setD_C(String d_C) {
		D_C = d_C;
	}
	public Integer getFolha() {
		return folha;
	}
	public void setFolha(Integer folha) {
		this.folha = folha;
	}
	public Integer getSufixoTicker() {
		return sufixoTicker;
	}
	
	private Integer extrairSufixoTitulo (String especificacaoTitulo) throws EspecificacaoSemSufixoException {
		
		if (especificacaoTitulo.endsWith("ON NM")) {
			return 3;			
		} else if (especificacaoTitulo.endsWith("PN N1")) {
			return 4;
		} else if (especificacaoTitulo.endsWith("UNT N2")) {
			return 11;
		} else {
			throw new EspecificacaoSemSufixoException();
		}
		
	}
	
	
	@Override
	public String toString() {
		return "NotaCorretagemLancto [negociacao=" + negociacao + ", C_V=" + C_V + ", tipoMercado=" + tipoMercado
				+ ", especificacaoTitulo=" + especificacaoTitulo + ", quantidade=" + quantidade + ", precoAjuste="
				+ precoAjuste + ", valorOperacaoAjuste=" + valorOperacaoAjuste + ", D_C=" + D_C + ", folha=" + folha
				+ ", sufixoTicker=" + sufixoTicker + "]";
	}
	
}

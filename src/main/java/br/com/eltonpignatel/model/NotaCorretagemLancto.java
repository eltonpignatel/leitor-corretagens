package br.com.eltonpignatel.model;

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
	
	@Override
	public String toString() {
		return "NotaCorretagemLancto [negociacao=" + negociacao + ", C_V=" + C_V + ", tipoMercado=" + tipoMercado
				+ ", especificacaoTitulo=" + especificacaoTitulo + ", quantidade=" + quantidade + ", precoAjuste="
				+ precoAjuste + ", valorOperacaoAjuste=" + valorOperacaoAjuste + ", D_C=" + D_C + ", folha=" + folha
				+ ", getNegociacao()=" + getNegociacao() + ", getC_V()=" + getC_V() + ", getTipoMercado()="
				+ getTipoMercado() + ", getEspecificacaoTitulo()=" + getEspecificacaoTitulo() + ", getQuantidade()="
				+ getQuantidade() + ", getPrecoAjuste()=" + getPrecoAjuste() + ", getValorOperacaoAjuste()="
				+ getValorOperacaoAjuste() + ", getD_C()=" + getD_C() + ", getFolha()=" + getFolha() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}

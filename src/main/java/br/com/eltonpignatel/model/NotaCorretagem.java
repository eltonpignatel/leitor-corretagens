package br.com.eltonpignatel.model;

import java.util.Date;
import java.util.List;

public class NotaCorretagem {
	
	private Integer numeroCorretagem;
	private String corretora;
	private Date dataPregao;
	private Double valorLiquidoOperacoes;
	private Double taxaLiquidacao;
	private Double taxaRegistro;
	private Double taxaTermoOpcoes;
	private Double taxaANA;
	private Double emolumentos;
	private Double taxaOperacional;
	private Double execucao;
	private Double taxaCustodia;
	private Double impostos;
	private Double baseIRRF;
	private Double valorIRRF;
	private Double outros;
	private List<NotaCorretagemLancto> lanctos;
	
	public NotaCorretagem() {
		super();
	}
	
	public Integer getNumeroCorretagem() {
		return numeroCorretagem;
	}
	public void setNumeroCorretagem(Integer numeroCorretagem) {
		this.numeroCorretagem = numeroCorretagem;
	}
	public String getCorretora() {
		return corretora;
	}
	public void setCorretora(String corretora) {
		this.corretora = corretora;
	}
	public Date getDataPregao() {
		return dataPregao;
	}
	public void setDataPregao(Date dataPregao) {
		this.dataPregao = dataPregao;
	}
	public Double getValorLiquidoOperacoes() {
		return valorLiquidoOperacoes;
	}
	public void setValorLiquidoOperacoes(Double valorLiquidoOperacoes) {
		this.valorLiquidoOperacoes = valorLiquidoOperacoes;
	}
	public Double getTaxaLiquidacao() {
		return taxaLiquidacao;
	}
	public void setTaxaLiquidacao(Double taxaLiquidacao) {
		this.taxaLiquidacao = taxaLiquidacao;
	}
	public Double getTaxaRegistro() {
		return taxaRegistro;
	}
	public void setTaxaRegistro(Double taxaRegistro) {
		this.taxaRegistro = taxaRegistro;
	}
	public Double getTaxaTermoOpcoes() {
		return taxaTermoOpcoes;
	}
	public void setTaxaTermoOpcoes(Double taxaTermoOpcoes) {
		this.taxaTermoOpcoes = taxaTermoOpcoes;
	}
	public Double getTaxaANA() {
		return taxaANA;
	}
	public void setTaxaANA(Double taxaANA) {
		this.taxaANA = taxaANA;
	}
	public Double getEmolumentos() {
		return emolumentos;
	}
	public void setEmolumentos(Double emolumentos) {
		this.emolumentos = emolumentos;
	}
	public Double getTaxaOperacional() {
		return taxaOperacional;
	}
	public void setTaxaOperacional(Double taxaOperacional) {
		this.taxaOperacional = taxaOperacional;
	}
	public Double getExecucao() {
		return execucao;
	}
	public void setExecucao(Double execucao) {
		this.execucao = execucao;
	}
	public Double getTaxaCustodia() {
		return taxaCustodia;
	}
	public void setTaxaCustodia(Double taxaCustodia) {
		this.taxaCustodia = taxaCustodia;
	}
	public Double getImpostos() {
		return impostos;
	}
	public void setImpostos(Double impostos) {
		this.impostos = impostos;
	}
	
	public Double getOutros() {
		return outros;
	}
	public Double getValorIRRF() {
		return valorIRRF;
	}
	public Double getBaseIRRF() {
		return baseIRRF;
	}
	public void setBaseIRRF(Double baseIRRF) {
		this.baseIRRF = baseIRRF;
	}
	public void setValorIRRF(Double valorIRRF) {
		this.valorIRRF = valorIRRF;
	}
	public void setOutros(Double outros) {
		this.outros = outros;
	}
	public List<NotaCorretagemLancto> getLanctos() {
		return lanctos;
	}
	public void setLanctos(List<NotaCorretagemLancto> lanctos) {
		this.lanctos = lanctos;
	}
	@Override
	public String toString() {
		return "NotaDeCorretagem [numeroCorretagem=" + numeroCorretagem + ", corretora=" + corretora + ", dataPregao="
				+ dataPregao + ", valorLiquidoOperacoes=" + valorLiquidoOperacoes + ", taxaLiquidacao=" + taxaLiquidacao
				+ ", taxaRegistro=" + taxaRegistro + ", taxaTermoOpcoes=" + taxaTermoOpcoes + ", taxaANA=" + taxaANA
				+ ", emolumentos=" + emolumentos + ", taxaOperacional=" + taxaOperacional + ", execucao=" + execucao
				+ ", taxaCustodia=" + taxaCustodia + ", impostos=" + impostos + ", baseIRRF=" + baseIRRF
				+ ", valorIRRF=" + valorIRRF + ", outros=" + outros + ", lanctos=" + lanctos + "]";
	}
	
	
	
	
}

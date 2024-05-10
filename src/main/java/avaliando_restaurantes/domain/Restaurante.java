package avaliando_restaurantes.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Restaurante implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String nome;
	private Double media;
	private List<AvaliacaoDTO> avaliacoes = new ArrayList<>();

	public Restaurante() {
		super();
	}

	public Restaurante(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AvaliacaoDTO> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoDTO> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public Double media() {
		if (avaliacoes.isEmpty()) {
			return 0.0;
		}
		double soma = 0.0;
		for (AvaliacaoDTO avaliacao : avaliacoes) {
			soma += avaliacao.getNota();
		}

		return soma / avaliacoes.size();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		return Objects.equals(id, other.id);
	}

}

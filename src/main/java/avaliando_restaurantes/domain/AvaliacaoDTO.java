package avaliando_restaurantes.domain;

import java.io.Serializable;
import java.util.Objects;

public class AvaliacaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private Double nota;
	private String desc;
	
	public AvaliacaoDTO() {
		super();
	}
	public AvaliacaoDTO(Avaliacao avaliacao) {
		super();
		this.id = avaliacao.getId();
		this.nota = avaliacao.getNota();
		this.desc = avaliacao.getDesc();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
		AvaliacaoDTO other = (AvaliacaoDTO) obj;
		return Objects.equals(id, other.id);
	}
}

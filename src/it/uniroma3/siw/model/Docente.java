package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {
	
	/* variabili di istanza */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cognome;
	
	private LocalDate nascita;
	private String luogo_nascita;
	
	@Column(unique=true)
	private String partita_iva;
	
	/* Politica di FETCH modificata in EAGER: poichè credo che quando si è 
	 * interessati ad un docente, lo si è (quasi sempre) anche ai suoi corsi.
	 * Ho deciso quindi che quando viene caricato dal database un docente, vengono
	 * caricati anche i suoi corsi. */
	@OneToMany(mappedBy="docente")
	private List<Corso> corsi;

	/* costruttore */
	public Docente(String nome, String cognome, LocalDate nascita, String luogo_nascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.nascita = nascita;
		this.luogo_nascita = luogo_nascita;
	}

	/* getters e setters */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getNascita() {
		return nascita;
	}

	public void setNascita(LocalDate nascita) {
		this.nascita = nascita;
	}

	public String getLuogo_nascita() {
		return luogo_nascita;
	}

	public void setLuogo_nascita(String luogo_nascita) {
		this.luogo_nascita = luogo_nascita;
	}

	public String getPartita_iva() {
		return partita_iva;
	}

	public void setPartita_iva(String partita_iva) {
		this.partita_iva = partita_iva;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	

}

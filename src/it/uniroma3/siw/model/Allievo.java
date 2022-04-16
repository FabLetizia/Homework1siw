package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {
	
	/*variabili di istanza */
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
	private String matricola;
	
	@Column(unique=true)
	private String email;
	
	/* Politica di FETCH predefinita LAZY: poichè credo che quando si è 
	 * interessati ad un allievo, non è importante conoscere anche tutti 
	 * i corsi a cui è iscritto.
	 * Ho deciso quindi che quando viene caricato dal database un allievo, non vengono
	 * caricati anche i suoi corsi. */
	@ManyToMany
	private List<Corso> corsi;
	
	/* Politica di FETCH predefinita EAGER: poichè credo che quando si è 
	 * interessati ad un allievo, è utile conoscere la società di cui è dipendente.
	 * Ho deciso quindi che quando viene caricato dal database un allievo, viene
	 * caricato anche la sua società. */
	@ManyToOne
	private Società società;

	/* costruttore */
	public Allievo(String nome, String cognome, String matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
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

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	public Società getSocietà() {
		return società;
	}

	public void setSocietà(Società società) {
		this.società = società;
	}
	

}

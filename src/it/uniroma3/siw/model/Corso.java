package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {
	
	/* variabili di istanza */
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	private LocalDate inizio;
	private int durata; //num mesi
	
	
	/* Ho scelto di utilizzare la cascade con aggiunta, aggiornamento e rimozione 
	 * perchè per me, quando rendo persistente nel db un corso, conviene rendere 
	 * persistente anche il docente che tiene il corso (così per merge e remove).
	 * Non ho trovato utile generare altri eventi a cascata nel resto del codice */
	
	/* Politica di FETCH predefinita EAGER: poichè credo che quando si è 
	 * interessati ad un corso, lo si è (quasi sempre) anche del docente.
	 * Ho deciso quindi che quando viene caricato dal database un corso, viene
	 * caricato anche il suo docente. */
	@ManyToOne(cascade= {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.REMOVE})
	private Docente docente;
	
	/* Politica di FETCH predefinita LAZY: poichè credo che quando si è 
	 * interessati ad un corso, non è importante conoscere anche tutti gli allievi.
	 * Ho deciso quindi che quando viene caricato dal database un corso, non vengono
	 * caricati anche i suoi allievi. */
	@ManyToMany(mappedBy="corsi")
	private List<Allievo> allievi;

	/* costruttore */
	public Corso(String nome, LocalDate inizio, int durata, Docente docente) {
		this.nome = nome;
		this.inizio = inizio;
		this.durata = durata;
		this.docente = docente;
	}

	/* getters e setters */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getInizio() {
		return inizio;
	}

	public void setInizio(LocalDate inizio) {
		this.inizio = inizio;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}
	

}

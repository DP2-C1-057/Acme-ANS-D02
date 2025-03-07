
package acme.realms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import acme.entities.airlines.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Manager extends AbstractRole {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@Mandatory
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z]{2,3}\\d{6}$")
	private String				idNumber;

	@Mandatory
	@ValidNumber(min = 0)
	@Automapped
	private int					experienceYears;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				birthdate;

	@Optional
	@ValidUrl
	@Automapped
	private String				picture;

	// Relationships ----------------------------------------------------------
	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Airline				airline;
}

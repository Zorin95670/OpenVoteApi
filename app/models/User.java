package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Model;
import play.data.validation.Constraints;

@Entity
public class User extends Model {

	@Id
	@Constraints.Email
	public String email;

	public String firstName;

	public String lastName;

	@Constraints.MinLength(10)
	public String login;

	@Constraints.MinLength(10)
	public String password;
}

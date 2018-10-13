package dao;

import javax.inject.Inject;

import play.db.jpa.JPAApi;

/**
 * JPA repository.
 *
 * @author vincent
 *
 */
public class JPARepository {
	private final JPAApi jpaApi;
	private final DatabaseExecutionContext executionContext;

	@Inject
	public JPARepository(final JPAApi api, final DatabaseExecutionContext executionContext) {
		this.jpaApi = api;
		this.executionContext = executionContext;
	}
}

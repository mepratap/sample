package com.cubic.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cubic.dao.PersonDAO;
import com.cubic.dao.exception.DBException;
import com.cubic.vo.PersonVO;

public class PersonDAOImpl extends AbstractDAO implements PersonDAO {

	private static final Logger logger = Logger.getLogger(PersonDAOImpl.class);

	private final static String CREATE_SQL = "INSERT INTO PERSON(PERSON_ID,FIRST_NAME,LAST_NAME) VALUES(?,?,?)";
	private final static String UPDATE_SQL = "UPDATE PERSON SET FIRST_NAME=?,LAST_NAME=? WHERE PERSON_ID=?";
	private final static String SELECT_SQL = "SELECT * FROM PERSON";
	private final static String SELECT_ID_SQL = "SELECT * FROM PERSON WHERE PERSON_ID=?";
	private final static String REMOVE_SQL = "DELETE FROM PERSON WHERE PERSON_ID=?";

	public PersonVO createPerson(PersonVO person) throws DBException {
		logger.debug("entering inside createperson");
		if (person == null || StringUtils.isEmpty(person.getFirstName()) || StringUtils.isEmpty(person.getLastName()))
			throw new IllegalArgumentException("invalid data to create person record");
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			logger.debug("entering to try");
			connection = this.getConnection();
			Long seqId = this.getNextSequence(connection);
			statement = connection.prepareStatement(CREATE_SQL);
			statement.setLong(1, seqId);
			statement.setString(2, person.getFirstName().trim());
			statement.setString(3, person.getLastName().trim());
			statement.executeUpdate();
			person.setId(seqId);
		} catch (Exception e) {
			logger.error("error occured");
			e.printStackTrace();
			throw new DBException("error occured in createperson", e);
		} finally {
			this.close(statement);
			this.close(connection);
		}
		return person;
	}

	public PersonVO modifyPerson(PersonVO person) throws DBException {
		if (person == null || StringUtils.isEmpty(person.getFirstName()) || StringUtils.isEmpty(person.getLastName()))
			throw new IllegalArgumentException("invalid to update person record");

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(UPDATE_SQL);
			statement.setString(1, person.getFirstName().trim());
			statement.setString(2, person.getLastName().trim());
			statement.setLong(3, person.getId());
			statement.executeUpdate();
			person = getPerson(person.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("error occured in create person", e);
		} finally {
			this.close(statement);
			this.close(connection);
		}
		return person;

	}

	public PersonVO getPerson(Long pk) throws DBException {
		PersonVO person = null;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(SELECT_ID_SQL);
			System.out.println("Printing id from daoimpl: " + pk);
			statement.setLong(1, pk);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println("Printing from getPerson: " + resultSet.getLong(1) + resultSet.getString(2));
				person = new PersonVO(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("error occured in select persons", e);
		} finally {
			this.close(statement);
			this.close(connection);
		}
		return person;
	}

	public boolean removePerson(Long pk) throws DBException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(REMOVE_SQL);
			statement.setLong(1, pk);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("error in delete person", e);

		} finally {
			this.close(statement);
			this.close(connection);
		}

	}

	public List<PersonVO> getAllPersons() throws DBException {
		List<PersonVO> results = new ArrayList<PersonVO>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(SELECT_SQL);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(new PersonVO(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("error occured in select all persons", e);
		} finally {
			this.close(statement);
			this.close(connection);
		}
		return results;
	}

	private final static String SEARCH_SQL = "select PERSON_ID, FIRST_NAME, LAST_NAME from PERSON "
			+ "where (UPPER(FIRST_NAME) like UPPER(?) OR UPPER(LAST_NAME) like UPPER(?))";

	public List<PersonVO> searchPersons(String name) throws DBException {
		List<PersonVO> result = new ArrayList<PersonVO>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(SEARCH_SQL);
			statement.setString(1, name + "%");
			statement.setString(2, name + "%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				PersonVO vo = new PersonVO();
				vo.setId(resultSet.getLong(1));
				vo.setFirstName(resultSet.getString(2));
				vo.setLastName(resultSet.getString(3));
				result.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("error occured in searchperson", e);
		} finally {
			this.close(statement);
			this.close(connection);
		}

		return result;
	}

}

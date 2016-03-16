package com.cubic.dao;

import java.util.List;

import com.cubic.dao.exception.DBException;
import com.cubic.vo.PersonVO;

public interface PersonDAO {

	PersonVO createPerson(final PersonVO person) throws DBException;

	PersonVO modifyPerson(final PersonVO person) throws DBException;

	PersonVO getPerson(final Long pk) throws DBException;

	boolean removePerson(final Long pk) throws DBException;

	List<PersonVO> getAllPersons() throws DBException;

	List<PersonVO> searchPersons(final String name) throws DBException;

}

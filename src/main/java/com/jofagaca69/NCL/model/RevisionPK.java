package com.jofagaca69.NCL.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the revisiones database table.
 * 
 */
@Embeddable
public class RevisionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	public RevisionPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RevisionPK other = (RevisionPK) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
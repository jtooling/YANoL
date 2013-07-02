package com.github.jtooling.yanol.persistence;

import java.util.Set;

import com.github.jtooling.yanol.data.Message;
import com.github.jtooling.yanol.data.Profile;

public interface IPersistenceConnector {

	public void persist(Set<Message> messages, Set<Profile> profiles);

}

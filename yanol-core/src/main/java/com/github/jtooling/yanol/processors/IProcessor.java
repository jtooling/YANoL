package com.github.jtooling.yanol.processors;

import com.github.jtooling.yanol.data.Message;
import com.github.jtooling.yanol.data.Profile;

public interface IProcessor {

	public void process(Message message, Profile profile);

}

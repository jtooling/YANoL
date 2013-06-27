package com.github.jtooling.yanol.data;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;

import com.google.common.base.Optional;

public class SimpleMessageItem {

	private String title;
	private String content;
	private Optional<Date> processedOn;

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		checkNotNull(title, "Title cannot be null");
		checkArgument(title.length() > 0,
				"Empty string cannot be used as a title");
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		checkNotNull(content, "Content cannot be null");
		checkArgument(content.length() > 0,
				"Empty string cannot be used as a content");
		this.content = content;
	}

	public Optional<Date> getProcessedOn() {
		return processedOn;
	}

	public void setProcessedOn(final Date processedOn) {
		checkNotNull(processedOn, "Processed date cannot be null");
		checkArgument(processedOn.compareTo(new Date()) < 0,
				"Processed date cannot be in the future");
	}

	public void processed() {
		processedOn = Optional.of(new Date());
	}

}

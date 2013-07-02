package com.github.jtooling.yanol.data;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;

import com.google.common.base.Optional;

public class Message {

	private String id;
	private String title;
	private String content;
	private Optional<Date> processedOn;
	private Optional<String> profileId;

	public static class Builder {
		protected final String id, title, content;
		protected Optional<String> profileId;

		public Builder(final String id, final String title, final String content) {
			checkNotNull(id, "ID cannot be null");
			checkArgument(id.length() > 0,
					"Empty string cannot be used as an id");
			checkNotNull(title, "Title cannot be null");
			checkArgument(title.length() > 0,
					"Empty string cannot be used as a title");
			checkNotNull(content, "Content cannot be null");
			checkArgument(content.length() > 0,
					"Empty string cannot be used as a content");
			this.id = id;
			this.title = title;
			this.content = content;
		}

		public Builder profileId(final String profileId) {
			checkNotNull(profileId, "ProfileId cannot be null");
			checkArgument(profileId.length() > 0,
					"Empty string cannot be used as a profileId");
			this.profileId = Optional.of(profileId);
			return this;
		}

		public Message build() {
			return new Message(this);
		}
	}

	private Message(final Builder builder) {
		id = builder.id;
		title = builder.title;
		content = builder.content;
		profileId = builder.profileId;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		checkNotNull(id, "ID cannot be null");
		checkArgument(id.length() > 0, "Empty string cannot be used as an id");
		this.id = id;
	}

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

	public Optional<String> getProfileId() {
		return profileId;
	}

	public void setProfileId(final String profileId) {
		checkNotNull(profileId, "ProfileId cannot be null");
		checkArgument(profileId.length() > 0,
				"Empty string cannot be used as a profileId");
		this.profileId = Optional.of(profileId);
	}

}

package com.github.jtooling.yanol.data;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Optional;

public class Profile {

	private String id;
	private String name;
	private Optional<String> description;
	private Configuration configuration;

	public static class Builder {
		protected final String id, name;
		protected final Configuration configuration;
		protected Optional<String> description;

		public Builder(final String id, final String name,
				final Configuration configuration) {
			checkNotNull(id, "ID cannot be null");
			checkArgument(id.length() > 0,
					"Empty string cannot be used as an id");
			checkNotNull(name, "Name cannot be null");
			checkArgument(name.length() > 0,
					"Empty string cannot be used as a name");
			checkNotNull(configuration, "Configuration cannot be null");
			this.id = id;
			this.name = name;
			this.configuration = configuration;
		}

		public Builder description(final String description) {
			checkNotNull(description, "Description cannot be null");
			checkArgument(description.length() > 0,
					"Empty string cannot be used as a description");
			this.description = Optional.of(description);
			return this;
		}

		public Profile build() {
			return new Profile(this);
		}
	}

	private Profile(final Builder builder) {
		id = builder.id;
		name = builder.name;
		description = builder.description;
		configuration = builder.configuration;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		checkNotNull(id, "ID cannot be null");
		checkArgument(id.length() > 0, "Empty string cannot be used as an id");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		checkNotNull(name, "Name cannot be null");
		checkArgument(name.length() > 0,
				"Empty string cannot be used as a name");
		this.name = name;
	}

	public Optional<String> getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		checkNotNull(description, "Description cannot be null");
		checkArgument(description.length() > 0,
				"Empty string cannot be used as a description");
		this.description = Optional.of(description);
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(final Configuration configuration) {
		checkNotNull(configuration, "Configuration cannot be null");
		this.configuration = configuration;
	}

}

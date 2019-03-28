package org.formation;

import java.net.URL;

import javax.validation.constraints.Pattern;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "notification")
public class MailConfiguration {

	private URL host;
	private int port;
	private String username, password;

	@Pattern(regexp = "smtp")
	private String protocol;

	private boolean auth, startls, debug;

	public URL getHost() {
		return host;
	}

	public void setHost(URL host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public boolean isStartls() {
		return startls;
	}

	public void setStartls(boolean startls) {
		this.startls = startls;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
	

}

package net.programming.languange.VirtualFox.tokenizer;
 
public class Token {
	public String token;
	public TokenType type;
	
	public Token(String token, TokenType type){
		this.token = token;
		this.type = type;
	}
	public String getToken() {
		return token;
	}
	public TokenType getType() {
		return type;
	}
}

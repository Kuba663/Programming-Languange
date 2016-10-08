package net.programming.languange.VirtualFox.tokenizer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
	private ArrayList<TokenData> tokenData;
	private String str;
	private Token lastToken;
	private boolean pushBack;
	
	public Tokenizer(String str) {
		this.tokenData = new ArrayList<TokenData>();
		this.str = str;
		
		tokenData.add(new TokenData(Pattern.compile("[a-zA-Z][a-zA-Z0-9]*"), TokenType.IDENTIFER));
		tokenData.add(new TokenData(Pattern.compile("(-)?[0-9]+"), TokenType.INTEGER_LITERAL));
		tokenData.add(new TokenData(Pattern.compile("\".*\""), TokenType.STRING_LITERAL));
		tokenData.add(new TokenData(Pattern.compile("(-)?[0.0-9.999]+"), TokenType.FLOAT_LITERAL));
		tokenData.add(new TokenData(Pattern.compile("[00-FF]"), TokenType.BYTE_LITERAL));
		tokenData.add(new TokenData(Pattern.compile("[00-FFFF]"), TokenType.REGISTER_LITERAL));
		
		for (String t : new String[] {"-", "\\(", "\\)", "\\.","\\,"}) {
			tokenData.add(new TokenData(Pattern.compile(t), TokenType.TOKEN));
		}
	}
	public Token nextToken() {
		str = str.trim();
		if (pushBack) {
			pushBack = false;
			return lastToken;
		}
		if (str.isEmpty()) {
			return (lastToken = new Token("", TokenType.EMPTY));
		}
		for (TokenData data : tokenData) {
			Matcher matcher = data.getPattern().matcher(str);
			if (matcher.find()) {
				String token = matcher.group().trim();
				str = matcher.replaceFirst("");
				if (data.getType() == TokenType.STRING_LITERAL) {
					return (lastToken = new Token(token.substring(1, token.length() - 1), TokenType.STRING_LITERAL));
				}
				else {
					return (lastToken = new Token(token, data.getType()));
				}
			}
		}
		throw new IllegalStateException("could not parse" + str);
	}
	public boolean hasNextToken() {
		return !str.isEmpty();
	}
	public void pushBack() {
		if (lastToken != null) {
			this.pushBack = true;
		}
	}
}

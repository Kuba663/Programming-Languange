package net.programming.languange.VirtualFox.parser;

import net.programming.languange.VirtualFox.block.Block;
import net.programming.languange.VirtualFox.block.Class;
import net.programming.languange.VirtualFox.tokenizer.Tokenizer;

public class ClassParser extends Parser<Class> {

	@Override
	public boolean shouldParse(String line) {
		// TODO Auto-generated method stub
		return line.matches("class [a-zA-Z][a-zA-Z0-9]*");
	}

	@Override
	public Class parse(Block superBlock, Tokenizer tokenizer) {
		// TODO Auto-generated method stub
		tokenizer.nextToken();
		
		String name = tokenizer.nextToken().getToken();
		
		return new Class(name);
	}
	
}

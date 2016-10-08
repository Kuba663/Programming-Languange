package net.programming.languange.VirtualFox.parser;

import net.programming.languange.VirtualFox.block.Block;
import net.programming.languange.VirtualFox.tokenizer.Tokenizer;

public abstract class Parser<T extends Block> {
	public abstract boolean shouldParse(String line);
	public abstract T parse(Block superBlock, Tokenizer tokenizer);
}

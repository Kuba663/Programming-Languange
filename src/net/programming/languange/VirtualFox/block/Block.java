package net.programming.languange.VirtualFox.block;

import java.util.ArrayList;

public abstract class Block {
	public Block superBlock;
	public ArrayList<Block> subBlocks;
	
	public Block(Block superBlock) {
		this.superBlock = superBlock;
		this.subBlocks = new ArrayList<>();
	}
	
	public Block getSuperBlock() {
		return superBlock;
	}
	
	public void addBlock(Block block) {
		subBlocks.add(block);
	}
	
	public abstract void run();
}

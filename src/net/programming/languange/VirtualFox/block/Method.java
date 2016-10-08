package net.programming.languange.VirtualFox.block;

import net.programming.languange.VirtualFox.Parameter;
import net.programming.languange.VirtualFox.Type;
import net.programming.languange.VirtualFox.Value;

public class Method extends Block {
	private String name;
	private Type type;
	private Parameter[] param;
	private Value returnValue;
	
	public Method(Block superBlock, String name,Type type ,Parameter[] param) {
		super(superBlock);
		
		this.name = name;
		this.type = type;
		this.param = param;
		this.returnValue = returnValue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		invoke();
	}
	public void invoke(Value... values) {
		
	}
}

package net.programming.languange.VirtualFox;

public class Parameter {
	public Type type;
	public String name;
	
	public Parameter(Type type,String name) {
		this.type = type;
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public String getName() {
		return name;
	}
}

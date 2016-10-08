package net.programming.languange.VirtualFox;

public class Value {
	private Object value;
	private Type type;
	
	public Value(Type type,Object value) {
		this.value = value;
		this.type = type;
	}
	public Object getValue() {
		return value;
	}
	public Type getType() {
		return type;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}

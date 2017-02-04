package ao222vn_assign1.intCollection;


public class ArrayIntStack extends AbstractIntCollection implements IntStack {
	
//	Add to the stack
	@Override
	public void push(int n) {
		if(this.size() == this.values.length)
			super.resize();
		this.values[this.size++] = n;
	}

//	Take out and remove from stack
	@Override
	public int pop() throws IndexOutOfBoundsException {
		
		int temp;
		temp = this.values[this.size - 1];
		values[this.size - 1] = 0;
		this.size--;
		
		return temp;
	}

//	Looking at top object in stack
	@Override
	public int peek() throws IndexOutOfBoundsException {
	
		return this.values[this.size - 1];
	}
}

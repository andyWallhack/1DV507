package ao222vn_assign1.intCollection;

public class ArrayIntList extends AbstractIntCollection implements IntList {

//	Add to array list
	@Override
	public void add(int n) {
		if(this.size == this.values.length)
			super.resize();
		this.values[this.size++] = n;
	}

//	Add an object in array list at a specific place
	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {

		super.checkIndex(index, this.size);
		this.values[index] = n;
	}

//	Remove object at index place
	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		
		super.checkIndex(index, this.size);
	
		for(int i = index; i < this.size - 1; i++)
			this.values[i] = this.values[i + 1];
		this.values[this.size - 1] = 0;
		
		this.size--;	
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		super.checkIndex(index, this.size);
		return this.values[index];
	}

	@Override
	public int indexOf(int n) {
		// TODO Auto-generated method stub
		return this.values[n];
	}
}

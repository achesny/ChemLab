package mod.chemlab;

public enum BlockSide {
	BOTTOM(0),TOP(1),LEFT(3),RIGHT(4),FRONT(2),BACK(5);
	
	private int value;

	BlockSide(int index) {
		this.value = index;
	}

	public static BlockSide valueOf(int sideIndex) {
		for (BlockSide side: values()) {
			if (side.value == sideIndex) {
				return side;
			}
		}
		return null;
	}
}

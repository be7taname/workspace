package common;

public class NodeLocation {
    public int level;
    public int offset;

    public NodeLocation(int level, int offset) {
        this.level = level;
        this.offset = offset;
    }

    public NodeLocation() {}
    
    public int toIndex()
    {
    	return (1 << level) + offset;
    }
}

//public class NodeLocation<T> {
//    public T level;
//    public T offset;
//
//    public NodeLocation(T level, T offset) {
//        this.level = level;
//        this.offset = offset;
//    }
//
//    public NodeLocation() {}
//}

package parcialJAVA2doCuatrimestre2018;

import java.util.ArrayList;

public interface Hitable {

	public void rollback(Hit hit);
	public void push(Hit hit);
	public void approve(Hit hit);
	
}

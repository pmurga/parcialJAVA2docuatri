package parcialJAVA2doCuatrimestre2018;

public interface Sujeto {

	public void attach(Observer obs);
	public void dettach (Observer obs);
	public void notifyObservers();
	
	
}

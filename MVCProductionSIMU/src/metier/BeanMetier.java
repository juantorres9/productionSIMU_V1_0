package metier;

import java.time.LocalDateTime;

public class BeanMetier {
	private LocalDateTime startDT;
	private LocalDateTime stopDT;

	private long ecart ;
	private long propiete1;




	//Acceseurs 
	public LocalDateTime getStartDT() {
		return startDT;
	}
	public void setStartDT(LocalDateTime startDT) {
		this.startDT = startDT;
	}
	public LocalDateTime getStopDT() {
		return stopDT;
	}
	public void setStopDT(LocalDateTime stopDT) {
		this.stopDT = stopDT;
	}
	public long getEcart() {
		return ecart;
	}
	public void setEcart(long ecart) {
		this.ecart = ecart;
	}
	public long getPropiete1() {
		return propiete1;
	}
	public void setPropiete1(long propiete1) {
		this.propiete1 = propiete1;
	}

}

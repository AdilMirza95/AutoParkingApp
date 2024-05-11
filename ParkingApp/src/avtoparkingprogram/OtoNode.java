
package avtoparkingprogram;


public class OtoNode {
    String avtNomre;
    String giris;
    String cixis;
    long deq;
    long qiymet;
    
    OtoNode next;
    OtoNode prev;

    public OtoNode(String avtNomre, String giris) {
        this.avtNomre = avtNomre;
        this.giris = giris;
        this.next = null;
        this.prev = null;
        
    }
    
    
    
    
    
    
}

public abstract class semaphore {

    protected int valeur=0;

    protected semaphore (int valeurInitiale){
	valeur = valeurInitiale>0 ? valeurInitiale:0;
    }

    public synchronized void syncWait(){
    	System.out.println("\nj’entre en section critique");
	try {
	    while(valeur<=0){
		wait();
        }
	    valeur--;
	} catch(InterruptedException e){}
    }

    public synchronized void syncSignal(){
    	System.out.println("\nje sors de section critique");
	if(++valeur > 0) notifyAll();
    }
}

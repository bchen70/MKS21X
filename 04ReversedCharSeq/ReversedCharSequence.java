public class ReversedCharSequence implements CharSequence {
    private String seq;
    private String newseq;
		
    public ReversedCharSequence(String seq) {
	this.seq = seq;
	newseq = "";
	for (int x = seq.length() - 1; x >= 0; x--) {
	    newseq += seq.charAt(x);
	}
    }

    public char charAt (int index) {
	return newseq.charAt(index);
    }

    public int length() {
	return newseq.length();
    }

    public ReversedCharSequence subSequence (int start, int end) {
	String sub ="";
	for (int x = start; x < end; x++) {
	    sub += newseq.charAt(x);
	}
	String preans = "";
	for (int i = sub.length() - 1; i >= 0; i--) {
	    preans += sub.charAt(i);
	}
	ReversedCharSequence ans = new ReversedCharSequence(preans);
	return ans;

    }

    public String toString () {
	return newseq;
    }
}
	
    

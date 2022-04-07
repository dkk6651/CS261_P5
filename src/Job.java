public  class Job implements Comparable {

    public int number;
    public int start;
    public int finish;
    public int weight;

    public Job (int number, int start, int finish, int weight) {
	this.number = number;
	this.start = start;
	this.finish = finish;
	this. weight = weight;
    }

    public String toString() {
	return "Job:" + this.number + " " +
	       start + " --> " + finish +
	    " wt: " + weight;
    }

    // This job is before the other job if its finish time is sooner.
    public int compareTo(Object o) {
	Job other = (Job) o;
	return this.finish - other.finish;
    }
    
}


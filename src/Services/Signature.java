package Services;

/*
 * Signature class creates each signature with their attributes, name
 * and score
 */
public class Signature {
	private String name;
	private float score;
	
	//Constructor
	public Signature(String name, float score) {
		this.name = name;
		this.score = score;
	}
	
	//Name getter
	public String getName() {
		return name;
	}
	//Score getter
	public float getScore() {
		return score;
	}	
}

package Services;

/*
 * Interface to rewrite the encoder or decoder
 */
@FunctionalInterface
public interface EncoderInterface {

	public String operation(String string);
}

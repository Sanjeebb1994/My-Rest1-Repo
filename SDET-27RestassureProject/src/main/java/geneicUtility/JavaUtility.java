package geneicUtility;

import java.util.Random;

/**
 * This class contains Java generic Methods.
 * @author DELL
 *
 */
public class JavaUtility {
	/**
	 * This method is use to generate RandomNumber.
	 * @return
	 */
	public int randomNumber() {
		Random rnum=new Random();
		int random=rnum.nextInt(100);
		return random;
	}
}

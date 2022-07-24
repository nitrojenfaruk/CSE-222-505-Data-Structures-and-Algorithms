
/**
 * 
 * Question 1
 *
 */
public class Q1 {

	/**
	 * Recursive function to search a small string in bigger string.
	 * 
	 * @param smallStr    the small string to search in another bigger string
	 * @param bigStr      the big string that may contain small string
	 * @param index       the index indicates the last position in the big string
	 * @param occurrence  the occurrence of small string in big string
	 * @param targetOccur the target occurence that must be found
	 * @return 			  occurence index or -1 if not found
	 */
	public int searchString(String smallStr, String bigStr, int index, int occurrence,
			int targetOccur) {

		int result = 0;
		int temp = 0;
		int beginOfRemainder = 0;

		if (targetOccur <= 0)
			return -1;

		/* BASE CASE */
		if (occurrence == targetOccur)
			return 0;

		if (occurrence > targetOccur) {
			return -1;
		} else {
			index = bigStr.indexOf(smallStr, 0); 
			if (index == -1 && (occurrence == 0 || occurrence < targetOccur)) {
				return -1;
			}
			occurrence++;
			beginOfRemainder = index + smallStr.length();

			if (bigStr.substring(beginOfRemainder).length() > smallStr.length()) {
				temp = (occurrence == 1) ? 0 : smallStr.length();
				result = index + temp
						+ searchString(smallStr, bigStr.substring(beginOfRemainder), index,
								occurrence, targetOccur); 	// Recursive part
			}

			else {
				if (occurrence == targetOccur)
					return index + smallStr.length();
				else {
					return -1;
				}
			}

			return result;
		}
	}
}

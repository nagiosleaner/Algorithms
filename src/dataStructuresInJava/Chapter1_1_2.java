package dataStructuresInJava;

public class Chapter1_1_2 {
	/*
	 * ��дһ���������������Ϸ����
	 */
	public static void main(String[] args) {
		char[][] a = createTwoDimensionalArray();
		String[] d = dictionary();
		findWord(d, a);
	}

	/**
	 * ����row�У�col�еĶ�ά����
	 * 
	 * */
	public static char[][] createTwoDimensionalArray() {
		char[][] a = { { 't', 'h', 'i', 's' }, { 'w', 'a', 't', 's' },
				{ 'o', 'a', 'h', 'g' }, { 'f', 'g', 'd', 't' } };
		return a;
	}

	public static String[] dictionary() {
		String[] d = { "this", "two", "fat", "that" };
		return d;
	}

	public static void findWord(String[] d, char[][] a) {
		for (int i = 0; i < d.length; i++) {// ����ѭ�����Ҵʰ���ĵ���
			String word = d[i];
			int len = word.length();// ��ȷ������
			char firstc = word.charAt(0);// ��һ���ַ�
			for (int j = 0; j < a.length; j++) {// ������ά����
				for (int k = 0; k < a[j].length; k++) {// ������ά����
					if (a[j][k] == firstc) {// �Ƚ�����ĸ����ȼ����ж�
						compareLenth(len, a, j, k, word, len);
					} else {
						continue;// ���ȣ���������
					}
				}
			}
		}
	}

	public static void compareLenth(int lenth, char[][] a, int j, int k,
			String word, int len) {
		int[] lenths = new int[8];
		// ���ᣬ���ᣬ������������б���ϣ�б���£�б���ϣ�б����
		// �ӵ�ǰ��ĸ������ͬ���������ɵ���ĸ������󳤶�
		lenths[0] = a[0].length - k;// ����
		lenths[1] = k + 1;// ����
		lenths[2] = j + 1;// ����
		lenths[3] = a.length - j;// ����
		lenths[4] = j + 1 < a[0].length - k ? j + 1 : a[0].length - k;// б����
		lenths[5] = a.length - j < a[0].length - k ? a.length - j : a[0].length
				- k;// б����
		lenths[6] = j + 1 < k + 1 ? j + 1 : k + 1;// б����
		lenths[7] = k + 1 < a.length - j ? k + 1 : a.length - j;// б����
		for (int x = 0; x < lenths.length; x++) {
			if (lenths[x] >= lenth) {
				compareWord(x, a, j, k, word, len);
			} else {
				continue;
			}

		}
	}

	public static void compareWord(int x, char[][] a, int j, int k,
			String word, int len) {
		String newStr = "";
		switch (x) {
		case 0:// ��[j][k]Ϊԭ�㣬��������len���ַ����string,��word�Ƚϣ�һ����������
			for (int i = 0; i < len; i++) {
				newStr += String.valueOf(a[j][k + i]);
			}
			if (word.equals(newStr))
				System.out.println(word + "λ�ã�(" + j + "," + k + ")��(" + j
						+ "," + (k + len - 1) + ")");
			break;
		case 1:// ��[j][k]Ϊԭ�㣬��������len���ַ����string,��word�Ƚϣ�һ����������
			for (int i = 0; i < len; i++) {
				newStr += String.valueOf(a[j][k - i]);
			}
			if (word.equals(newStr))
				System.out.println(word + "λ�ã�(" + j + "," + k + ")��(" + j
						+ "," + (k - len + 1) + ")");
			break;
		case 2:// ��[j][k]Ϊԭ�㣬���������ϣ�����len���ַ����string,��word�Ƚϣ�һ����������
			for (int i = 0; i < len; i++) {
				newStr += String.valueOf(a[j - i][k]);
			}
			if (word.equals(newStr))
				System.out.println(word + "λ�ã�(" + j + "," + k + ")��("
						+ (j - len + 1) + "," + k + ")");
			break;
		case 3:// ��[j][k]Ϊԭ�㣬���������£�����len���ַ����string,��word�Ƚϣ�һ����������
			for (int i = 0; i < len; i++) {
				newStr += String.valueOf(a[j + i][k]);
			}
			if (word.equals(newStr))
				System.out.println(word + "λ�ã�(" + j + "," + k + ")��("
						+ (j + len - 1) + "," + k + ")");
			break;
		case 4:// ��[j][k]Ϊԭ�㣬б���ϣ���len���ַ����string,��word�Ƚϣ�һ����������
			for (int i = 0; i < len; i++) {
				newStr += String.valueOf(a[j - i][k + i]);
			}
			if (word.equals(newStr))
				System.out.println(word + "λ�ã�(" + j + "," + k + ")��("
						+ (j - len + 1) + "," + (k + len - 1) + ")");
			break;
		case 5:// ��[j][k]Ϊԭ�㣬б���£���len���ַ����string,��word�Ƚϣ�һ����������
			for (int i = 0; i < len; i++) {
				newStr += String.valueOf(a[j + i][k + i]);
			}
			if (word.equals(newStr))
				System.out.println(word + "λ�ã�(" + j + "," + k + ")��("
						+ (j + len - 1) + "," + (k + len - 1) + ")");
			break;
		case 6:// ��[j][k]Ϊԭ�㣬б���ϣ���len���ַ����string,��word�Ƚϣ�һ����������
			for (int i = 0; i < len; i++) {
				newStr += String.valueOf(a[j - i][k - i]);
			}
			if (word.equals(newStr))
				System.out.println(word + "λ�ã�(" + j + "," + k + ")��("
						+ (j - len + 1) + "," + (k - len + 1) + ")");
			break;
		case 7:// ��[j][k]Ϊԭ�㣬б���£���len���ַ����string,��word�Ƚϣ�һ����������
			for (int i = 0; i < len; i++) {
				newStr += String.valueOf(a[j + 1][k - i]);
			}
			if (word.equals(newStr))
				System.out.println(word + "λ�ã�(" + j + "," + k + ")��("
						+ (j + len - 1) + "," + (k - len + 1) + ")");
			break;
		default:
			break;
		}
	}
}

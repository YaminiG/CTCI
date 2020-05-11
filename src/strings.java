import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class strings {

	
	public static void main(String[]args) {
		String string = "Taco cat";
		//System.out.println(isRotation("waterbottle", "erbottlewat"));
		System.out.println(words(969));

	}
	
	public static String words(int number) {
		StringBuilder builder = new StringBuilder();
		ArrayList<String>list = new ArrayList<>();
		int pos = 1;
		int num = number;
		while(num!=0) {
			int num1 = num%10;
			String ans = convert(num1 * pos);
			list.add(ans);
			num = num/10;
			pos = pos * 10;
		}
		for(int i = list.size()-1;i>=0;i--) {
			builder.append(list.get(i));
		}
		
		return builder.toString();
	}
	
	public static String convert(int num) {
		//System.out.println(num);
		String ans1 = "";
		if(num<10) {
			ans1 = handleSingles(num);
		}
		else if(num>=10 && num<=90) {
			switch(num) {
			case 10:
				ans1 = "ten";
				break;
			case 20:
				ans1 = "twenty";
				break;
			case 30:
				ans1 = "thirty";
				break;
			case 40:
				ans1 = "forty";
				break;
			case 50:
				ans1 = "fifty";
				break;
			case 60:
				ans1 = "sixty";
				break;
			case 70:
				ans1 = "seventy";
				break;
			case 80:
				ans1 = "eighty";
				break;
			case 90:
				ans1 = "ninety";
				break;					
			}
		}
		else if(num>=100 && num<=900) {
			int temp = num/100;
			//System.out.println(temp);
			ans1 = handleSingles(temp);
			ans1 = ans1 + "hundred";
			
		}
		
		return ans1;
	}
	
	public static String handleSingles(int num) {
		switch(num) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";			
		
		}
		return "";
		
	}
	
	public static boolean isRotation(String s1, String s2) {
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
	}
	
	public static boolean isSubstring(String s1, String s2) {
		String larger = "";
		String smaller = "";
		
		if(s1.length()>s2.length()) {
			larger = s1;
			smaller = s2;
		}
		else {
			larger = s2;
			smaller = s1;
		}
		
		return larger.contains(smaller);
		
	}
	
	public static String compressed(String str) {
		str = str + " ";
		int index = 0; //keeps check on the reset value of count
		int count = 0;
		StringBuilder builder = new StringBuilder();
		
		char initial = str.charAt(0);
		for(int i = 0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c==initial) {
				count++;
			}
			else {
				if(count==1) {
					index++;
				}
				builder.append(initial);
				builder.append(count);
				count = 1;
				initial = c;
			}
		}
		
		if(index==str.length()-1) {
			return str;
		}
		
		return builder.toString();
		
	}
	
	public static boolean oneEditAway(String s1, String s2) {
		//removal- s2 has greater length than s1 or s1 has greater length than s2
		if(s1.length()!=s2.length()) {
			return handleRemovalInsertion(s1, s2);
		}
		else {
			return handleReplace(s1, s2);
		}
	
	}
	
	public static boolean handleRemovalInsertion(String s1, String s2) {
		String small = "";
		String large = "";
		
		if(s1.length()>s2.length()) {
			small = s2;
			large = s1;
		}
		else {
			small = s1;
			large = s2;
		}
		
		int p1 = 0;
		int p2 = 0;
		int edits = 0;
		if(large.length() - small.length()>1) {
			return false;
		}
		
		for(int i = 0;i<large.length();i++) {
			char a = large.charAt(p1);
			if(p2>small.length()-1) {
				p2 = p2 - 1;
			}
			char b = small.charAt(p2);
			
			if(a==b) {
				p1++;
				p2++;
			}
			else {
				p1++;
				edits++;
			}
		}
		
		if(edits>1) {
			return false;
		}
		
		return true;
		
	}
	
	public static boolean handleReplace(String s1, String s2) {
		int p1 = 0;
		int p2 = 0;
		int edits = 0;
		for(int i = 0;i<s1.length();i++) {
			Character a = s1.charAt(p1);
			Character b = s2.charAt(p2);
			if(a!=b) {
				edits++;
			}
			p1++;
			p2++;
		}
		
		if(edits>1) {
			return false;
		}
		
		return true;
		
	}
	
	public static boolean isPalindromePermutation(String string1) {
		string1 = string1.toLowerCase();
		StringBuilder builder = new StringBuilder();
		String[]array = string1.split(" ");
		for(int i = 0;i<array.length;i++) {
			builder.append(array[i]);
		}
		
		String string = builder.toString();
		
		HashSet<Character> set = new HashSet<>();
		for(int i = 0;i<string.length();i++) {
			Character s = string.charAt(i);
			if(!set.contains(s)) {
				set.add(s);
			}
			else {
				set.remove(s);
			}
		}
		
		if(set.size()==1 || set.size()==0) {
			return true;
		}
		return false;
		
	}
	
	public static boolean permutation(String s1,String s2) {
		// sort the strings and compare the sorted strings
		char[]char1 = s1.toCharArray();
		char[]char2 = s2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		
		String string1 = new String(char1);
		String string2 = new String(char2);
		
		System.out.println(string1 +  "  " + string2);
		
		return string1.equals(string2);
		
	}
	
	public static boolean isUnique1(String string) {
		HashSet<Character> set = new HashSet<>();
		
		for(int i = 0;i<string.length();i++) {
			Character s = string.charAt(i);
			if(set.contains(s)) {
				return false;
			}
			set.add(s);
		}
		return true;		
	}
	
	public static boolean isUnique2(String string) {
		boolean[]small = new boolean[26];
		boolean[]capital = new boolean[26];
		for(int i = 0;i<small.length;i++) {
			small[i] = false;
			capital[i] = false;
		}
		
		for(int i = 0;i<string.length();i++) {
			Character s = string.charAt(i);
			if(s.isUpperCase(s)) {
				int position = s - 'A';
				if(capital[position]) {
					return false;
				}
				capital[position] = true;
			}
			else {
				int position = string.charAt(i) - 'a';
				if(small[position]) {
					return false;
				}
				small[position] = true;
			}
			
		}
		
		return true;
	}
}

package practiseprogrammes;

public class OccurenceofWords {

	public static void main(String[] args) {
	
		String input = "Australia is Australia";
		
		input = input.toLowerCase();
		
		String [] words = input.split("\\s+");
		
		boolean [] visited = new boolean [words.length];	
		
		System.out.println("Duplicate words and there occurence :");
		
		for (int i = 0; i < words.length; i++)
		{
			if (visited[i])
				continue;
		
		int count = 1;
		
		for (int j = i + 1; j < words.length; j++)
		{
			if(words[i].equals(words[j]))
			{
				count++;
				visited[j] = true;
			}
		}
		if (count > 1)
		{
			System.out.println(words[i] +" - "+ count);
		}
	}
		
	}
}

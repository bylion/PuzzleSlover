
package wordpuzzle;
import java.util.*;


/**
 * CrosswordPuzzle.PuzzleSolver
 * Complete this program by filling out the findWords method.
 */

public class PuzzleSolver {

    public static String[] DICTIONARY = {"OX","CAT","TOY","AT","DOG","CATAPULT","T"};
    
    public static List<String> context = new ArrayList<String>();
    
    public static int findWords(char[][] puzzle)
    {
    	buildContext(puzzle);
    	return searchWord();
        
    }

    private static int searchWord() {
    	int count=0;
    	for (String word: DICTIONARY) {
			for (String statement: context) {
				if(statement.contains(word)){
					System.out.println(statement+" : "+word);
					count++;
				}
			}
		}
		return count;
	}

	private static void buildContext(char[][] puzzle) {
		int length = puzzle[0].length;
		int width = puzzle.length;
		
		for(Direction direction: Direction.values()){
			if(direction==Direction.horizontally){
				for(int i=0;i<width;i++ ){
					String string = new String(puzzle[i]);
					context.add(string);
				}
			}
			if(direction==Direction.vertically){
				for(int i=0;i<length;i++ ){
					StringBuilder sb = new StringBuilder();
					for(int j=0; j<width;j++ ){
						sb.append(puzzle[j][i]);  
					}
					context.add(sb.toString());
				}
			}
			if(direction==Direction.diagonally){ 			 
				for(int i=width-1;i>=0;i-- ){
					StringBuilder sb = new StringBuilder();
					for(int j=i, k=0; j<width && k<length; j++, k++){
						sb.append(puzzle[j][k]);
					}
					context.add(sb.toString());
				}
				for(int i=1;i<length;i++ ){					
					StringBuilder sb = new StringBuilder();
					for(int j=0, k=i; j<width && k<length; j++, k++){
						sb.append(puzzle[j][k]);
					}
					context.add(sb.toString());
				}		
			}
////////////////////////////
			if(direction==Direction.anti_horizontally){
				for(int i=0;i<width;i++ ){
					StringBuilder sb = new StringBuilder();
					sb.append(puzzle[i]);
					context.add(sb.reverse().toString());
				}
			}
			if(direction==Direction.anti_vertically){
				for(int i=0;i<length;i++ ){
					StringBuilder sb = new StringBuilder();
					for(int j=0; j<width;j++ ){
						sb.append(puzzle[j][i]);  
					}
					context.add(sb.reverse().toString());
				}
			}
			if(direction==Direction.diagonally){ 			 
				for(int i=width-1;i>=0;i-- ){
					StringBuilder sb = new StringBuilder();
					for(int j=i, k=0; j<width && k<length; j++, k++){
						sb.append(puzzle[j][k]);
					}
					context.add(sb.reverse().toString());
				}
				for(int i=1;i<length;i++ ){					
					StringBuilder sb = new StringBuilder();
					for(int j=0, k=i; j<width && k<length; j++, k++){
						sb.append(puzzle[j][k]);
					}
					context.add(sb.reverse().toString());
				}		
			}
		}
		
		for (String string :context) {
			System.out.println(string);
		}
	}

	static boolean isWord(String testWord)
    {
        if (Arrays.asList(DICTIONARY).contains(testWord))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
    	Position p = new Position();
    	p.x = 1;
    	p.y = 2;

    	System.out.println("Position");
        char[][] puzzle = new char[][] {   
            {'C','A','T'}, 
            {'X','Z','Z'}, 
            {'Y','O','T'} 
        };
        System.out.print("Output: " + findWords(puzzle));
    }
    
    
    
    public enum Direction {horizontally,anti_horizontally, vertically , anti_vertically, diagonally,anti_diagonally}
}
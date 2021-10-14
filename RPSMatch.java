/**
 * Class that allows the user to play a game of rock, paper, scissors agains the computer and 
 * notes the number of wins/ties each user has had
 *
 * @author Sahar Maleki
 * @version 10/12/21
 */
public class RPSMatch
{
    // instance variables
    private int x;
    private String computerPlay;
    private String humanPlay;
    private String result;
    private int humanWins;
    private int computerWins;
    private int ties;
    
    /** The constructor initializes values for the number of wins & ties made between the 
     * human and the computer and sets them to 0 at the beginning
     * 
     * @param humanWins Total number of wins made by the human
     * @param computerWins Total number of wins made by the computer
     * @param ties Total number of tie rounds
     * 
     */
    public RPSMatch()
    {
        // initialised instance variables
        humanWins = 0;
        computerWins = 0;
        ties = 0;
    }
    
    
    /** A boolean determining whether or not the game is cheating, and assigns different actions
     * if true vs. false (if true, cheating is implemented and if false, the regular game play is 
     * executed)
     * 
     * @param humanPlay the play made by the human (rock/paper/scissors)
     * @param computerPlay the play made by the computer (rock/paper/scissors)
     * @return computerPlay the play made by the computer (rock/paper/scissors) when false
     */
    public String getComputerPlay(boolean cheating)
    {
        if (cheating && humanPlay.equals("Paper") && Math.random()<0.3)
        {
            computerPlay = "Rock";
            return computerPlay;
        }
        else if (cheating && humanPlay.equals("Rock") && Math.random()<0.25)
        {
            computerPlay = "Paper";
            return computerPlay;
        }
        else if (cheating && humanPlay.equals ("Scissors") && Math.random()<0.10)
        {
            computerPlay = "Scissors";
            return computerPlay;
        }
        else
        {
            int rand = (int) (Math.random() * 3);
                if (rand == 0)
                {
                    computerPlay = "Rock";
                }
                else if (rand == 1)
                {
                    computerPlay = "Paper";
                }
                else
                {
                    computerPlay = "Scissors";
                }
            return computerPlay;
        }
    }
    
    /** stores the play made by the computer
     * 
     * @param computerPlay the play made by the computer (rock/paper/scissors)
     * @return computerPlay the play made by the computer (rock/paper/scissors) when false 
     * (the code is cheating) 
     */
    public String getComputerPlay()
    {
        return getComputerPlay(false);
    }
    
    /** stores the result of the game between the human and the computer
     * 
     * @param humanPlay The play made by the human (rock/paper/scissors)
     * @param computerPlay The play made by the computer (rock/paper/scissors)
     * @param humanWins The number of wins the human has 
     * @param computerWins The number of wins the computer has 
     * @param ties The number of ties between the human and the computer 
     * @return different statements depending on the circumstances of the game (i.e. a human 
     * win would return "Computer loses!")
     * 
     */
    public String getResult()
    {   
        if ((computerPlay.equals("Rock") && humanPlay.equals ("Paper")) || 
            (computerPlay.equals ("Scissors") && humanPlay.equals ("Rock")) || 
            (computerPlay.equals ("Paper") && humanPlay.equals ("Scissors")))
        {
            humanWins = humanWins + 1;
            return ("Computer loses!");
        }
        else if ((computerPlay.equals("Rock") && humanPlay.equals ("Scissors")) || 
            (computerPlay.equals ("Paper") && humanPlay.equals ("Rock")) || 
            (computerPlay.equals ("Scissors") && humanPlay.equals ("Paper")))
        {
            computerWins = computerWins + 1;
            return ("You lose!");
        }
       else
       {
           ties ++;
           return ("It's a tie!");
       }
    }
    
    /** stores the number of wins the human has achieved
     * 
     * @param humanWins The number of wins the human has 
     * @return humanWins The number of wins the human has 
     * 
     */
    public int getHumanWins()
    {
        return humanWins;
    }
    
    /** stores the number of wins the computer has achieved
     * 
     * @param computerWins The number of wins the computer has 
     * @return computerWins The number of wins the computer has 
     * 
     */
    public int getComputerWins()
    {
        return computerWins;
    }
    
    /** stores the number of ties between the human and the computer
     * 
     * @param ties The number of ties between the human and the computer
     * @return ties The number of ties between the human and the computer 
     * 
     */
    public int getTies()
    {
        return ties;
    }
    
    /** Updates the value of humanPlay to a new value when the user has played the game 
     * again/clicked rock/paper/scissors again
     * 
     * @param newPlay new play made by the human
     * @param humanPlay play made by the human (i.e. what button the human clicks: 
     * rock/paper/scissors)
     * 
     */
    public void setHumanPlay(String newPlay)
    {
        humanPlay = newPlay;
    }
}

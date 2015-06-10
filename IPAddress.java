import java.util.Random;

/**
 * Created by ayg447 on 6/9/2015.
 */
public class IPAddress extends Converter
{
    private Random addressGenerator = new Random();
    private int firstOctet;
    private int secondOctet;
    private int thirdOctet;
    private int fourthOctet;


    public IPAddress(int first, int second, int third, int fourth)
    {

        setFirstOctet(first);
        setSecondOctet(second);
        setThirdOctet(third);
        setFourthOctet(fourth);

    }

    public void setFirstOctet(int first)
    {
        firstOctet = first;
    }

    public void setSecondOctet(int second)
    {
        secondOctet = second;
    }

    public void setThirdOctet(int third)
    {
        thirdOctet = third;
    }

    public void setFourthOctet(int fourth)
    {
        fourthOctet = fourth;
    }

    public int getFirstOctet()
    {
        return firstOctet;
    }

    public int getSecondOctet()
    {
        return secondOctet;
    }

    public int getThirdOctet()
    {
        return thirdOctet;
    }

    public int getFourthOctet()
    {
        return fourthOctet;
    }
}

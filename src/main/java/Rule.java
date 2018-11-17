/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/16/2018
 */
public interface Rule  {


    boolean match(Rental rental);

    Record calculate(Rental rental,Record record);

}

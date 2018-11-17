import java.util.ArrayList;
import java.util.List;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/17/2018
 */
public class RuleEngine {

    List<Rule> rules;

    public RuleEngine() {
        rules = new ArrayList<>();
    }

    public Record rule(Rental rental , Record record) {
        return rules.stream()
                .filter(rule -> rule.match(rental))
                .map(rule -> rule.calculate(rental , record))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No Matching rule found"));
    }



    public RuleEngine registerRule(Rule  rule) {
        rules.add(rule);
        return this;
    }

}

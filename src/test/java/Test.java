import com.study.util.Calculator;
import com.study.util.CalculatorInterface;
import com.study.util.MyCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Calculator bean = context.getBean(Calculator.class);
        bean.add(1,1);
        System.out.println(bean);
        System.out.println(bean.getClass());
    }

    @org.junit.Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CalculatorInterface bean = context.getBean(CalculatorInterface.class);
        System.out.println(bean);
        System.out.println(bean.add(1,1));
        System.out.println(bean.add(1,1));
        System.out.println(bean.getClass());
    }
}

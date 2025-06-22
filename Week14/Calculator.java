package Week14;

public class Calculator implements ComplexNumberCalculator, RealNumberCalculator {
    public ComplexNumber add(ComplexNumber c1, ComplexNumber c2)
    {
        ComplexNumber ans = new ComplexNumber(add(c1.real, c2.real), add(c1.img, c2.img));
        return ans;
    }

    public ComplexNumber sub(ComplexNumber c1, ComplexNumber c2)
    {
        return new ComplexNumber(sub(c1.real, c2.real), sub(c1.img, c2.img));
    }

    public ComplexNumber mul(ComplexNumber c1, ComplexNumber c2)
    {
        return new ComplexNumber(mul(c1.real, c2.real), mul(c1.img, c2.img));
    }

    public ComplexNumber.RealNumber add(ComplexNumber.RealNumber c1, ComplexNumber.RealNumber c2)
    {
        int new_divisor = c1.divisor * c2.divisor;
        int new_dividend1 = c1.dividend* c2.divisor;
        int new_dividend2 = c2.dividend* c1.divisor;
        ComplexNumber.RealNumber ans = new ComplexNumber.RealNumber(new_dividend1+new_dividend2, new_divisor);
        return ans;
    }

    public ComplexNumber.RealNumber sub(ComplexNumber.RealNumber c1, ComplexNumber.RealNumber c2)
    {
        int new_divisor = c1.divisor * c2.divisor;
        int new_dividend1 = c1.dividend * c2.divisor;
        int new_dividend2 = c2.dividend * c1.divisor;
        ComplexNumber.RealNumber ans = new ComplexNumber.RealNumber(new_dividend1-new_dividend2, new_divisor);
        return ans;
    }

    public ComplexNumber.RealNumber mul(ComplexNumber.RealNumber c1, ComplexNumber.RealNumber c2)
    {
        ComplexNumber.RealNumber ans = new ComplexNumber.RealNumber(c1.dividend*c2.dividend, c2.divisor*c2.divisor);
        return ans;
    }

    public void printResult(ComplexNumber a)
    {
        System.out.println(a.toString());
    }
}

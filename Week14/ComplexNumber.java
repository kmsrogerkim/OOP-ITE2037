package Week14;

public class ComplexNumber {
    public static class RealNumber {
        protected int dividend;
        protected int divisor;

        RealNumber(int a, int b)
        {
            dividend = a;
            divisor = b;
        }

        public String toString()
        {
            return dividend + "/" + divisor;
        }
    }

    protected RealNumber real;
    protected RealNumber img;

    ComplexNumber(RealNumber r, RealNumber i)
    {
        real = r;
        img = i;
    }

    public String toString()
    {
        return "Real : " + real.toString() + ", Imaginary: " + img.toString();
    }
}

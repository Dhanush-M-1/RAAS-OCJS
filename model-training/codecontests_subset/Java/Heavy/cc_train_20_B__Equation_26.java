

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Problem20B {

    public static void main(String[] args) {
        Problem20B problem20b = new Problem20B();
        problem20b.inputParams.readInputParamsFromStream();
        problem20b.solve();
        problem20b.outputParams.writeOutputParamsToStream();
    }

    public long a, b, c;
    public long rootNum;
    public double ad, bd, cd, x1, x2;

    public class InputParams extends AbstractInputParams {
        @Override
        public void readInputParamsFromStream() {
            a = readInteger();
            b = readInteger();
            c = readInteger();
        }
    }

    public class OutputParams extends AbstractOutputParams {
        @Override
        public void writeOutputParamsToStream() {
            switch ((int) rootNum) {
                case -1:
                case 0:
                    writeInteger(rootNum);
                    break;

                case 1:
                    writeInteger(rootNum);
                    writeDouble(x1);
                    break;

                case 2:
                    writeInteger(rootNum);
                    writeDouble(x1);
                    writeDouble(x2);
                    break;
            }
        }
    }

    // Problem solution implementation
    public void solve() {

        ad = a;
        bd = b;
        cd = c;

        if (ad == 0 && bd == 0 && cd == 0) {
            rootNum = -1;
            return;
        }

        if (ad == 0 && bd == 0 && cd != 0) {
            rootNum = 0;
            return;
        }

        if (ad == 0) {
            rootNum = 1;
            x1 = -cd / bd;
            return;
        }

        double d = bd * bd - 4 * ad * cd;

        if (d < 0) {
            rootNum = 0;
            return;
        }

        if (d == 0) {
            rootNum = 1;
            x1 = -bd / (2 * ad);
            return;
        }

        if (d > 0) {
            rootNum = 2;
            double rootD = sqrt(d);

            List<Double> dList = new ArrayList<Double>();
            dList.add((-bd - rootD) / (2 * ad));
            dList.add((-bd + rootD) / (2 * ad));
            Collections.sort(dList);

            x1 = dList.get(0);
            x2 = dList.get(1);
            return;
        }

        throw (new IllegalArgumentException());
    }


    //Problem input/output classes

    abstract class AbstractInputParams {
        abstract public void readInputParamsFromStream();

        protected Scanner inputScanner = new Scanner(System.in);

        protected Long readInteger() {
            if (inputScanner.hasNextLong()) {
                return inputScanner.nextLong();
            } else {
                throw new IllegalArgumentException();
            }
        }

        protected List<String> readStringList(Long length) {
            List<String> stringList = new ArrayList<String>();
            for (int i = 0; i < length; i++) {
                String string = readString();
                stringList.add(string);
            }
            return stringList;
        }


        protected List<Long> readIntegerList(Long length) {
            List<Long> integerList = new ArrayList<Long>();
            for (int i = 0; i < length; i++) {
                Long integerValue = readInteger();
                integerList.add(integerValue);
            }
            return integerList;
        }


        protected String readString() {
            return inputScanner.next();
        }

    }

    abstract class AbstractOutputParams {
        abstract public void writeOutputParamsToStream();

        void writeInteger(Long i) {
            System.out.print(i);
            System.out.print(" ");
        }

        void writeString(String string) {
            System.out.print(string);
            System.out.print(" ");
        }

        void writeStringList(List<String> stringList) {
            for (String string : stringList) {
                writeString(string);
            }
        }

        void writeDouble(double f) {
            System.out.print(f);
            System.out.print(" ");
        }

    }

    InputParams inputParams = new InputParams();
    OutputParams outputParams = new OutputParams();
}


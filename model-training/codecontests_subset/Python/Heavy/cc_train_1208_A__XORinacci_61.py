class TestCase:

    def __init__(self, a, b, n):
        self.a = a
        self.b = b
        self.n = n

    def solve(self):
        if self.n % 3 == 0:
            return self.a
        if self.n % 3 == 1:
            return self.b
        return self.a ^ self.b

class BundleOfTestsCases:

    def __init__(self, tests=None):
        self.tests = [] if not tests else tests

    def append(self, other):
        self.tests.append(other)

    def __iter__(self):
        for test in self.tests:
            yield test

    def __contains__(self, item):
        return item in self.tests


class Input:

    def __init__(self):
        self.NUMBER_OF_TESTS = int(input().strip())
        self.TESTS_CASES = BundleOfTestsCases()

        for i in range(self.NUMBER_OF_TESTS):
            line = input().strip().split(' ')
            line = list(map(int, line))
            t = TestCase(line[0], line[1], line[2])
            self.TESTS_CASES.append(t)


class Output:
    fibonaccis = []

    def print_output(self):
        for fib in self.fibonaccis:
            print(fib)

    def append(self, other):
        self.fibonaccis.append(other)


def main():

    input_values = Input()
    output_values = Output()

    for test in input_values.TESTS_CASES:
        output = test.solve()
        output_values.append(output)

    output_values.print_output()


main()


import sys


class Test:
    def __init__(self, test_input: str):
        test_input_list = test_input.split()
        self.a = int(test_input_list[0])
        self.b = int(test_input_list[1])
        self.c = int(test_input_list[2])

    @property
    def can_do_first(self) -> bool:
        if self.a > 0 and self.b > 1:
            return True
        else:
            return False

    @property
    def can_do_second(self) -> bool:
        if self.b > 0 and self.c > 1:
            return True
        else:
            return False

    def do_first(self):
        self.a = self.a - 1
        self.b = self.b - 2

    def do_second(self):
        self.b = self.b - 1
        self.c = self.c - 2


def test_solution(test_input: str):
    test = Test(test_input)
    answer = 0
    # if test.b > test.c:
    #     while test.can_do_first:
    #         test.do_first()
    #         answer += 3
    #     while test.can_do_second:
    #         test.do_second()
    #         answer += 3
    # else:
    while test.can_do_second:
        test.do_second()
        answer += 3
    while test.can_do_first:
        test.do_first()
        answer += 3

    return answer


if __name__ == "__main__":
    n = int(sys.stdin.readline())
    answers = []
    for i in range(n):
        test_input = sys.stdin.readline()
        answer = test_solution(test_input)
        answers.append(answer)

    for answer in answers:
        sys.stdout.write(str(answer) + "\n")

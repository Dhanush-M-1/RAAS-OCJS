# AC
import sys
import random


class Main:
    def __init__(self):
        self.buff = None
        self.index = 0

    def next(self):
        if self.buff is None or self.index == len(self.buff):
            self.buff = sys.stdin.readline().split()
            self.index = 0
        val = self.buff[self.index]
        self.index += 1
        return val

    def next_int(self):
        return int(self.next())

    def solve(self):
        n = self.next_int()
        x = [self.next_int() for _ in range(0, n)]
        odd = sorted(filter(lambda x: x % 2 == 1, x))
        even = sorted(filter(lambda x: x % 2 == 0, x))
        if len(odd) > len(even) + 1:
            print(sum(odd[:len(odd) - len(even) - 1]))
        elif len(even) > len(odd) + 1:
            print(sum(even[:len(even) - len(odd) - 1]))
        else:
            print(0)


if __name__ == '__main__':
    Main().solve()

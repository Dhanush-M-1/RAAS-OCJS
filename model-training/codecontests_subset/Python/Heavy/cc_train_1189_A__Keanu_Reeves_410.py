# AC
import sys
sys.setrecursionlimit(1000000)


class Main:
    def __init__(self):
        self.buff = None
        self.index = 0

    def next(self):
        if self.buff is None or self.index == len(self.buff):
            self.buff = self.next_line()
            self.index = 0
        val = self.buff[self.index]
        self.index += 1
        return val

    def next_line(self):
        return sys.stdin.readline().split()

    def next_ints(self):
        return [int(x) for x in sys.stdin.readline().split()]

    def next_int(self):
        return int(self.next())

    def solve(self):
        n = self.next_int()
        s = self.next()
        if s.count('0') * 2 != len(s):
            print(1)
            print(s)
        else:
            print(2)
            print(s[:1], s[1:])


if __name__ == '__main__':
    Main().solve()

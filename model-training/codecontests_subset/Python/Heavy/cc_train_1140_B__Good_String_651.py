# AC
import sys


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

    def cal(self, s):
        if len(s) == 1:
            return s[0]
        if s[0] == 0:
            return self.cal(s[1:])
        v = 1
        for c in s:
            v *= c
        return v

    def solve(self):
        n = self.next_int()
        for _ in range(0, n):
            lx = self.next_int()
            s = self.next()
            ll = 0
            rr = 0
            while ll < lx and s[ll] != '>':
                ll += 1
            while rr < lx and s[-rr - 1] != '<':
                rr += 1
            print(min(ll, rr))


if __name__ == '__main__':
    Main().solve()

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


    def solve(self):
        n = self.next_int()
        for i in range(0, n):
            l = self.next_int()
            r = self.next_int()
            d = self.next_int()
            if d < l:
                print(d)
            else:
                print(r // d * d + d)


if __name__ == '__main__':
    Main().solve()

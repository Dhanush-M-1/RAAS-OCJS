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
        x = self.next_int()
        s = self.next()
        for i in range(1, x):
            if s[i] < s[i - 1]:
                print('YES')
                print(i, i + 1)
                return
        print('NO')


if __name__ == '__main__':
    Main().solve()

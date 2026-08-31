import math


class Triple:
    def __init__(self, l, r, d):
        self.l = l
        self.r = r
        self.d = d

    def find_integer(self):
        if self.d < self.l or self.d > self.r:
            return self.d

        if self.r % self.d == 0:
            return self.d * (int(math.ceil(self.r / self.d)) + 1)

        return self.d * int(math.ceil(self.r / self.d))


if __name__ == '__main__':
    q = int(input())
    numbers = []

    for i in range(0, q):
        l, r, d = [int(s) for s in input().split(' ')]
        numbers.append(Triple(l, r, d))

    for triple in numbers:
        print(triple.find_integer())

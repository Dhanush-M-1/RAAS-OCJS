from sys import stdin, gettrace

if gettrace():
    inputi = input
else:
    def input():
        return next(stdin)[:-1]


    def inputi():
        return stdin.buffer.readline()


def solve():
    n = int(inputi())
    aa = [int(a) for a in inputi().split()]
    if aa[0] + aa[1] <= aa[-1]:
        print(1, 2, n)
    else:
        print(-1)


def main():
    t = int(inputi())
    for _ in range(t):
        solve()


if __name__ == "__main__":
    main()

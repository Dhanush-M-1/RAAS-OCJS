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
    c3 = 0
    i = 3
    while i <= n and n%i == 0:
        i *= 3
        c3 += 1
    c2 = 0
    j = 2
    while j <= n and n%j == 0:
        j *= 2
        c2 += 1
    if i*j//6 != n or c2 > c3:
        print(-1)
    else:
        print(c3*2 - c2)




def main():
    t = int(inputi())
    for _ in range(t):
        solve()


if __name__ == "__main__":
    main()
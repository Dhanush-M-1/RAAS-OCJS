from sys import stdin, gettrace

if gettrace():
    def inputi():
        return input()
else:
    def input():
        return next(stdin)[:-1]


    def inputi():
        return stdin.buffer.readline()


def solve():
    n = int(input())
    rr = [1] + [int(a) for a in input().split()]
    cc = [1] + [int(a) for a in input().split()]
    rc = sorted(zip(rr, cc))
    res = 0
    for (r1,c1),(r2,c2) in zip(rc, rc[1:]):
        if (r1 + c1)%2 == 0 and c2 - r2 == c1 - r1:
            res += r2 - r1
        else:
            if (r1+c1)%2 == 0:
                r1 += 1
            res += (r2-c2 - (r1 -c1) + 1)//2
    print(res)




def main():
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == "__main__":
    main()

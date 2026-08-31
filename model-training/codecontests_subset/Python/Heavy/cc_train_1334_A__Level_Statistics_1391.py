from sys import stdin, gettrace

if not gettrace():
    def input():
        return next(stdin)[:-1]


# def input():
#    return stdin.buffer.readline()

def main():
    def solve():

        n = int(input())
        pl = 0
        cl = 0
        res = 'YES'
        for _ in range(n):
            p,c = map(int, input().split())
            if p < pl or c < cl or c - cl > p - pl:
                res = 'NO'
            pl = p
            cl = c
        print(res)

    q = int(input())
    for _ in range(q):
        solve()


if __name__ == "__main__":
    main()
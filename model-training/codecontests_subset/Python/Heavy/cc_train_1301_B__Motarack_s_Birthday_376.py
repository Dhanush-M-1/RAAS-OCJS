from sys import stdin, gettrace

if not gettrace():
    def input():
        return next(stdin)[:-1]


def main():
    def solve():

        n = int(input())
        aa = [int(a) for a in input().split()]
        mn = int(1E9)
        mx = -1
        mb = 0
        last = aa[0]
        lastgood = aa[0]
        for a in aa[1:]:
            if lastgood == -1 and a == -1:
                continue
            if a == -1 and last != -1:
                mx = max(mx, last)
                mn = min(mn, last)
            elif last == -1 and a != -1:
                mx = max(mx, a)
                mn = min(mn, a)
            elif a != -1:
                mb = max(mb, abs(a-lastgood))
            if a != -1:
                lastgood = a
            last = a
        if lastgood == -1:
            print(0, 0)
            return
        k = (mn + mx)//2
        m = max(mb, mx-k)
        print(m, k)


    q = int(input())
    for _ in range(q):
        solve()


if __name__ == "__main__":
    main()
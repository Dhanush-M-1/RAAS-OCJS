from sys import stdin, gettrace

if not gettrace():
    def input():
        return next(stdin)[:-1]


def main():
    def solve():

        n,m = map(int, input().split())
        ss = [ord(s) - ord('a') for s in input()]
        pp = [int(a) for a in input().split()]
        pp.sort()
        ppi = iter(pp)
        counts = [0]*26
        p = next(ppi)
        mult = m+1
        for i in range(n):
            while i==p:
                mult -= 1
                if mult > 1:
                    p = next(ppi)
                else:
                    p = -1
            counts[ss[i]] += mult
        print(' '.join(map(str, counts)))



    q = int(input())
    for _ in range(q):
        solve()


if __name__ == "__main__":
    main()
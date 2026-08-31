# coding: utf-8
# Your code here!
def solve():
    n, l, r = map(int, input().split())

    def where(x):
        if x == n*(n-1) + 1:
            return 1
        else:
            l = 0
            r = n + 1
            while r - l > 1:
                m = (l + r)//2
                if (2*n-1-m)*(m) < x:
                    l = m
                else:
                    r = m
                    
            v = x - (2*n-1-l)*(l)
            if v % 2 != 0:
                return r
            else:
                return r + v//2

    res = [where(p) for p in range(l, r+1)]
    print(*res)
    return


def main():
    t = int(input())
    for i in range(t):
        solve()


if __name__ == "__main__":
    main()


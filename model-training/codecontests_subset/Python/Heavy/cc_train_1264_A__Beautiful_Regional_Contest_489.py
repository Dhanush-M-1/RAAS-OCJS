
from collections import Counter

def solve(n,ar):
    a = Counter(ar)
    a = list(dict(sorted(a.items())).values())
    a.reverse()

    ar = sorted(set(ar))
    ar.reverse()

    g = a[0]

    #find s
    i = 1
    s = 0
    while s <= g and i < len(ar):
        s += a[i]
        i += 1

    if g < s:
        b = 0
        while b <= g and i < len(ar):
            b += a[i]
            i += 1
        while i < len(ar) and g+s+b+a[i] <= n//2:
            b += a[i]
            i += 1
        if g < b and g+s+b <= n//2:
            print(g, s, b)
            return

    print("0 0 0")

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        ar = list(map(int,input().split()))

        solve(n,ar)
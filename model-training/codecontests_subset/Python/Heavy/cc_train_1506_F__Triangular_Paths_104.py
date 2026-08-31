import sys
from collections import Counter
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    ans = 0
    MUL = 1000000007
    r = list(map(int, input().split()))
    r.append(1)
    c = list(map(int, input().split()))
    c.append(1)
    a = [r[i]*MUL + c[i] for i in range(n+1)]
    a.sort()
    for i in range(1, n+1):
        from_r = a[i-1]//MUL
        from_c = a[i-1]%MUL
        to_r = a[i]//MUL
        to_c = a[i]%MUL

        end_c = 0
        if (from_r + from_c)%2 == 0:
            end_c = from_c + (to_r - from_r - 1)
        else:
            end_c = from_c + (to_r - from_r)
        if end_c == to_c:
            continue
        if end_c < to_c:
            ans += to_r - from_r
            continue
        dif = end_c - to_c
        ans += dif//2
        if dif%2 == 1:
            ans += 1
    print(ans)
#   Author: yumtam
#   Created at: 2021-04-29 12:58

MOD = 10**9 + 7

a = []
c = [1] + [0]*9

for _ in range(2 * 10**5 + 50):
    a.append(sum(c))
    d = [0] * 10
    for i in range(9):
        d[i+1] = c[i]
    d[0] = (d[0] + c[9]) % MOD
    d[1] = (d[1] + c[9]) % MOD
    c = d

import sys, os, io
input = lambda: sys.stdin.readline().rstrip('\r\n')
stdout = io.BytesIO()
sys.stdout.write = lambda s: stdout.write(s.encode("ascii"))

for _ in range(int(input())):
    n, k = [int(t) for t in input().split()]

    s = str(n)
    c = [s.count(str(i)) for i in range(10)]

    ans = 0
    for i in range(10):
        ans = (ans + c[i] * a[i+k]) % MOD

    print(ans)

os.write(1, stdout.getvalue())

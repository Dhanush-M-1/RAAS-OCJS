
from sys import stdin
mod = 998244353
def inv(a, b):
    return a % mod  * pow(b, mod - 2, mod) % mod

n, k = map(int, input().split())

C = [0] * (n+1)
C[k - 1] = 1
for i in range(k, n+1):
    C[i] = inv(C[i-1] * i % mod, i-k+1)


l, r = [], []

for i in range(n):
    a, b = map(int, stdin.readline().split())
    #a, b = map(int, input().split())
    l.append(a)
    r.append(b)

l.sort()
r.sort()

i, j = 0, 0
num, ans = 0, 0
while i < n and j < n:
    if l[i] <= r[j]:
        ans += C[num]
        num += 1
        i += 1
    else :
        num -= 1
        j += 1

print(ans%mod)
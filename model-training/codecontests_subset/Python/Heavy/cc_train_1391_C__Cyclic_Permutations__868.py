from sys import stdin, exit
from bisect import bisect_left as bl, bisect_right as br

input = lambda: stdin.readline()[:-1]
intput = lambda: int(input())
sinput = lambda: input().split()
intsput = lambda: map(int, sinput())

def dprint(*args, **kwargs):
    if debugging:
        print(*args, **kwargs)


debugging = 1
# Code
mod = 10 ** 9 + 7
n = intput()

factorials = [1, 1]
for i in range(2, n):
    factorials.append((factorials[-1] * i) % mod)

ans = 0
for sub in range(n - 2, 0, -1):
    ans += (factorials[n - sub] * (n - sub - 1)) % mod
    ans %= mod
    if sub != 1:
        ans *= 2
        ans %= mod

print(ans)


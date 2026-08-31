n = int(input())
MOD = 10**9+7
ans = 1
for i in range(1, n+1):
    ans = (ans*i) % MOD
for i in range(n-1):
    ans = (ans+MOD-pow(2, i, MOD)) % MOD
ans = (ans+MOD-1) % MOD
print(ans)
'''
import itertools
from collections import deque
for p in itertools.permutations([1, 2, 3, 4, 5, 6]):
    n = len(p)
    a = []
    for i in range(n):
        for j in range(i-1, -1, -1):
            if p[j] > p[i]:
                a.append((j, i))
                break
    for i in range(n):
        for j in range(i+1, n):
            if p[j] > p[i]:
                a.append((j, i))
                break

    if len(a) < n:
        print(*p)
'''

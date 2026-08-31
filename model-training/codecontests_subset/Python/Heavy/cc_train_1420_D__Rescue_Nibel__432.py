import sys
import array

input = lambda: sys.stdin.readline()

def getint():
    return int(input())

def getints():
    return map(int, input().split())

def getlistints():
    return list(map(int, input().split()))



fac = array.array('i', [0 for _ in range(300003)])
inv = array.array('i', [1 for _ in range(300003)])
mod = 998244353

def init():
    fac[0] = 1
    for i in range(2, 300003):
        inv[i] = inv[mod%i] * (mod - mod // i) % mod # i^-1
    for i in range(1, 300003):
        fac[i] = fac[i-1] * i % mod
        inv[i] = inv[i-1] * inv[i] % mod
    return

def comb(n, m):
    if m < 0 or n < 0 or n < m:
        return 0
    return fac[n] * inv[m] * inv[n-m] % mod

init()
#print(fac[:100])
#print(inv[:100])
#print(comb(4,2))

n, k = getints()
start = array.array('i', [0 for _ in range(n)])
end = array.array('i', [0 for _ in range(n)])
for i in range(n):
    start[i], end[i] = getints()

start = sorted(start)
end = sorted(end)

res = 0
j, cnt = 0, 0
for i in range(n):
    while end[j] < start[i]:
        j += 1
        cnt -= 1
    res += comb(cnt, k - 1)
    cnt += 1

print(res % mod)




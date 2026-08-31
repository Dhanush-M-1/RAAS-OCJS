from sys import stdin
import heapq
input = stdin.readline
MOD = 998244353
def solve():
    n, k = map(int, input().split())
    p = [tuple(map(int, inp.split())) for inp in stdin.read().splitlines()]
    p.sort(key = lambda x: x[0])
    fac = [1,1] + [0] * n
    inv = [1,1] + [0] * n
    for i in range(2,n+1):
        fac[i] = (fac[i-1]*i)%MOD
    inv[n] = pow(fac[n],MOD-2,MOD)
    for i in range(n-1,1,-1):
        inv[i] = inv[i+1]*(i+1)%MOD
    def c(a,b):
        return (fac[b]*inv[a]*inv[b-a]) % MOD
    h = []
    res = 0
    for i,v in enumerate(p):
        while h and h[0] < v[0]:
            heapq.heappop(h)
        if len(h) >= k - 1:
            res += c(k-1,len(h))
            res %= MOD
        heapq.heappush(h,v[1])

    print(res)
if __name__ == '__main__':
    solve()

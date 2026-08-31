import sys
import io, os
input = sys.stdin.buffer.readline
#input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

mod = 998244353

from itertools import accumulate

def main():

    n,k = map(int,input().split())
    LR = []
    for i in range(n):
        l,r = map(int, input().split())
        l, r = l-1, r-1
        LR.append(2*l)
        LR.append(2*r+1)

    N = 3*10**5+50
    fac = [1]*(N+1)
    finv = [1]*(N+1)
    for i in range(N):
        fac[i+1] = fac[i] * (i+1) % mod
    finv[-1] = pow(fac[-1], mod-2, mod)
    for i in reversed(range(N)):
        finv[i] = finv[i+1] * (i+1) % mod

    def cmb1(n, r, mod):
        if r <0 or r > n:
            return 0
        r = min(r, n-r)
        return fac[n] * finv[r] * finv[n-r] % mod

    LR.sort()
    ans = 0
    cnt = 0
    for x in LR:
        if x%2 == 1:
            cnt -= 1
        else:
            cnt += 1
            if cnt >= k:
                ans += cmb1(cnt-1, k-1, mod)
    ans %= mod
    print(ans)

if __name__ == '__main__':
    main()

mod = 10**9+7

N = 10**6

import sys
input = sys.stdin.buffer.readline

def power(a, n, mod):
    bi=str(format(n,"b"))
    res=1
    for i in range(len(bi)):
        res=(res*res) %mod
        if bi[i]=="1":
            res=(res*a) %mod
    return res

def main():
    n = int(input())

    #N = 1000
    fac = [1]*(N+1)
    #finv = [1]*(N+1)
    for i in range(N):
        fac[i+1] = fac[i] * (i+1) % mod
    #finv[-1] = pow(fac[-1], mod-2, mod)
    #for i in reversed(range(N)):
        #finv[i] = finv[i+1] * (i+1) % mod

    P = [1]*(N+1)
    #finv = [1]*(N+1)
    for i in range(N):
        P[i+1] = P[i] * 2 % mod
    #print(P[0:10])

    ans = 0
    for i in range(1, n):
        temp = (n-2-(i-1))*fac[n-i]*P[i-1]
        #temp *= power(2, i-1, mod)
        ans += temp
        #ans %= mod
    ans %= mod
    print(ans)

if __name__ == '__main__':
    main()

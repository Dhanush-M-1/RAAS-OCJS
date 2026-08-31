def main():
    import sys
    input = sys.stdin.readline
    MOD = 10 ** 9 + 7
    n = int(input())
    ans = 0
    fact = [1] * (n+1)
    invfact = [1] * (n+1)
    for i in range(1, n+1):
        fact[i] = (fact[i-1] * i) % MOD
    invfact[-1] = pow(fact[-1], MOD-2, MOD)
    for i in range(n, 0, -1):
        invfact[i-1] = (invfact[i] * i) % MOD

    def nCr(n, r):
        if r == 0 or r == n:
            return 1
        r = min(r, n-r)
        return (((fact[n] * invfact[r]) % MOD) * invfact[n-r]) % MOD

    ans = fact[n]
    
    for i in range(n):
        ans = (ans - nCr(n-1, i)) % MOD
    
    print(ans)

if __name__ == '__main__':
    main()
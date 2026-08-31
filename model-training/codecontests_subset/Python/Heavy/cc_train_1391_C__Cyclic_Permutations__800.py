def main():
    n = int(input())

    ans = 1

    def cmb(n, r, mod):
        if (r < 0 or r > n):
            return 0
        r = min(r, n-r)
        return g1[n] * g2[r] * g2[n-r] % mod

    mod = 10**9+7  # 出力の制限
    N = n
    # g1 = [1, 1]  # 元テーブル
    # g2 = [1, 1]  # 逆元テーブル
    # inverse = [0, 1]  # 逆元テーブル計算用テーブル

    # for i in range(2, N + 1):
    #     g1.append((g1[-1] * i) % mod)
    #     inverse.append((-inverse[mod % i] * (mod//i)) % mod)
    #     g2.append((g2[-1] * inverse[-1]) % mod)

    inv_t = [0]+[1]
    for i in range(2, N):
        inv_t += [inv_t[mod % i] * (mod - int(mod / i)) % mod]

    for i in range(1, n+1):
        ans *= i
        ans %= mod
    ans -= 1
    tmp = 1
    for i in range(1, n):
        tmp *= n-i
        tmp *= inv_t[i]
        tmp %= mod
        ans -= tmp
    print(ans % mod)


main()

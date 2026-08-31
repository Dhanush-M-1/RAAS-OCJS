import io, sys
input = lambda f=io.StringIO(sys.stdin.buffer.read().decode()).readline: f().rstrip()
 
ii = lambda: int(input())
mi = lambda: map(int, input().split())
li = lambda: list(mi())

MOD = 998244353

pow10 = [10 ** i % MOD for i in range(21)]

n = ii()
a = li()
rec = [0] * 11
cnt = [0] * 11
for x in a:
    i = -1
    while x:
        i += 1
        rec[i] += pow10[2 * i + 1]
        x //= 10
    cnt[i] += 1
    j = 2 * i + 1
    while i < 10:
        i += 1
        j += 1
        rec[i] += pow10[j]

suf = [0] * 12
for i in range(10, -1, -1):
    suf[i] = suf[i + 1] + cnt[i]

ans = 0
for x in a:
    i = -1
    while x:
        i += 1
        d = x % 10
        ans += rec[i] * d
        ans += d * pow10[2 * i] * suf[i] % MOD
        x //= 10
        ans += x * pow10[2 * i + 2] * cnt[i] % MOD
    ans %= MOD
    
print(ans)
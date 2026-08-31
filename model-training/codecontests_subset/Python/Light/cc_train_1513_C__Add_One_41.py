import sys
input = sys.stdin.readline

t = int(input())
mod = pow(10, 9) + 7
cnt = [0 for _ in range(200020)]
cnt0 = [0] * 10
cnt0[0] = 1
s = 1
for k in range(200020):
    x = cnt0[(9 - k) % 10]
    cnt0[(10 - k) % 10] += x
    cnt0[(10 - k) % 10] %= mod
    s += x
    s %= mod
    cnt[k] = s
for _ in range(t):
    n, m = map(int, input().split())
    ans = 0
    for i in str(n):
        ans += cnt[m + int(i) - 1]
    ans %= mod
    print(ans)
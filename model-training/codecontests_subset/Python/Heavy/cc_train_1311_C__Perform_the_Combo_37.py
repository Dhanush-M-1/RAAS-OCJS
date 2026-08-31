# import sys
# sys.stdin = open('test.txt', 'r')

for _ in range(int(input())):
    n, m = map(int, input().split())
    s = input()
    p = list(map(int, input().split()))
    chars = 'abcdefghijklmnopqrstuvwxyz'
    ans = {}
    for c in chars:
        ans[c] = 0
    dp = [ans.copy()]
    for i in range(n):
        new = dp[-1].copy()
        new[s[i]] += 1
        dp.append(new)
    for i in p:
        for c, v in dp[i].items():
            ans[c] += v
    for c, v in dp[-1].items():
        ans[c] += v
    print(" ".join(map(str, ans.values())))

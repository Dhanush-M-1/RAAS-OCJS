import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    s = input()
    p = [int(i) - 1 for i in input().split()] + [n-1]
    cnt = [[0] * 26 for i in range(n)]
    for i in range(n):
        if i > 0:
            for j in range(26):
                cnt[i][j] = cnt[i-1][j]
        cur = ord(s[i]) - ord('a')
        cnt[i][cur] += 1
    ans = [0] * 26
    for i in p:
        for j in range(26):
            ans[j] += cnt[i][j]
    print(*ans)

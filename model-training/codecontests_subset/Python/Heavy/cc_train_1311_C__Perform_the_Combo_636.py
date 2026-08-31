for test in range(int(input())):
    n, m = map(int, input().split())
    s = input()
    p = list(map(int, input().split()))
    cnt = [[0 for i in range(26)] for j in range(n)]
    res = [0] * 26
    for i in range(n):
        cnt[i][ord(s[i]) - ord('a')] += 1
    for i in range(1,n):
        for c in range(26):
            cnt[i][c] += cnt[i - 1][c]
    for i in range(m):
        for c in range(26):
            res[c] += cnt[p[i] - 1][c]
    for c in range(26):
        res[c] += cnt[-1][c]
    print(*res)

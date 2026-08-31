t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    s = input()
    p = list(map(int, input().split()))
    d = dict()
    k = ord(s[0]) - ord('a')
    q = [0 for i in range(26)]
    q[k] += 1
    d[0] = q
    for i in range(1,n):
        k = ord(s[i]) - ord('a')
        add = [j for j in d[i-1]]
        add[k] += 1
        d[i] = add
    ans = [0 for _ in range(26)]
    for i in range(m):
        for j in range(26):
            ans[j] += d[p[i] - 1][j]
    for j in range(26):
        ans[j] += d[n - 1][j]
    for i in range(26):
        print("{} ".format(ans[i]), end="")
    print()
    
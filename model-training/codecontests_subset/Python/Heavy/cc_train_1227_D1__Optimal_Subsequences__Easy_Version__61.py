n = int(input())
a = list(map(int, input().split()))
a1 = sorted(a, key=lambda x: -x)
m = int(input())
for i in range(m):
    k, p = list(map(int, input().split()))
    c = {}
    c1 = {}
    s = []
    for j in range(n+1):
        s.append({})
    pos = {}
    for j in range(n):
        c[a1[j]] = 0
        c1[a1[j]] = 0
        s[0][a[j]] = 0
        pos[a1[j]] = []
    for j in range(n):
        s[0][a[j]] += 1
    for j in range(n):
        for t in range(n):
            s[j+1][a[t]] = s[j][a[t]]
        s[j+1][a[j]] -= 1
    b = []
    for j in range(k):
        c[a1[j]]+=1
    for j in range(k, n):
        c1[a1[j]]+=1
    ns = []
    us = [0]*n
    ans = []
    for j in range(n-1, -1, -1):
        if c1[a[j]] ^ 0:
            c1[a[j]] -= 1
        else:
            ans.append(a[j])
    for j in range(len(ans)//2):
        ans[j], ans[len(ans)-1-j] = ans[len(ans)-1-j], ans[j]
    print(ans[p-1])

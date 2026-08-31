t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    s = str(input())
    P = list(map(int, input().split()))
    P = [p-1 for p in P]

    C = [[0]*(n+1) for i in range(26)]
    for i in range(n):
        for j in range(26):
            C[j][i+1] = C[j][i]
        c = ord(s[i])-ord('a')
        C[c][i+1] += 1
    #print(C)

    ans = [0]*26
    for i in range(m):
        for c in range(26):
            ans[c] += C[c][P[i]+1]
    for i in range(n):
        c = ord(s[i])-ord('a')
        ans[c] += 1
    print(*ans)

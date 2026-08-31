t = int(input())
for i in range(t):
    n,m = map(int,input().split())
    ans = []
    a = input()
    l = list(map(int,input().split()))
    a = list(a)
    for j in range(26):
        ans.append(0)
    di = {}
    for j in range(26):
        ma = 0
        di[chr(j+97)] = []
        for k in range(n):
            if a[k] == chr(97+j):
                ma+=1
            di[chr(j+97)].append(ma)
    for j in range(m):
        for k in range(26):
            ans[k]+=di[chr(k+97)][l[j]-1]
    for j in range(26):
        if j<25:
            print(ans[j]+di[chr(j+97)][n-1],end=' ')
        else:
            print(ans[j]+di[chr(j+97)][n-1])
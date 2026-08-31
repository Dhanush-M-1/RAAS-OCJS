t=int(input())
for _ in range(t):
    n,m=map(int,input().split())
    s=input()
    p=list(map(int,input().split()))
    t=[[0 for i in range(26)] for j in range(n)]
    for i in range(n):
        if i>0:
            for j in range(26):
                t[i][j]=t[i-1][j]
        t[i][ord(s[i])-ord('a')] += 1
    # print(t)
    ans=[0 for i in range(26)]
    for i in range(m):
        for j in range(26):
            ans[j]=ans[j]+t[p[i]-1][j]
    for i in range(26):
        ans[i]=ans[i]+t[n-1][i]
    print(" ".join(map(str,ans)))
t = int(input())
while t:
    t-=1
    n,m = map(int,input().split())
    s = input().strip()
    p = list(map(int,input().split()))
    pref = [[0]*26 for _ in range(n)]
    pref[0][ord(s[0])-ord('a')] = 1
    for i in range(1,n):
        pref[i][ord(s[i])-ord('a')]+=1
        for j in range(26):
            pref[i][j]+=pref[i-1][j]
    # print(pref)
    ans = [0]*26
    for i in range(m):
        for j in range(26):
            ans[j]+=pref[p[i]-1][j]
    for j in range(26):
        ans[j]+=pref[n-1][j]
    print(' '.join(map(str,ans)))
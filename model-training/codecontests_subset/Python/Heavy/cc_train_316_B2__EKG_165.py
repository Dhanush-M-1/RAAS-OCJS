def put(): return map(int, input().split())

n,x = put()
a = list(put())

parent = list(range(n+1))
for i in range(n):
    if a[i]!=0:
        parent[a[i]] = i+1

cnt = []
z = 0
#print(parent)
for i in range(n):
    if a[i]==0:
        j = i+1
        c = 1
        found = False
        if j==x:
            z=c
            found = True
        while j != parent[j]:
            j = parent[j]
            c+=1
            if j==x:
                z=c
                found = True
        if not found:
            cnt.append(c)

#print(cnt,z)
n,m = len(cnt)+1, sum(cnt)+1
dp = [[0]*(m+1) for i in range(n+1)]
dp[0][0]=1
s = set()
s.add(0)
for i in range(1,n):
    for j in range(m):
        if  j==0 or dp[i-1][j]==1 or (j-cnt[i-1]>=0 and dp[i-1][j-cnt[i-1]]==1) :
            dp[i][j] = 1
            s.add(j)
l = []
for i in s:
    l.append(i+z)

l.sort()
print(*l)

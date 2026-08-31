import sys
input=sys.stdin.readline
n=int(input())

s=[]
for _ in range(n):
    a,b=map(int,input().split())
    s.append((a,b))

s.sort()
ans=min(2,n)
limit=s[0][0]

for i in range(1,n-1):

    if s[i][0]-s[i][1]<=limit :
        if s[i][0]+s[i][1]>=s[i+1][0] :
            limit=s[i][0]
            continue
        ans+=1
        limit=s[i][0]+s[i][1]
        continue
    ans+=1
    limit=s[i][0]

print(ans)


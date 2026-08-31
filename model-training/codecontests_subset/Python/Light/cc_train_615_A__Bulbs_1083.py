n,m=map(int,input().split())
d={}
for i in range(n):
    s=list(map(int,input().split()))
    for i in range(1,len(s)):
        if(s[i] not in d):
            d[s[i]]=1
if(len(d)==m):
    print('YES')
else:
    print('NO')

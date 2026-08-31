import sys
input=sys.stdin.buffer.readline
from collections import defaultdict
n,m=map(int,input().split())
arr=list(map(int,input().split()))
d=defaultdict(set)
for i in range(m):
    a,b=map(int,input().split())
    d[a].add(b)
curr=set()
ans=0
for i in range(n-2,-1,-1):
    if arr[-1] in d[arr[i]]:
        if len(curr) >len(d[arr[i]]):
            curr.add(arr[i])
            continue
        flag=0
        for j in curr:
            if j not in d[arr[i]]:
                flag=1
                break
        if flag==1:
            curr.add(arr[i])
        else:
            ans+=1
    else:
        curr.add(arr[i])
print(ans)
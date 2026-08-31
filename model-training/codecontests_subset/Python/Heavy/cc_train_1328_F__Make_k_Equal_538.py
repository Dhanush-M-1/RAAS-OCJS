import io, os
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
import sys
n,k=list(map(int,input().split()))
arr=list(map(int,input().split()))
arr.sort()
a=arr[-1]
count=[0]*(a)
for i in range(n):
    count[arr[i]-1]+=1
if max(count)>=k:
    print(0)
else:
    matrix=[[] for i in range(n)]
    steps=[[] for i in range(a)]
    for i in range(n):
        temp=arr[i]
        s=0
        while temp>0:
            matrix[i].append(temp)
            steps[temp-1].append(s)
            if temp!=arr[i]:
                count[temp-1]+=1
            temp=temp//2
            s+=1
    lis=[]
    l=0
    for i in range(a):
        if count[i]>=k:
            lis.append(i)
            l+=1
    ans=sys.maxsize
    for i in range(l):
        steps[lis[i]].sort()
        ans=min(ans,sum(steps[lis[i]][:k]))
    print(ans)
        
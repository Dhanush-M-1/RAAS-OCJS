import math
for _ in range(int(input())):
    n = int(input())
    lis = list(map(int,input().split()))
    aa=[]
    ans=0
    for i in range(n):
        if lis[i]==-1:
            if i>0 and lis[i-1]!=-1:
                aa.append(lis[i-1])
            if i<n-1 and lis[i+1]!=-1:
                aa.append(lis[i+1])    
    if len(aa)==0:
        ans=0
    else:
        ans = (max(aa)+min(aa))//2
#    print(aa)
    li=[ans if x==-1 else x for x in lis]
    k=k1=0
    for i in range(n-1):
        k = max(k,abs(li[i]-li[i+1]))
    print(k,ans)    








from collections import deque
from sys import stdin,stdout
n,k=list(map(int,input().split()))
p=[]
al=0
bob=0
ali=[]
c=[]
bobi=[]
for i in range(n):
    t,a,b=list(map(int,stdin.readline().split()))
    p.append((t,a,b))
    if a==1:
        al+=1
    if b==1:
        bob+=1
    if a==1 and b==0:
        ali.append(t)
    if a==0 and b==1:
        bobi.append(t)
    if a==1 and b==1:
        c.append(t)
if al<k or bob<k:
    print(-1)
    exit()
ali.sort()
c.sort()
bobi.sort()

ali=deque(ali)
bobi=deque(bobi)
c=deque(c)
#printprint(ali)
ans=0
for i in range(k):
    if len(c)>0:
        if len(ali)>0 and len(bobi)>0:
            if ali[0]+bobi[0]<=c[0]:
                ans+=ali[0]+bobi[0]
                ali.popleft()
                bobi.popleft()
            else:
                ans+=c[0]
                c.popleft()
        else:
            ans+=c[0]
            c.popleft()
    else:
        ans+=ali[0]
        ans+=bobi[0]
        ali.popleft()
        bobi.popleft()
print(ans)
                
                
                
                
                
                

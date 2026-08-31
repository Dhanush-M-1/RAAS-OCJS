import sys
input=sys.stdin.readline
from collections import defaultdict
n,k=map(int,input().split())
c1,c2=k,k
both,al,bob=[],[],[]
co1,co2=0,0
for i in range(n):
    
    t,a,b=map(int,input().split())
    if a==1 and b==1:
        both.append(t)
        co1+=1
        co2+=1
    elif a==1:
        al.append(t)
        co1+=1
    elif b==1:
        bob.append(t)
        co2+=2
if co1<k or co2<k:
    print(-1)
    exit()
maxa=max(len(both),len(al),len(bob))
for i in range(len(both),3*k):
    both.append(1000000000000)
for i in range(len(al),3*k):
    al.append(1000000000000)
for i in range(len(bob),3*k):
    bob.append(1000000000000)
both.sort()
al.sort()
bob.sort()
#print(both,al,bob)
ans=0
i,j,k=0,0,0
while c1>0 and c2>0:
    
        
    if both[i]<=al[j]+bob[k]:
        ans+=both[i]
        c1-=1
        c2-=1
        i+=1
    else:
        ans+=al[j]
        ans+=bob[k]
        j+=1
        k+=1
        c1-=1
        c2-=1
if ans>=1000000000000:
    print(-1)
else:
    print(ans)

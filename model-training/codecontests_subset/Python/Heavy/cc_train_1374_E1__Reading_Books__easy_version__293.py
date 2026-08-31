from collections import defaultdict as dd
import sys
input=sys.stdin.readline
#n=int(input())
n,kk=map(int,input().split())
l=[]
ans=0
for i in range(n):
    time,a,b=map(int,input().split())
    l.append((time,a,b))
l.sort()
la=[]
lb=[]
do=[]
for i in l:
    time,a,b=i
    if(a and b):
        do.append(time)
    elif(a):
        la.append(time)
    elif(b):
        lb.append(time)
i=0
j=0
k=0
ca=kk
cb=kk
while ca and cb:
    if(i<len(la)):
        if(j<len(lb)):
            if(k<len(do)):
                if(la[i]+lb[j]<=do[k]):
                    ans+=la[i]
                    ans+=lb[j]
                    i+=1
                    j+=1
                    ca-=1
                    cb-=1
                    
                else:
                    ans+=do[k]
                    k+=1
                    ca-=1
                    cb-=1
            else:
                ans+=la[i]
                ans+=lb[j]
                i+=1
                j+=1
                ca-=1
                cb-=1
        else:
            if(k<len(do)):
                ans+=do[k]
                k+=1
                ca-=1
                cb-=1
            else:
                break
    else:
        if(k<len(do)):
            ans+=do[k]
            k+=1
            ca-=1
            cb-=1
        else:
            break
if(ca or cb):
    print(-1)
else:
    print(ans)
       

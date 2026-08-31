from collections import deque
import sys
def inp():
    return sys.stdin.readline().strip()
for _ in range(1):
    n,k=map(int,inp().split())
    l=[]
    a=[]
    b=[]
    for i in range(n):
        ti,ai,bi=map(int,inp().split())
        if ai==0 and bi==0:
            continue
        elif ai==0:
            b.append(ti)
        elif bi==0:
            a.append(ti)
        else:
            l.append(ti)
    if len(a)+len(l)<k or len(b)+len(l)<k:
        print(-1)
        continue
    a.sort()
    b.sort()
    l.sort()
    p1=p2=p3=0
    req=min(max(k-len(a),0)+max((k-(len(b)+max(k-len(a),0))),0),len(l))
    ra=rb=req
    p3=req
    t=sum(l[:req])
    while ra<k or rb<k:
        if p3==len(l):
            if ra<k:
                ra+=1 
                t+=a[p1]
                p1+=1 
            if rb<k:
                rb+=1 
                t+=b[p2]
                p2+=1 
            continue
        elif ra==k:
            rb+=1
            if (p2==len(b) and p1-1>=0 and p1-1<len(a))or p1-1>=0 and p1-1<len(a) and l[p3]<b[p2]+a[p1-1]:
                t+=l[p3]-a[p1-1]
                p3+=1 
                p1-=1
            elif p2==len(b) or l[p3]<b[p2]:
                t+=l[p3]
                p3+=1 
            else:
                t+=b[p2]
                p2+=1
        elif rb==k:
            ra+=1
            if (p1==len(a) and p2-1>=0 and p2-1<len(b)) or p2-1>=0 and p2-1<len(b) and l[p3]<b[p2-1]+a[p1]:
                t+=l[p3]-b[p2-1]
                p3+=1 
                p2-=1
            elif p1==len(a) or l[p3]<a[p1]:
                t+=l[p3]
                p3+=1 
            else:
                t+=a[p1]
                p1+=1 
        else:
            if p1==len(a) or p2==len(b) or l[p3]<a[p1]+b[p2]:
                t+=l[p3]
                p3+=1
                if ra<k:
                    ra+=1 
                if rb<k:
                    rb+=1
            else:
                ra+=1 
                rb+=1 
                t+=a[p1]
                t+=b[p2]
                p1+=1 
                p2+=1 
    print(t)        
            
    
    
            
    
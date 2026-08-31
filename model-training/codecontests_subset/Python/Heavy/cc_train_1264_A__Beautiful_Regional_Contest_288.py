from collections import defaultdict as dd
import sys
input=sys.stdin.readline
t=int(input())
while t:
    n=int(input())
    d=dd(int)
    l=list(map(int,input().split()))
    mi=n//2
    for i in l:
        d[i]+=1
    l=set(l)
    l=list(l)
    l.sort(reverse=True)
    g,s,b=0,0,0
    g=d[l[0]]
    n=len(l)
    ind=0
    for i in range(1,n):
        s=s+d[l[i]]
        if(s>g):
            ind=i+1
            break
    if(ind<n):
        b=d[l[ind]]
        ind+=1
    su=g+s+b
    #print(mi,su,ind,g,s,b)
    while ind<n and d[l[ind]]+su<=mi:
        b+=d[l[ind]]
        su+=d[l[ind]]
        ind+=1
        #print(
    if(g<s and g<b and g!=0 and s!=0 and b!=0 and su<=mi):
        print(g,s,b)
    else:
        print(0,0,0)
    t-=1

import sys
import math
input=sys.stdin.readline
t=int(input())
#t=1
for _ in range(t):
    #n,r=map(int,input().split())
    n=int(input())
    l=list(map(int,input().split()))
    d={}
    l1=[]
    for i in l:
        if d.get(i,-1)==-1:
            l1.append(0)
        d[i]=d.get(i,0)+1
        l1[-1]=d[i]
    n1=len(l1)
    g,s,b=0,0,0
    ind=-1
    suma=0
    lmt=math.ceil(n/2)
    
    for i in range(n1-1,-1,-1):
        suma+=l1[i]
        if suma>=lmt:
            ind=i
            break
    #print(11,lmt,ind,l1)    
    if ind!=-1:
        g_c=l1[0]
        s_c,b_c=0,0
        for i in range(1,ind):
            s_c+=l1[i]
            if s_c>g_c:
                b_c=sum(l1[i+1:ind])
                break
        if g_c<b_c and s_c>g_c:
            print(g_c,s_c,b_c)
        else:
            print(0,0,0)
    else:
        print(0,0,0)        
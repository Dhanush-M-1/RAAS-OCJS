import sys
input=sys.stdin.readline
t=int(input())
for ii in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    p=[]
    for i in range(n):
        if i==0:
            if l[i]!=-1 and l[i+1]==-1:
                p.append(l[i])
        elif i==n-1:
            if l[i]!=-1 and l[i-1]==-1:
                p.append(l[i])
        else:
            if l[i]!=-1 and (l[i-1]==-1 or l[i+1]==-1):
                p.append(l[i])
    if len(p)==0:
        z=0
    else:
        z=(max(p)+min(p))//2
    a=0
    for i in range(n):
        if l[i]==-1:
            l[i]=z
    for i in range(n-1):
        a=max(a,abs(l[i]-l[i+1]))
    print(a,z)
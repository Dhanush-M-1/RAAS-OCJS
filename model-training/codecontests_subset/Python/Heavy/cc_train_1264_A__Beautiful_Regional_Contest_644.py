MOD = 1000000007
ii = lambda : int(input())
si = lambda : input()
dgl = lambda : list(map(int, input()))
f = lambda : map(int, input().split())
il = lambda : list(map(int, input().split()))
ls = lambda : list(input())
for _ in range(ii()):
    n=ii()
    l=il()
    d=dict()
    for i in l:
        if not i in d:
            d[i]=1
        else:
            d[i]+=1
    lsrt=sorted(list(set(l)),reverse=True)
    g=s=b=0
    cnt=0
    for i in lsrt:
        if cnt+d[i]>(n//2):
            break
        if g==0:
            g+=d[i]
        elif s<=g:
            s+=d[i]
        else:
            b+=d[i]
        cnt+=d[i]
    if g<s and g<b:
        print(g,s,b)
    else:
        print(0,0,0)

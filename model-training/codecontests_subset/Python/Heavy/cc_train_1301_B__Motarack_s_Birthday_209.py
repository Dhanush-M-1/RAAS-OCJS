MOD = 1000000007
MOD2 = 998244353
ii = lambda : int(input())
si = lambda : input()
dgl = lambda : list(map(int, input()))
f = lambda : map(int, input().split())
il = lambda : list(map(int, input().split()))
ls = lambda : list(input())
for _ in range(ii()):
    n=ii()
    l=il()
    mx=-10**10
    mn=10**10
    mxd=-10**10
    for i in range(n-1):
        if l[i+1]!=-1 and l[i]!=-1:
            mxd=max(mxd,abs(l[i]-l[i+1]))
        elif l[i]==-1 and l[i+1]!=-1:
            mx=max(mx,l[i+1])
            mn = min(mn,l[i+1])
        elif l[i]!=-1 and l[i+1]==-1:
            mx=max(mx,l[i])
            mn=min(mn,l[i])
    if mxd==-10**10:
        if mx==-10**10 and mn==10**10:
            print(0,1)
        else:
            print((mx-mn+1)//2,(mx-mn+1)//2+mn)
    else:
        x=max(mxd,(mx-mn+1)//2)
        print(x,mn+x)

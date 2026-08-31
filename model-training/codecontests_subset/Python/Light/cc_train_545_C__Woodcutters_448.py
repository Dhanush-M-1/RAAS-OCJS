MOD = 1000000007
MOD2 = 998244353
ii = lambda : int(input())
si = lambda : input()
dgl = lambda : list(map(int, input()))
f = lambda : map(int, input().split())
il = lambda : list(map(int, input().split()))
ls = lambda : list(input())
c=1
n=ii()
ht,xcr=[],[]
for i in range(n):
    a,b=f()
    xcr.append(a)
    ht.append(b)
gap=[xcr[i]-xcr[i-1] for i in range(1,n)]
gap=[10**11]+gap+[10**11]
for i in range(1,n):
    if ht[i]<gap[i]:
        c+=1
    elif ht[i]<gap[i+1]:
        c+=1
        gap[i+1]-=ht[i]
print(c)
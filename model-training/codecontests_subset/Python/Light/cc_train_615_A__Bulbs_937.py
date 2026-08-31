"""
instagram : essipoortahmasb2018
telegram channel : essi_python

"""
n,m=map(int,input().split())
a=[0 for i in range(m+1)]
for i in range(n):
    l=list(map(int,input().split()))
    for j in range(l[0]):
        a[l[j+1]]=1
print("YES" if a.count(0)==1 else "NO")
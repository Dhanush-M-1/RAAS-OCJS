n,m = map(int,input().split())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
x=0
a1={}
b1={}
l,p=[],[]
for i in set(a):
    y = a.count(i)
    a1[i]=y
    l.append([y,i])
for i in set(b):
    y = b.count(i)
    b1[i]=y
    p.append([y,i])
l.sort()
p.sort()
h=[]
d=[]
if a1!=b1:
    j=len(l)-1
    k = l[j][0]
    for i in range(j,-1,-1):
        if p[i][0]==k:
            d.append(p[i][1])
            h.append(l[i][1])
        else:
            break
    h.sort()
    d.sort()
    x=m+1
    for i in range(len(h)):
        k = (d[0]-h[i])%m
        if sorted([(j+k)%m for j in h])==d:
            x = min(x,k)
print(x)
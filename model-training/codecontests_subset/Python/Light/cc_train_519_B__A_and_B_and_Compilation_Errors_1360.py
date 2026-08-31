n=int(input())
a=[int(i) for i in input().split()]
a.sort()
b=[int(i) for i in input().split()]
b.sort()
c=[int(i) for i in input().split()]
c.sort()
o=[]
for i in range(n-1):
    if a[i]!= b[i]:
        o.append(a[i])
        break
if len(o)==0:
    o.append(max(a))
for i in range(n-2):
    if b[i]!=c[i]:
        o.append(b[i])
        break
if len(o)==1:
    o.append(max(b))   
for i in range(2):
    print(o[i])
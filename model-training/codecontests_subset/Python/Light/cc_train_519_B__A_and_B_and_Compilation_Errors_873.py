a=int(input())
b=input().split()
c=input().split()
e=input().split()
f=len(b)
h=len(c)
g=len(e)
m=0
n=0
o=0
i=0
j=0
k=0
if(a==f):
    for i in range(f):
        v=int(b[i])
        m=m+v
if((a-1)==h):
    for j in range(h):
        z=int(c[j])
        n=n+z
if((a-2)==g):
    for k in range(g):
        y=int(e[k])
        o=o+y
print(m-n)
print(n-o)

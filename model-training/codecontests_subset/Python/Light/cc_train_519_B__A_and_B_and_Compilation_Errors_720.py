n=int(input())
a=input().split()
b=input().split()
c=input().split()
x=0
while x<len(a):
    a[x]=int(a[x])
    x=x+1
a.sort()
x=0
while x<len(b):
    b[x]=int(b[x])
    x=x+1
b.sort()
x=0
while x<len(c):
    c[x]=int(c[x])
    x=x+1
c.sort()
x=0
y=0
z=0
while x<len(b):
    if a[x]!=b[x]:
        y=a[x]
        break
    x=x+1
    if x==len(b):
        y=a[x]
x=0
while x<len(c):
    if b[x]!=c[x]:
        z=b[x]
        break
    x=x+1
    if x==len(c):
        z=b[x]
print(y)
print(z)
        

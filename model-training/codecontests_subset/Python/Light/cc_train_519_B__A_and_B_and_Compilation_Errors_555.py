n=int(input())
a=[int(x) for x in input().split()]
b=[int(x) for x in input().split()]
c=[int(x) for x in input().split()]
x,y,z=[0,0,0]
for i in a:
    x=x+i
for i in b:
    y=y+i
for i in c:
    z=z+i
print(x-y)
print(y-z)

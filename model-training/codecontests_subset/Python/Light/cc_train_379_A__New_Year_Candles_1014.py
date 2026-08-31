a,b=[int(i) for i in input().split()]
n=a
x=a
y=0
for i in range(2000):
    z=x+y
    x=z//b
    y=z%b
    if x==0:
        break
    else:
        n+=x
print(n)

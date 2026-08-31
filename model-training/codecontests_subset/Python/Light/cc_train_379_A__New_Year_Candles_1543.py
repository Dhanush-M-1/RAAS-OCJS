a,b=[int(i) for i in input().split()]
t=a
c=0
while t!=0:
    c=c+1
    t=t-1
    if c%b==0:
        t=t+1
print(c)

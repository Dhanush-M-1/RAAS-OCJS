a,b=[int(i) for i in input().split()]
r=a
while (a//b >0):
    r=r+(a//b)
    a=a%b+a//b;
print(r)
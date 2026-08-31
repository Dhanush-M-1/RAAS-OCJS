a,b=[int(x) for x in input().split()]
s=a
t=a
while t//b>0:
    s=s+t//b
    t=t//b+t%b
print(s)

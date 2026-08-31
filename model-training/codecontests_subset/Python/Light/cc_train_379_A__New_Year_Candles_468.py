a,b=[int(x) for x in input().split()]
hours=a
c=a//b
while c>0:
    hours+=c
    a=a//b+a%b
    c=a//b
print(hours)
a,b=[int(x) for x in input().split()]
hours=0
while(a>=b):
    hours=hours+(a//b)*b
    a=a//b + a%b
else:
    hours=hours+a
print(hours)


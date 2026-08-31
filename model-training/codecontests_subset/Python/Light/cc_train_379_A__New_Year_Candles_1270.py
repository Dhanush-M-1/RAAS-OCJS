a,b=[int(x) for x in input().split()]
hour=a
while a>=b:
    c=a//b
    hour+=c
    a=a-(a//b)*b+c
print(hour)

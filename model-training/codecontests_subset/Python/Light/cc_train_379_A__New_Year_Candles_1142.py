import math
a,b=[int(i) for i in input().split()]
jieguo=a
for i in range(a):

    if a/b>=1.0:
        c=math.floor(a/b)
        a=a-c*b+c
        jieguo=jieguo+c
print(jieguo)



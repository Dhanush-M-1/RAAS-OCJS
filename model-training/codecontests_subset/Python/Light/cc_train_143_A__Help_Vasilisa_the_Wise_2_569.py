x = []
for i in range(3):
    x += [int(x) for x in input().split()]
a = (x[0]+x[2]-x[5])//2

c = x[2] - a
b = x[0] - a
d = x[3] - b

if (a+d==x[4]) and (c+d==x[1]) and (a!=b) and (a!=c) and (a!=d) and (b!=c) and (b!=d) and (c!=d) and (9>=a>=1) and (9>=b>=1) and (9>=c>=1) and (9>=d>=1):
    print(a,b)
    print(c,d)
else:
    print(-1)    

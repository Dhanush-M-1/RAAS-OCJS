x,y,z=[int(i) for i in input().split()]
a=y**2-4*x*z
if x==0 and y==0 and z==0:
    print(-1)
elif x==0 and y==0:
    print(0)
elif x==0:
    print(1)
    print(-z/y)
elif a<0:
    print(0)
elif a==0:
    print(1)
    print(-y/(2*x))
else:
    print(2)
    y=y/x
    a=a/(x**2)
    print((-y-a**0.5)/2)
    print((-y+a**0.5)/2)
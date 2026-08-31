a,b=[int(x) for x in input().split()]
x=a
while a>=b:
    p=a//b
    q=a-b*(a//b)
    x=x+p
    a=p+q
else:
    print(x)

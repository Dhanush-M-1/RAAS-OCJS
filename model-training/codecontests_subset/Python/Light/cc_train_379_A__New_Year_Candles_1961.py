def f(a,b):
    d=0
    while a!=0:
        if a>=b:
            k=int(a//b)
            d+=k*b
            a=a+k-b*k
        else:
            d+=a
            a=0
    return d
a,b=list(int(x) for x in input().split())
print(f(a,b))
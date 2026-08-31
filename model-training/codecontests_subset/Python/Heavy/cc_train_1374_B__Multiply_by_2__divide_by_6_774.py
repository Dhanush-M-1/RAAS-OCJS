t=int(input())
def pow_3(n):
    c=0
    while type(n)==int:
        if n%3==0:
            n=n//3
            c+=1
        else:
            n=n/3
    return c
def pow_2(n):
    c=0
    while type(n)==int:
        if n%2==0:
            n=n//2
            c+=1
        else:
            n=n/2
    return c
for _ in range(t):
    n=int(input())
    c1=pow_3(n)
    c2=pow_2(n)
    if c1<c2:
        print("-1")
    else:
        d=c1-c2
        if n==(3**c1)*(2**c2):
            print(d+c1)
        else:
            print("-1")

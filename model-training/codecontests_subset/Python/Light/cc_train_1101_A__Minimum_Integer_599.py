n=int(input())
while n>0:
    a,b,d=input().split(" ")
    a=int(a)
    b=int(b)
    d=int(d)
    lst=range(a,b+1)
    if d not in lst:
        print(d)
    else:
        q=b%d
        print(b+d-q)
    n-=1
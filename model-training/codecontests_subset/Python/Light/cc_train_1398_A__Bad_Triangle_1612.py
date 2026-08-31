t=int(input())

while t:
    n=int(input())

    a=list(map(int,input().split()))

    x=a[0]
    y=a[1]
    z=a[-1]

    if x+y<=z:
        print (1,2,n)
    else:
        print (-1)



    t=t-1
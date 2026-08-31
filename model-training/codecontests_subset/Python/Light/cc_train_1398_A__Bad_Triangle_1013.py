for _ in range(int(input())):
    n=int(input())
    # flag=0
    a=list(map(int,input().split()))
    x=a[0]
    s1=1
    # a.remove(x)
    y=a[1]
    s2=2
    # a.remove(y)
    z=a[-1]
    s3=n
    # a.remove(z)
    #print(x,y,z)

    if len(set(a))!=1 and x+y<=z or y+z<=x or x+z<=y:
        print(s1,s2,s3)
    else:
        print(-1)

